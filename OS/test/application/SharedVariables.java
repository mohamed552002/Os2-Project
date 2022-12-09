package application;
import Entities.Client;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SharedVariables {
    static Semaphore readLock = new Semaphore(1); 
    static Semaphore writeLock = new Semaphore(1);
   static int readCount = 0;
}
