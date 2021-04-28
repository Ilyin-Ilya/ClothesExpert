
import entity.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public Connection setConnection() throws IOException, ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String username = "root";
        String url = "jdbc:mysql://localhost/laba1?serverTimezone=Europe/Moscow&useSSL=false";
        String password = "fateLol98";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }


    public ArrayList<ActivityLocation> getAllLocations(Connection conn) {
        ArrayList<ActivityLocation> locations = new ArrayList<>();
        try {
            String query = "SELECT * FROM `activity_location`";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ActivityLocation location = new ActivityLocation();
                location.setLocation_id(resultSet.getInt(1));
                location.setLocation_name(resultSet.getString(2));
                locations.add(location);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public ArrayList<WeatherType> getAllWeatherTypes(Connection conn) {
        ArrayList<WeatherType> locations = new ArrayList<>();
        try {
            String query = "SELECT * FROM `weather_type`";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                WeatherType weatherType = new WeatherType();
                weatherType.setType_id(resultSet.getInt(1));
                weatherType.setType_name(resultSet.getString(2));
                locations.add(weatherType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public ArrayList<ActivityType> getAllActivityTypes(Connection conn) {
        ArrayList<ActivityType> locations = new ArrayList<>();
        try {
            String query = "SELECT * FROM `activity_type`";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ActivityType weatherType = new ActivityType();
                weatherType.setType_id(resultSet.getInt(1));
                weatherType.setActivity_type_name(resultSet.getString(2));
                locations.add(weatherType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public ArrayList<ClothesType> getAllClothesTypes(Connection conn) {
        ArrayList<ClothesType> locations = new ArrayList<>();
        try {
            String query = "SELECT * FROM `clothes_type`";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ClothesType weatherType = new ClothesType();
                weatherType.setType_id(resultSet.getInt(1));
                weatherType.setType_name(resultSet.getString(2));
                locations.add(weatherType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public ArrayList<ItemOfClothing> getItemOfClothingWithType(Connection conn, ClothesType type) {
        ArrayList<ItemOfClothing> locations = new ArrayList<>();
        try {
            String query = "SELECT * FROM `item_of_clothing`" +
                    "where item_id = "+type.getType_id();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ItemOfClothing weatherType = new ItemOfClothing();
                weatherType.setItem_id(resultSet.getInt(1));
                weatherType.setItem_type(resultSet.getInt(2));
                weatherType.setItem_producer_name(resultSet.getString(3));
                locations.add(weatherType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locations;
    }

    public ClothesType findClothesTypeByName(ArrayList<ClothesType> clothesTypes, String name) {
        for (ClothesType type :
                clothesTypes) {
            if (type.getType_name().equals(name))
                return type;
        }

        return new ClothesType();
    }
}
