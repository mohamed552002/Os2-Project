package ReadersWritersProblem;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author ZED
 */
public class ThreadManager extends Thread {
    
    public void run() {
        try {
            BufferedReader br = null;
            String line;
            String fileName = "threadLog.txt";
            ArrayList<String> fileLines = new ArrayList<String>();
            int numLine = 0;

            File file = new File("threadLog.txt");

            // input
            FileInputStream fis = null;
            PrintWriter out = null;

   //From here is a critical section

            fis = new FileInputStream(fileName);
            
            //FileIutputStream read
            //FileOutputStream write
            
            // output
            FileOutputStream fos = new FileOutputStream(file);
            out = new PrintWriter(fos);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            try {
                while ((line = in.readLine()) != null) {
                    fileLines.add(line);
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            if (!fileLines.isEmpty()) {
                int middleLine = (int) Math.round(fileLines.size() / 2);
                fileLines.add(middleLine, Thread.currentThread().getName());

                for (int i = 0; i < fileLines.size(); i++) {
                    out.println(fileLines.get(i));
                }

                out.flush();
                out.close();
                try {
                    in.close();
                    new File(fileName).delete();
                    file.renameTo(new File(fileName));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

//end critical section
            }
        }catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }
}