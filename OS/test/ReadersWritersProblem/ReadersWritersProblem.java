package ReadersWritersProblem;
import java.util.concurrent.Semaphore;
import java.io.*;
class ReadersWritersProblem {
    static Semaphore readLock = new Semaphore(1); 
    static int readCount = 0; // how many processes reading object
    static Semaphore writeLock = new Semaphore(1); 
    static String path = "test.txt";
    static File file = new File(path);
}