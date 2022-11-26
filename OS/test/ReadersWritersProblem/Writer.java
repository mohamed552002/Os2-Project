package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.file;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import java.io.*;

class Writer implements Runnable { // Writing Process

    BufferedWriter objWriter;
    @Override
    public void run() {
        try {
            writeLock.acquire(); //wait(rw_mutex)
            System.out.println("Thread "+Thread.currentThread().getName() + " is writing");
                
            if(!file.exists()){
                
                try {
                    file.createNewFile();
                } catch(IOException e){
                    return;
                }
            }
            
            try {
                                   
                FileOutputStream fos = new FileOutputStream(path, true);
                fos.write("Spain\r\n".getBytes());
                fos.close();

            }catch (Exception e){
                 return;
            }
                
            System.out.println("Thread "+Thread.currentThread().getName() + " has finished writing");
            writeLock.release(); //signal(rw_mutex)
                
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
