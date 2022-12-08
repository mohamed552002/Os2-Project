package application;
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
    
    private String s = "";
    public String returnAccount(String selection,ArrayList<String> args){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            String query = "SELECT * FROM " + selection.toUpperCase();
            ResultSet rs = stmt.executeQuery(query );
            while ( rs.next() ) {
                for(int i =0; i<args.size();i++)
                    s = s + rs.getString((args.get(i))) + "\n";           
            }
        } catch (ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return s;
    }
    
    private String r;
    public String returnBalance(String selection, int id){
        try {
            Class.forName("org.sqlite.JDBC");
            stmt=c.createStatement();
            String query = "SELECT * FROM " + selection.toUpperCase() + " WHERE client_id = " + id;
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