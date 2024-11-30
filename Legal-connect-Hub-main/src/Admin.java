import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;


public class Admin extends JFrame {
    private final Connection connection;

    public Admin(Connection connection) {
        this.connection = connection;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("Admin Panel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2));

        JButton viewTableStructureButton = new JButton("View Table Structure");
        viewTableStructureButton.addActionListener(e -> new ViewTableStructure().execute());

        JButton viewTableDataButton = new JButton("View Table Data");
        viewTableDataButton.addActionListener(e -> new ViewTableData().execute());

        JButton insertDataButton = new JButton("Insert Data");
        insertDataButton.addActionListener(e -> new InsertData().execute());

        JButton updateDataButton = new JButton("Update Data");
        updateDataButton.addActionListener(e -> new UpdateData().execute());

        JButton deleteDataButton = new JButton("Delete Data");
        deleteDataButton.addActionListener(e -> new DeleteData().execute());

        mainPanel.add(viewTableStructureButton);
        mainPanel.add(viewTableDataButton);
        mainPanel.add(insertDataButton);
        mainPanel.add(updateDataButton);
        mainPanel.add(deleteDataButton);

        add(mainPanel);
        setVisible(true);
    }

    class ViewTableStructure {
        public void execute() {
            try {
                String table = JOptionPane.showInputDialog(null, "Enter the table name:");
                if (table != null) {
                    DatabaseMetaData metaData = connection.getMetaData();
                    ResultSet columnsResultSet = metaData.getColumns(null, null, table, null);

                    StringBuilder result = new StringBuilder("\nTable Structure:\n");
                    while (columnsResultSet.next()) {
                        String columnName = columnsResultSet.getString("COLUMN_NAME");
                        String dataType = columnsResultSet.getString("TYPE_NAME");
                        result.append("Column Name: ").append(columnName).append(", Data Type: ").append(dataType).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, result.toString());
                    columnsResultSet.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error viewing table structure.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ViewTableData {
        public void execute() {
            try {
                String table = JOptionPane.showInputDialog(null, "Enter the table name:");
                if (table != null) {
                    String query = "SELECT * FROM " + table;
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    StringBuilder result = new StringBuilder("\nTable Data:\n");
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount = resultSetMetaData.getColumnCount();

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = resultSetMetaData.getColumnName(i);
                            String columnValue = resultSet.getString(i);
                            result.append(columnName).append(": ").append(columnValue).append("\n");
                        }
                        result.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, result.toString());
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error viewing table data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class InsertData {
        public void execute() {
            try {
                String table = JOptionPane.showInputDialog(null, "Enter the table name:");
                if (table != null) {
                    int numColumns = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of columns to insert data into:"));

                    StringBuilder columns = new StringBuilder();
                    StringBuilder values = new StringBuilder();

                    for (int i = 0; i < numColumns; i++) {
                        String columnName = JOptionPane.showInputDialog(null, "Enter column name " + (i + 1) + ":");
                        String columnValue = JOptionPane.showInputDialog(null, "Enter value for " + columnName + ":");

                        columns.append(columnName);
                        values.append("'").append(columnValue).append("'");

                        if (i < numColumns - 1) {
                            columns.append(", ");
                            values.append(", ");
                        }
                    }

                    String query = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data inserted successfully.");
                    preparedStatement.close();
                }
            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error inserting data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class UpdateData {
        public void execute() {
            try {
                String table = JOptionPane.showInputDialog(null, "Enter the table name:");
                if (table != null) {
                    String columnToUpdate = JOptionPane.showInputDialog(null, "Enter the column to update:");
                    String newValue = JOptionPane.showInputDialog(null, "Enter the new value:");
                    String conditionColumn = JOptionPane.showInputDialog(null, "Enter the condition column:");
                    String conditionValue = JOptionPane.showInputDialog(null, "Enter the condition value:");

                    String query = "UPDATE " + table + " SET " + columnToUpdate + " = '" + newValue +
                            "' WHERE " + conditionColumn + " = '" + conditionValue + "'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data updated successfully.");
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteData {
        public void execute() {
            try {
                String table = JOptionPane.showInputDialog(null, "Enter the table name:");
                if (table != null) {
                    String conditionColumn = JOptionPane.showInputDialog(null, "Enter the condition column:");
                    String conditionValue = JOptionPane.showInputDialog(null, "Enter the condition value:");

                    String query = "DELETE FROM " + table + " WHERE " + conditionColumn + " = '" + conditionValue + "'";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data deleted successfully.");
                    preparedStatement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306 /java_project";
            String username = "root";
            String password = "0000";
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            SwingUtilities.invokeLater(() -> new Admin(connection));

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
