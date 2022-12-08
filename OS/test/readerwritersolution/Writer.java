package readerwritersolution;

class Writer extends Thread {

	buffer buf;
        String text ;
        
	public Writer(buffer buf , String text) 
        {
		this.buf = buf ;
                this.text = text ;
	}

	public void run() 
        {   
            buf.write( text);
	}

}