import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

Connection connection = null;
try {
    // Replace the URL, username, and password with your database information
    String url = "jdbc:sqlite:/path/to/your/database.db";
    String username = "your_username";
    String password = "your_password";
    connection = DriverManager.getConnection(url, username, password);
} catch (SQLException e) {
    e.printStackTrace();
}

Statement statement = null;
try {
    connection.setAutoCommit(false); // Start a transaction
    statement = connection.createStatement();

    // Execute the UPDATE statement
    int updatedRows = statement.executeUpdate("UPDATE Stock SET facilityID = newFacilityID WHERE facilityID = oldFacilityID");

    // Check if the UPDATE was successful
    if (updatedRows > 0) {
        // The Stock was transferred, proceed with DELETE
        statement.executeUpdate("DELETE FROM Facility WHERE facilityID = oldFacilityID");

        // Commit the transaction
        connection.commit();
        connection.setAutoCommit(true); // Return to auto-commit mode
    } else {
        // The Stock was not transferred, perform a ROLLBACK
        connection.rollback();
        connection.setAutoCommit(true); // Return to auto-commit mode
    }

} catch (SQLException e) {
    // Handle exceptions as needed
    e.printStackTrace();
    try {
        if (connection != null) {
            connection.rollback();
            connection.setAutoCommit(true); // Return to auto-commit mode
        }
    } catch (SQLException e2) {
        e2.printStackTrace();
    }
} finally {
    // Close the statement and connection
    try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
