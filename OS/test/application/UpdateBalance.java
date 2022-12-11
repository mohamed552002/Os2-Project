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
    
    public static void Withdraw(TextField withdraw, TextField id) {
//        try {
//            writeLock.acquire();
            int w = getIntFromTextField(withdraw);
            int ID = getIntFromTextField(id);
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
            else
                System.out.println("There is no enough money");
            
            DBContext.DBclose();
//            writeLock.release();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(UpdateBalance.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
    }
    
    public static void Deposit(TextField deposit, TextField id){
//        try {
//            writeLock.acquire();
            int d = getIntFromTextField(deposit);
            int ID = getIntFromTextField(id);
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