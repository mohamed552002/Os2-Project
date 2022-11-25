package ReadersWritersProblem;
import static ReadersWritersProblem.ReadersWritersProblem.readCount;
import static ReadersWritersProblem.ReadersWritersProblem.readLock;
import static ReadersWritersProblem.ReadersWritersProblem.writeLock;
import static ReadersWritersProblem.ReadersWritersProblem.file;
import static ReadersWritersProblem.ReadersWritersProblem.path;
import java.io.*;

class  Reader implements Runnable { // Writing Process
    //BufferedReader objReader;
    @Override
    public void run() {
        try {
            //Acquire Section
            readLock.acquire(); //wait(mutex)
            readCount++;    
            if (readCount == 1) {
                writeLock.acquire(); //wait(rw_mutex)
            }
            
            readLock.release(); //signal(mutex)
                
            //Reading section
            System.out.println("Thread "+Thread.currentThread().getName() + " is reading");
            if(!file.exists()){
                System.out.println("The path " + path + " is not exists");
                return ;
            }
            try {
                FileInputStream fin =new FileInputStream(path);    
                int i = 0;  
                while((i=fin.read())!=-1){    
                    System.out.print((char)i);    
                }      
                fin.close();    
                /**objReader = new BufferedReader(new FileReader(path));
                while ((objReader.ready())) {
                    System.out.println(objReader.readLine());
                }**/
            }catch (Exception e){
                return;  
            }
           
            System.out.println("Thread "+Thread.currentThread().getName() + " has finished reading");
            
            //Releasing section
            readLock.acquire(); //wait(mutex)
            readCount--;
                if(readCount == 0) {
                    writeLock.release(); //signal(rw_mutex)
            }
            readLock.release(); //signal(mutex)
            
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
   
    }
}
