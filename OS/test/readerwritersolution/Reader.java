package readerwritersolution;


class Reader extends Thread {

	buffer buf;

        
	public Reader(buffer buf  ) 
        {       
		this.buf = buf ;
              
	}

	public void run() 
        {   
            buf.read();
	}

}