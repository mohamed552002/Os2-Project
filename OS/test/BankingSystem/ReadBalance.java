package BankingSystem;
import static BankingSystem.SharedVariables.readCount;
import static BankingSystem.SharedVariables.readLock;
import static BankingSystem.SharedVariables.writeLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class ReadBalance {
    public static String Read(){
        try {
            String s;
            ArrayList<String> a = new ArrayList();
            a.add("client_id");
            a.add("SSN");
            a.add("first_name");
            a.add("last_name");
            a.add("current_balance");
            a.add("status");
            
            readLock.acquire();
            readCount++;
            if (readCount == 1) {
                writeLock.acquire();
            }
            readLock.release();
            DBContext.DBopen();
            DBContext db = new DBContext();
            s = db.returnAccount("client", a);
            DBContext.DBclose();
            
            readLock.acquire();
            readCount--;
            if(readCount == 0) {
                writeLock.release();
            }
            readLock.release();
            return s;
        } catch (InterruptedException ex) {
            Logger.getLogger(ReadBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}