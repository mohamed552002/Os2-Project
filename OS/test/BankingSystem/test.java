package BankingSystem;
import java.util.*;

public class test {
    public static void main(String[] args){
        
//        ArrayList<String> a = new ArrayList();
        
//        a.add("SSN");
//        a.add("first_name");
//        a.add("last_name");
//        a.add("phone");
//        a.add("address");
//        a.add("current_balance");
//        a.add("status");
//        DBContext.DBopen();
        
//        DBContext.Tblcreation("CREATE TABLE client("
//                + "client_id INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + " SSN CHAR(50) UNIQUE,"
//                + " first_name CHAR(50),"
//                + " last_name CHAR(50),"
//                + " phone CHAR(50) UNIQUE,"
//                + " address CHAR(50),"
//                + " age CHAR(50),"
//                + " gender INTEGER,"
//                + " current_balance INTEGER,"
//                + " status CHAR(50) );"
//        );
//        DBContext.Insertion(
//        "INSERT INTO client (SSN, first_name, last_name, phone, address, age, gender, current_balance, status) "
//      + "VALUES('30207827834', 'Ahmed', 'Omar', '01069083521', '23 Mohamed Ali ST.', 28, 'Male', 9000, 'ACTIVE')");

//        DBContext.Tblcreation("CREATE TABLE account(account_id INTEGER PRIMARY KEY AUTOINCREMENT, card_number CHAR(20) UNIQUE, CVC INT UNIQUE, current_balance INT, status CHAR(50), cid INT ,FOREIGN KEY(cid) REFERENCES client(client_id));");
//        DBContext.Insertion("INSERT INTO account (card_number, CVC, current_balance, status, cid) VALUES('1234567', 1234, 1500, 'ACTIVE', 1)");
//        
        //DBContext.update("update customer set name = 'ahmed' where id = 2");
//        
//        DBContext.delete("delete from customer where id = 1");
//       DBContext.select("client", a);
//        DBContext.DBclose();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter ID: ");
//        int id = sc.nextInt();
//        System.out.println("Enter deposit: ");
//        int deposit = sc.nextInt();
        
//        UpdateBalance.Withdraw(3000, 2);
        ReadBalance r = new ReadBalance();
        System.out.println(r.Read());
    }

}
