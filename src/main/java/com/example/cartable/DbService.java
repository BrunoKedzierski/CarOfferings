package com.example.cartable;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static final String connectionString = "jdbc:h2:~/test";

    private static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(connectionString);
    }


    public static List<Car> getAllCars() throws SQLException, ClassNotFoundException {
        List<Car>  cars = new ArrayList<>();
       try( Connection connection = connect()){
           Statement statement = connection.createStatement();
           String sqlCommand = "SELECT * FROM CAR";
           ResultSet resultSet = statement.executeQuery(sqlCommand);

           while (resultSet.next()){


               cars.add( new Car(resultSet.getString("type"),resultSet.getString("model"),
                       resultSet.getString("manufacturer"),resultSet.getInt("Horsepower"),resultSet.getBoolean("Electric"),
                       resultSet.getString("phonenumber"),resultSet.getString("email"),resultSet.getDouble("price")

                       ));
           }


       }
       return cars;
    }


    public static List<String> getAllValues(String colName){
        List<String> vals = new ArrayList<>();

        try(Connection connection = connect()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT " + colName  + " FROM CAR");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            String firstColumnName = rsmd.getColumnLabel(1);




            while (resultSet.next()){

                vals.add( resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vals;

    }


}
