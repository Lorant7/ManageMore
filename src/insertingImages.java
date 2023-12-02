import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingImages {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://your_database_url";
        String username = "your_username";
        String password = "your_password";

        // Path to the directory containing images (not sure if this is correct)
        String currentFilePath = GetCurrentFilePath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //C:\Users\jtlor\Documents\PSU Fall 2023\CMPSC 431W\MangeMore\ManageMore\src\insertingImages.java
        
        String imagePath = currentFilePath + "\\images";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Execute SQL statements
            insertProducts(connection, imagePath);

            System.out.println("Data inserted successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertProducts(Connection connection, String imagePath) throws SQLException, IOException {
        File imageDirectory = new File(imagePath);
        File[] imageFiles = imageDirectory.listFiles();

        byte[] backpackimageData = readImageFile(imageFiles[0]);
        byte[] beautykitimageData = readImageFile(imageFiles[1]);
        byte[] bluetoothearbudsimageData = readImageFile(imageFiles[2]);
        byte[] bluetoothspeakerimageData = readImageFile(imageFiles[3]);
        byte[] coffeemakerimageData = readImageFile(imageFiles[4]);
        byte[] cookwaresetimageData = readImageFile(imageFiles[5]);
        byte[] deskchairimageData = readImageFile(imageFiles[6]);
        byte[] desklampimageData = readImageFile(imageFiles[7]);
        byte[] digitalcameraimageData = readImageFile(imageFiles[8]);
        byte[] fitnesstrackersimageData = readImageFile(imageFiles[9]);
        byte[] gamingconsoleimageData = readImageFile(imageFiles[10]);
        byte[] homedecorsetimageData = readImageFile(imageFiles[11]);
        byte[] laptopimageData = readImageFile(imageFiles[12]);
        byte[] LEDTVimageData = readImageFile(imageFiles[13]);
        byte[] portablechargerimageData = readImageFile(imageFiles[14]);
        byte[] refrigeratorimageData = readImageFile(imageFiles[15]);
        byte[] smartphoneimageData = readImageFile(imageFiles[16]);
        byte[] sportsshoesimageData = readImageFile(imageFiles[17]);
        byte[] stationerybundleimageData = readImageFile(imageFiles[18]);
        byte[] vacumcleanerimageData = readImageFile(imageFiles[19]);


        // SQL command to be executed
        String sql = "INSERT INTO Product (productID, name, price, description, vendorID, image) VALUES "
                + "(1, 'Laptop', 1200.00, 'Powerful laptop with high-end specifications.', 1, " + laptopimageData +"), "
                + "(2, 'Smartphone', 800.00, 'Latest model with advanced features.', 2, " + smartphoneimageData +"), "
                + "(3, 'Desk Chair', 150.00, 'Ergonomic office chair for comfort.', 3, " + deskchairimageData + "), "
                + "(4, 'LED TV', 700.00, 'Ultra HD Smart TV with a large display.', 4, " + LEDTVimageData + "), "
                + "(5, 'Refrigerator', 900.00, 'Energy-efficient refrigerator with ample storage.', 5, " + refrigeratorimageData +"), "
                + "(6, 'Gaming Console', 400.00, 'Popular gaming console with a vast game library.', 6, " + gamingconsoleimageData + "), "
                + "(7, 'Sports Shoes', 80.00, 'Comfortable athletic shoes for various sports.', 7, " + sportsshoesimageData + "), "
                + "(8, 'Home Decor Set', 200.00, 'A set of stylish home decor items.', 8, " + homedecorsetimageData + "), "
                + "(9, 'Beauty Kit', 50.00, 'Complete beauty kit for skincare and makeup.', 9, " + beautykitimageData + "), "
                + "(10, 'Stationery Bundle', 30.00, 'Essential stationery items for work or school.', 10, " + stationerybundleimageData + "), "
                + "(11, 'Coffee Maker', 60.00, 'Automatic coffee maker for brewing delicious coffee.', 1, " + coffeemakerimageData + "), "
                + "(12, 'Bluetooth Speaker', 40.00, 'Portable speaker with wireless connectivity.', 2, " + bluetoothspeakerimageData + "), "
                + "(13, 'Desk Lamp', 25.00, 'Adjustable desk lamp for focused lighting.', 3, " + desklampimageData + "), "
                + "(14, 'Cookware Set', 100.00, 'High-quality cookware set for the kitchen.', 4, " + cookwaresetimageData + "), "
                + "(15, 'Fitness Tracker', 50.00, 'Wearable device to monitor fitness activities.', 5, " + fitnesstrackersimageData + "), "
                + "(16, 'Backpack', 35.00, 'Durable backpack for daily use or travel.', 6, " + backpackimageData + "), "
                + "(17, 'Digital Camera', 300.00, 'Compact digital camera for capturing memories.', 7, " + digitalcameraimageData + "), "
                + "(18, 'Bluetooth Earbuds', 30.00, 'Wireless earbuds for on-the-go audio.', 8, " + bluetoothearbudsimageData + "), "
                + "(19, 'Vacuum Cleaner', 80.00, 'Efficient vacuum cleaner for household cleaning.', 9, " + vacumcleanerimageData + "), "
                + "(20, 'Portable Charger', 20.00, 'Compact power bank for charging devices on the go.', 10, " + portablechargerimageData + ")";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Execute the SQL command
            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static byte[] readImageFile(File imageFile) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
            byte[] imageData = new byte[(int) imageFile.length()];
            fileInputStream.read(imageData);
            return imageData;
        }
    }
}
