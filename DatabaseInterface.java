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
        String url = "jdbc:mysql://localhost:3306/nvt";
        String user = "root";
        String psswrd = "frisbee001";
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
  public static void main(String[] args){
     DatabaseInterface dbInter = new DatabaseInterface();
  }
