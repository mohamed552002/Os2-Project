package ReadersWritersProblem;
public class ReadersWritersProblemTest {
    public static void main(String[] args) throws Exception {
        
        Reader r = new Reader();
        Writer w = new Writer();
        
        Thread t1 = new Thread(r, "thread1");
        Thread t2 = new Thread(r, "thread2");
        Thread t3 = new Thread(w, "thread3");
        Thread t4 = new Thread(r, "thread4");
        Thread t5 = new Thread(w, "thread5");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
}
