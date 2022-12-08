package ReadersWritersProblem;
public class ReadersWritersProblemTest {
    public static void main(String[] args) throws Exception {
        
        Reader r = new Reader();
        Writer w = new Writer();
            
        Thread t1 = new Thread(r, "thread1");
        Thread t2 = new Thread(w, "thread2");
//        Thread t3 = new Thread(r, "thread3");
//        Thread t4 = new Thread(r, "thread4");
        
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
        
        t1.join();
        t2.join();
//        t3.join();
//        t4.join();   
    }
}
