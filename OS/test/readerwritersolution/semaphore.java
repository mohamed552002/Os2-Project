package readerwritersolution;

import java.util.ArrayList;

class semaphore 
{
    private static int control_value;
    public static ArrayList<String> readers_names = new  ArrayList<String> ();
    public static ArrayList<String> Writers_names = new  ArrayList<String> ();
    
    public semaphore() 
    { 
        control_value = 0;
    }
    
    public int get_value ()
    {
        return control_value ;
    }
    
    public semaphore(int initial_value ) 
    { 
        control_value = initial_value ;
    }
    
    
    public boolean isReader (String name)
    {
        for (int i=0 ; i<readers_names.size() ; i++)
        {
            if (readers_names.get(i).equals(name))
                return true ;
        }
        
        return false;
    }
    
    public boolean isWriter(String name)
    {   
        for (int i=0 ; i<Writers_names.size() ; i++)
        {  
            if (Writers_names.get(i)==(name))
                return true ;
        }
        
        return false;
    }
    
    public  void Wait ( int operation )
    {   
        control_value--;
        
        if ( control_value < 0) 
        {    
            String cur_thread_name = Thread.currentThread().getName() ;
            
            if (operation == 1) 
            System.out.println( cur_thread_name + " Blocked " );
            
            if (operation == 3)
            {
                if (isWriter(cur_thread_name))
                System.out.println( Thread.currentThread().getName() + " Blocked ");    
            }
                
            try 
            {   
                wait();
             
            } 
            catch (Exception e) 
            {
            }
        }
    }
    
    public  void Signal ()
    {

        control_value++;
        
        if( control_value <=0)
        {  try 
            {  
                notify();
             
            } 
            catch (Exception e) 
            {
            }
        }
        
    }
   
}