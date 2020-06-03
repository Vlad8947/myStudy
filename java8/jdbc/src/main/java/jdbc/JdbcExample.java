package jdbc;

import java.sql.*;

public class JdbcExample {

    public static void main(String[] args) {
        try (
                Connection connection = connect("test_db", "test", "test");
        ) {
//            statementExample(connection);
//            praparedStatementExample(connection);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connect(String db_name, String user, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + db_name + "?useLegacyDatetimeCode=false&amp&serverTimezone=UTC",
                user, password
        );
    }

    private static void statementExample(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        /*
            statement.execute(""); return boolean
            statement.executeUpdate(""); return amount of queries executed (update, remove, ...)
            statement.executeQuery(""); return ResultSet (select ...)
        */
        statement.close();
    }

    private static void praparedStatementExample(Connection connection) throws SQLException {
        String name = "Paul";
        int age = 10;
        int pin = 8888;

        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO USERS (NAME, AGE, PIN) VALUES(?,?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, pin);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void packageQueryExample(Connection connection) throws SQLException {
        String name = "Paul";
        int age = 10;
        int pin = 8888;

        connection.setAutoCommit(false);
        /*
        Statement statement = connection.createStatement();
        statement.addBatch("insert");
        statement.addBatch("update");
        statement.executeBatch();
        */
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO USERS (NAME, AGE, PIN) VALUES(?,?,?)");

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, pin);

        preparedStatement.addBatch();

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setInt(3, pin);

        preparedStatement.addBatch();

        int[] handledStrings =
                preparedStatement.executeBatch();

        connection.commit();
        preparedStatement.close();
        connection.setAutoCommit(true);
    }

    private static void resultSetExample(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String name_1 = resultSet.getString(1);
            int age = resultSet.getInt("age");
        }
    }

}
