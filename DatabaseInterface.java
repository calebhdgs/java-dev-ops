import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author caleb.hodges
 */
public class DatabaseInterface {
    Connection con;
    Statement st;
    
    public DatabaseInterface(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.146.13.215/test";
        String user = "Tim";
        String psswrd = "somecallme";
        try{
            Thread_Class thr = new Thread_Class();
            thr.start();
            thr.join();
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, psswrd);
            st = con.createStatement();
            System.out.println("Connected to the database!");
        }catch(SQLException err){
            System.out.println(err.getMessage());
            //err.printStackTrace();
        }catch(InterruptedException inter){
            System.out.println("The thread was terminated before it finished.");
        }catch(ClassNotFoundException fourOfour){
            System.out.println("The driver "+fourOfour.getMessage()+" could not be found.");
        }
        
        public static void main(string[] args){
            DatabaseInterface dbInter = new DatabaseInterface();
        }
    }
    
    public class Thread_Class extends Thread{
        public void run(){
            System.out.println("Did the threading thing.");
        }
    }
