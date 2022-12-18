package ReadersWritersProblem;
import java.util.concurrent.Semaphore;
import java.io.*;
public class ReadersWritersProblem {
    static Semaphore readLock = new Semaphore(1); 
    static Semaphore writeLock = new Semaphore(1);
    static Semaphore in_mutex = new Semaphore(1);
    static int readCount = 0;
    static String path = "test.txt";
    static File file = new File(path);
}