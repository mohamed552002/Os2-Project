package application;
import Entities.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public  class ReadBalance {
    public static ArrayList Read(){
        try {
            ArrayList<Client> s;
            DBContext.DBopen();
            DBContext db = new DBContext();
            s = db.returnAccount();
            DBContext.DBclose();
            System.out.println(s.size());
            return s;
        } catch (Exception ex) {
            Logger.getLogger(ReadBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}