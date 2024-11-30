import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TriggerSimulation {
    public static void main(String[] args) {
        try {
            // Replace these values with your actual database connection details
            String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
            String user = "system";
            String password = "123";

            Connection connection = DriverManager.getConnection(url, user, password);

            // Assuming ad table has columns a_status and userid
            String sql = "UPDATE ad SET a_status = ? WHERE userid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "inprogress");
            statement.setString(2, "a1");

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Ad updated successfully!");

                // Simulate the trigger logic manually
                if ("inprogress".equals("inprogress") && "a1".equals("a1")) {
                    String triggerSql = "UPDATE users1 SET STATUS = 'inprogress' WHERE AD_ID = 'a1'";
                    PreparedStatement triggerStatement = connection.prepareStatement(triggerSql);
                    triggerStatement.executeUpdate();
                    System.out.println("Trigger simulated successfully!");
                }
            } else {
                System.out.println("No rows were updated.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error updating ad: " + ex.getMessage());
        }
    }
}