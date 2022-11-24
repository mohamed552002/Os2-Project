package ReadersWritersProblem;

public class ReadersWritersProblemTest {
    public static void main(String[] args) throws Exception {
        ReadersWritersProblem.Read read = new ReadersWritersProblem.Read();
        ReadersWritersProblem.Write write = new ReadersWritersProblem.Write();
        Thread t1 = new Thread(write);
        t1.setName("thread1");
        Thread t2 = new Thread(write);
        t2.setName("thread2");
        Thread t3 = new Thread(read);
        t3.setName("thread3");
        Thread t4 = new Thread(read);
        t4.setName("thread4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}
