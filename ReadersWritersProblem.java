package ReadersWritersProblem;
import java.util.concurrent.Semaphore;

class ReadersWritersProblem {

    static Semaphore readLock = new Semaphore(1); //mutex = 1
    static Semaphore writeLock = new Semaphore(1); // rw_mutex = 1
    static int readCount = 0; // how many processes reading object

    static class Read implements Runnable { //Reading Process
        @Override
        public void run() {
            try {
                readLock.acquire(); //wait(mutex)
                readCount++;    
                if (readCount == 1) {
                    writeLock.acquire(); //wait(rw_mutex)
                }
                readLock.release(); //signal(mutex)
                
                System.out.println("Thread " + Thread.currentThread().getName() + " is reading");
                Thread.sleep(2000);
                System.out.println("Thread " + Thread.currentThread().getName() + " has finished reading");

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

    static class Write implements Runnable { // Writing Process
        @Override
        public void run() {
            try {
                writeLock.acquire(); //wait(rw_mutex)
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting");
                Thread.sleep(2000);
                System.out.println("Thread " + Thread.currentThread().getName() + " has finished waiting");
                writeLock.release(); //signal(rw_mutex)
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
