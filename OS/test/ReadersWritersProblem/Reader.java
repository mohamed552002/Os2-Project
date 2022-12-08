package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.readCount;
import static ReadersWritersProblem.ReadersWritersProblem.writeCount;
import static ReadersWritersProblem.ReadersWritersProblem.readLock;
import static ReadersWritersProblem.ReadersWritersProblem.readLock2;
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
            
            if (writeCount == 1) {
                writeLock.release(); 
                readLock2.acquire(); 
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
            
            if (writeCount == 0) {
                writeLock.release(); 
                readLock2.acquire(); 
            }
            readLock.release();
            
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
   
    }
}