package BankingSystem;
import static BankingSystem.SharedVariables.writeLock;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UpdateBalance {
    public static void Withdraw(int withdraw, int id) {
        try {
            writeLock.acquire();
            
            DBContext.DBopen();
            String currentBalance;
            int newBalance = 0;
            DBContext db = new DBContext();
            currentBalance = db.returnBalance("client", id);
            int currentBalanceInteger = Integer.parseInt(currentBalance);
            if (currentBalanceInteger >= withdraw)
                newBalance = currentBalanceInteger - withdraw;
            else
                System.out.println("There is no enough money");
            DBContext.update("UPDATE client SET current_balance = " +
                    newBalance + " WHERE client_id = " + id);
            DBContext.DBclose();
            writeLock.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateBalance.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public static void Deposit(int deposit, int id){
        try {
            writeLock.acquire();
            DBContext.DBopen();
            String currentBalance;
            DBContext db = new DBContext();
            currentBalance = db.returnBalance("client", id);
            int currentBalanceInteger = Integer.parseInt(currentBalance);
            int newBalance = currentBalanceInteger + deposit;
            DBContext.update("UPDATE client SET current_balance = " +
                    newBalance + " WHERE client_id = " + id);
            DBContext.DBclose();
            writeLock.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateBalance.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
