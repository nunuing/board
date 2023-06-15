import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConnectionTest {
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/board_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "test1234");
            System.out.println(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
