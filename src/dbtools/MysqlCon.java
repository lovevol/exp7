package dbtools;

import java.sql.*;

public class MysqlCon {
	private static final String URL = "jdbc:mysql://localhost:3306/web";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String NAME = "root";
    private static final String PASSWORD = "935686942";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    public MysqlCon() {
		// TODO Auto-generated constructor stub
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
