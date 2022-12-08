package readerwritersolution;

class buffer 
{
    protected String shared_buffer  ;
    protected int readers_counter ;
   
    protected semaphore readers_writers_mutex ;
    protected semaphore readers_mutex ; 
    
     public buffer() 
     {   
         shared_buffer = "";
         readers_counter = 0;
         readers_mutex = new semaphore(1 );
         readers_writers_mutex = new semaphore(1);
         
     }
     
     public void initialize_buffer (String text)
     {
         shared_buffer = text ;
     }
     
     public  void  write ( String append_text)
     {   
         
         System.out.println( Thread.currentThread().getName() + " Start Writing");
        
         readers_writers_mutex.Wait(1); 
         
         shared_buffer += " " ;
         shared_buffer += append_text ;
         
         System.out.println( Thread.currentThread().getName() + " writing : " + shared_buffer );
    
        

         readers_writers_mutex.Signal();
         System.out.println( Thread.currentThread().getName() + " Finished writing");


     }
     
     
     public void read (  )
     {
         
         System.out.println( Thread.currentThread().getName() + " Start Reading");
         
         readers_mutex.Wait( 2 );
       
         readers_counter++;
         
         
         if (readers_counter==1)
         {  
            
            readers_writers_mutex.Wait(3 );
         }
         
 
        readers_mutex.Signal();
        System.out.println( Thread.currentThread().getName() + " Read : " + shared_buffer);

        
        readers_mutex.Wait( 2);
        

         readers_counter--;
         
         if (readers_counter == 0)
         {   

             readers_writers_mutex.Signal();
         }
            
         
        readers_mutex.Signal();
        System.out.println(Thread.currentThread().getName() + " Finished reading" );

         
     }
     
    
}