package application;
import  application.LoadingController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class SharedVariables {
//    	private static Stage stage;
//	private static Scene scene;
//	private static Parent root;
//	double x,y;
//            @FXML
//        	public static  void Loading(ActionEvent e) throws IOException {
//
//		 root = FXMLLoader.load(getClass().getResource("Loading.fxml"));
//		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//		}

    public static void incrementReadCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readCount);
        i++;
        String string = i + readLock + writeLock;

        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
        public static void incrementWriteCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readLock);
        i++;
        String string = readCount+ i + writeLock;

        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
                public static void decrementWriteCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readLock);
        i--;
        String string = readCount+ i + writeLock;

        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
    
    public static void decrementReadCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readCount);
        i--;
        String string = i + readLock + writeLock;

        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
    
    public static int returnReadCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String read = String.valueOf(s.charAt(0));
        int readCount = Integer.parseInt(read);
        return readCount;
    }
        public static int returnWriteCount() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String read = String.valueOf(s.charAt(1));
        int readCount = Integer.parseInt(read);
        return readCount;
    }
    
    public static void waitReader() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readLock);
        while(i <= 0);

        i--;
        String string = readCount + i + writeLock;
        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
    
        public static void signalReader() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(readLock);
        i++;
        String string = readCount + i + writeLock;
        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }

    public static  void waitWriter() throws IOException{

        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(writeLock);
        if(i <= 0){
        
        };
        i--;
        String string = readCount + readLock + i;
        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
    
    public static void signalWriter() throws IOException{
        Path filename = Path.of("SharedVariables.txt");
        String s = Files.readString(filename);
        String readCount = String.valueOf(s.charAt(0));
        String readLock = String.valueOf(s.charAt(1));
        String writeLock = String.valueOf(s.charAt(2));
        int i = Integer.parseInt(writeLock);
        i++;
        String string = readCount + readLock + i;
        FileOutputStream fout = new FileOutputStream("SharedVariables.txt", false); 
        fout.write(string.getBytes());  
    }
}
