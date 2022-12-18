package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import static ReadersWritersProblem.ReadersWritersProblem.in_mutex;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Writer implements Runnable {
    @Override
    public synchronized void run() {
        try {
                in_mutex.acquire(); 
                writeLock.acquire();   
                System.out.println("Thread "+Thread.currentThread().getName() + " is writing");
                try {
                    try (FileOutputStream fout =
                            new FileOutputStream(path, true)) {
                        fout.write("Mohamed\r\n".getBytes());
                    }
                }catch (IOException e){
                    return;
                }
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished writing");
                
                writeLock.release();
                in_mutex.release(); 
        }catch (InterruptedException ex){
            Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
