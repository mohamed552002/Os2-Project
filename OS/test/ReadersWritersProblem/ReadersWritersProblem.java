package ReadersWritersProblem;
import java.util.concurrent.Semaphore;
import java.io.*;
class ReadersWritersProblem {
    static Semaphore readLock = new Semaphore(1); 
    static int readCount = 0; // how many processes reading object
    static int writeCount = 0;
    static Semaphore writeLock = new Semaphore(1);
    static Semaphore readLock2 = new Semaphore(1); 
    static String path = "test.txt";
    static File file = new File(path);
}