package application;
import static application.SharedVariables.writeLock;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UpdateBalance {
    
    public static int getIntFromTextField(TextField textField) {
        String text = textField.getText();
        return Integer.parseInt(text);
    }
    
    public static boolean Withdraw(TextField withdraw, int id) {
//        try {
//            writeLock.acquire();
            int w = getIntFromTextField(withdraw);
            int ID = id;
            DBContext.DBopen();
            String currentBalance;
            int newBalance = 0;
            currentBalance = DBContext.returnBalance("client", ID);
            int currentBalanceInteger = Integer.parseInt(currentBalance);
            if (currentBalanceInteger >= w){
                newBalance = currentBalanceInteger - w;
                DBContext.update("UPDATE client SET current_balance = " +
                    newBalance + " WHERE account_id = " + ID);
            }
            else{
                System.out.println("There is no enough money");
                return false;
            }
            DBContext.DBclose();
//            writeLock.release();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(UpdateBalance.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
        return true;
    }
    
    public static void Deposit(TextField deposit, int id){
//        try {
//            writeLock.acquire();
            int d = getIntFromTextField(deposit);
            int ID = id;
            DBContext.DBopen();
            String currentBalance;
            currentBalance = DBContext.returnBalance("client", ID);
            int currentBalanceInteger = Integer.parseInt(currentBalance);
            int newBalance = currentBalanceInteger + d;
            DBContext.update("UPDATE client SET current_balance = " +
                    newBalance + " WHERE account_id = " + ID);
            DBContext.DBclose();
//            writeLock.release();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(UpdateBalance.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        
//    }
    }
}