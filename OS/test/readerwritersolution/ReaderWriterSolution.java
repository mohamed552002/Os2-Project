//package readerwritersolution;
//
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class ReaderWriterSolution {
//
//    static buffer buf = new buffer();
//    
//    public static void main(String[] args) 
//    {   
//        Scanner sc = new Scanner (System.in);
//        
//        System.out.print("Initial Buffer Content : ");
//        String Ini_buf_Content = sc.nextLine();
//        System.out.println();
//        
//        System.out.print("Number of reader threads : ");
//        int num_of_readers = sc.nextInt(); 
//        System.out.println();
//        
//        System.out.print("Number of writer threads : ");
//        int num_of_writers = sc.nextInt(); 
//        System.out.println();  
//        
//        buf.initialize_buffer(Ini_buf_Content);
//        Thread[] readerArray = new Thread[num_of_readers];
//        Thread[] writerArray = new Thread[num_of_writers];
//        
//        System.out.println("Reader Threads: ");
//       
//        for (int i=0; i<num_of_readers ; i++)
//        {
//            String thr_name = sc.next();
//            readerArray[i] = new Thread (new Reader(buf));
//            readerArray[i].setName(thr_name);
//            semaphore.readers_names.add(thr_name);
//        }
//        
//        System.out.println("Writer Threads: ");
//        
//        for (int i=0 ; i<num_of_writers ; i++)
//        {
//            String thr_name = sc.next();
//            String text = sc.next();
//            writerArray[i] = new Thread (new Writer(buf , text));
//            writerArray[i].setName(thr_name);
//            semaphore.Writers_names.add(thr_name);
//        }
//        
//        
//        for (int i=0 ; i<num_of_readers ; i++)
//        {
//            readerArray[i].start();
//        }
//        
//        for (int i=0 ; i<num_of_writers ; i++)
//        {
//            writerArray[i].start();
//        }
//        
//    }
//    
//}