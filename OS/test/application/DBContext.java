package application;
import Entities.Client;
import java.sql.*;
import java.util.*;

public class DBContext {
    private static Connection c = null;
    private static Statement stmt = null;
    
    public static void DBopen(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    
    public static void Tblcreation(String sql){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table Created successfully");
    }
        
    public static void Insertion(String sql){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Insertion done successfully");
    }
    
    public static void DBclose(){
        try {
            Class.forName("org.sqlite.JDBC");
            c.close();
            
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    public static void select(String selection,ArrayList<String> args){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            String query = "SELECT * FROM " + selection.toUpperCase();
            ResultSet rs = stmt.executeQuery(query );
            while ( rs.next() ) {
                for(int i =0; i<args.size();i++)
                    System.out.println(rs.getString((args.get(i))));
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    private static ArrayList<Client> s = new ArrayList() ;
    public static ArrayList returnAccount(){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            String query = "SELECT * FROM CLIENT " ;
            ResultSet rs = stmt.executeQuery(query );
            while ( rs.next() ) {
                    s .add(new  Client( rs.getInt("account_id"),rs.getString("first_name"), rs.getString("last_name"),rs.getString("phone"),rs.getString("address"),
                            rs.getString("card_number"), rs.getString("CCV"), rs.getInt("current_balance"), rs.getString("SSN"))) ;           
            }
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return s;
    }
    
    private static String r;
    public static String returnBalance(String selection, int id){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            String query = "SELECT * FROM " + selection.toUpperCase() + " WHERE account_id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            r = rs.getString("current_balance");
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } 
        return r;
    }        
    
    public static void update(String query){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            stmt.executeUpdate(query);
            c.commit();
            
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
         System.out.println("Operation done successfully");
    }
    
    public static void delete(String query){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            stmt.executeUpdate(query);
            c.commit();
        } catch (ClassNotFoundException | SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}