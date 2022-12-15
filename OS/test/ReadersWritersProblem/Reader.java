package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.readCount;
import static ReadersWritersProblem.ReadersWritersProblem.readLock;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import static ReadersWritersProblem.ReadersWritersProblem.file;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import java.io.*;

class Reader implements Runnable {// Writing Process
    
    public void print(String n){
        System.out.print(n + "\n");
    }
    
    @Override
    public void run() {
        try {
            readLock.acquire();
                
            readCount++;    
            if (readCount == 1) {
                writeLock.acquire(); 
            }
            readLock.release();
                
            System.out.println("Thread "+ 
                    Thread.currentThread().getName() + " is reading");
            if(!file.exists()){
                System.out.println("The path " + path + " is not exists");
                return ;
            }
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
                       
            System.out.println("Thread "+ 
                    Thread.currentThread().getName() + " has finished reading");
            
            readLock.acquire(); 
            readCount--;
            if(readCount == 0) {
                    writeLock.release();
            }
            readLock.release();
            
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
   
    }
}