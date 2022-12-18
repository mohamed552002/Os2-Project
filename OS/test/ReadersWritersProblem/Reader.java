package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.readCount;
import static ReadersWritersProblem.ReadersWritersProblem.readLock;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import static ReadersWritersProblem.ReadersWritersProblem.in_mutex;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Reader implements Runnable { 
    @Override
    public void run() {
        try {
                in_mutex.acquire();
                readLock.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire();
                }
                readLock.release();
                in_mutex.release();

                System.out.println("Thread "+ Thread.currentThread().getName() + " is reading");
                try {
                    try (FileInputStream fin = new FileInputStream(path)) {
                        int i = 0;
                        String a = "";
                        while((i=fin.read())!=-1){
                            a += (char)i;
                        }
                        System.out.println(a);
                    }
                    
                }catch (IOException e){
                    return;
                }
                System.out.println("Thread "+ Thread.currentThread().getName() + " has finished reading");

                readLock.acquire();
                readCount--;
                if(readCount == 0) {
                    writeLock.release();
                }
                readLock.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}