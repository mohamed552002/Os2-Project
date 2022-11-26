package ReadersWritersProblem;
public class ReadersWritersProblemTest {
    public static void main(String[] args) throws Exception {
        
        Reader r = new Reader();
        Writer w = new Writer();
            
        Thread t1 = new Thread(r);
        t1.setName("thread1");
        Thread t2 = new Thread(r);
        t2.setName("thread2");
        Thread t3 = new Thread(r);
        t3.setName("thread2");
        
        t1.start();
        t2.start();
        //t3.start();
        
    }
}
