package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.file;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import static ReadersWritersProblem.ReadersWritersProblem.writeCount;
import java.io.*;

class Writer implements Runnable { // Writing Process

    @Override
    public void run() {
        try {
            writeLock.acquire(); //wait(rw_mutex)
            writeCount++;
            
            System.out.println("Thread "+Thread.currentThread().getName() + " is writing");
            if(!file.exists()){
                
                try {
                    file.createNewFile();
                } catch(IOException e){
                    return;
                }
            }
            
            try {                
                try (FileOutputStream fout =
                        new FileOutputStream(path, true)) {
                    fout.write("Mohamed\r\n".getBytes());
                }
            }catch (IOException e){
                 return;
            }
                
            System.out.println("Thread "+Thread.currentThread().getName() + " has finished writing");

            writeCount--;
            writeLock.release();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
