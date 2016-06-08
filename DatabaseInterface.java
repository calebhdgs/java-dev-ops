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
    
    public static void main(String[] args){
       DatabaseInterface dbInter = new DatabaseInterface();
    }
    
    public DatabaseInterface(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.146.13.215:3306/test";
        String user = "root";
        String psswrd = "_________";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, psswrd);
            st = con.createStatement();
            System.out.println("Connected to the database!");
        }catch(SQLException err){
            System.out.println(err.getMessage());
            err.printStackTrace();
        }catch(ClassNotFoundException fourOfour){
            System.out.println("The driver "+fourOfour.getMessage()+" could not be found.");
        }
    }
    
    public ResultSet executeQuery(String query){
        ResultSet results = null;
        try{
            results = st.executeQuery(query);
        }catch(SQLException err){
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
        return results;
    }
    public void update(String query){
        try{
            st.executeUpdate(query);
        }catch(SQLException err){
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
    }
}
