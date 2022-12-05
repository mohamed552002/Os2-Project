
package ReadersWritersProblem;
import java.util.*;
public class ReadersWritersProblemTest {
    public static void main(String[] args) throws Exception {
        
DBContext.DBopen();
String sql = "CREATE TABLE COMPANY " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " + 
                        " AGE            INT     NOT NULL, " + 
                        " ADDRESS        CHAR(50), " + 
                        " SALARY         REAL," + 
                        "CCNUMBER     CHAR(12)," +
                        "CCV     CHAR(3))"; 
//String sql2 = "INSERT INTO COMPANY(ID , NAME , AGE,ADDRESS,SALARY,CCNUMBER,CCV) VALUES(2,'Mohamed',23,'masr',300.00,'12345678912','121')";
//String sql3 = "UPDATE COMPANY set NAME = 'Naguib' WHERE ID = 1";
String sql4 = "DELETE FROM COMPANY WHERE ID = 2";
//DBContext.Insertion(sql2);
DBContext.delete(sql4);
//DBContext.selectAll("company");
//DBContext.update(sql3);
ArrayList<String> g = new ArrayList();
g.add("id");g.add("name");
DBContext.select("company",g);
//        System.out.println(g.get("id"));
//                for (Enumeration k = g.keys(); k.hasMoreElements();)
//        {
//            g.put(k.nextElement(), "2") ;
//        }
//                System.out.println(g.get("id"));
//DBContext.DBclose();
//        Reader r = new Reader();
//        Writer w = new Writer();
//            
//        Thread t1 = new Thread(r);
//        t1.setName("thread1");
//
//        Thread t2 = new Thread(r);
//        t2.setName("thread2");
//
//        
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        
    }
}
