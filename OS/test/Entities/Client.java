package Entities;

public class Client {
    private int ID;
    private String FName;
    private String LName;
    private String phone;
    private String address;
    private String cardNum;
    private String CCV;
    private double currentBalance;
    private String SSN;

    public Client(int ID, String FName, String LName, String phone, String address, String cardNum, String CCV, double currentBalance, String SSN) {
        this.setID (ID);
        this.setFName(FName);
        this.setLName(LName);
        this.setPhone(phone);
        this.setAddress(address);
        this.setCardNum(cardNum);
        this.setCCV(CCV);
        this.setCurrentBalance(currentBalance);
        this.setSSN(SSN);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCCV() {
        return CCV;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
     
    
}
