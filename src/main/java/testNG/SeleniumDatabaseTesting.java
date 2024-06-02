package testNG;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeleniumDatabaseTesting {
    // Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/test_new_schema";
    //Database Username
    public static String DB_USER = "root";
    // Database Password
    public static String DB_PASSWORD = "password";


    @BeforeTest
    public void setUp() throws Exception {
        try{
// Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to the database!");
// Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
// Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeTest(dependsOnMethods = "setUp")
    public void createTable() {
        System.out.println("dummy test");

    }

    @Test
    public void testEmployees() {
        try{
            String query = "select * from employees";
// Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
// Print the result untill all the records are printed
// res.next() returns true if there is any next record else returns false
            while (res.next())
            {
                System.out.print(res.getInt("emp_id"));
                System.out.print(" employees " + res.getString("name"));
                System.out.print(" employees " + res.getString("position"));
                System.out.println(" employees " + res.getDouble("salary"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test_TestEmployees() {
        try{
            String query = "select * from test_employees";
// Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
// Print the result untill all the records are printed
// res.next() returns true if there is any next record else returns false
            while (res.next())
            {
                System.out.print(res.getInt("emp_id"));
                System.out.print(" test_employees " + res.getString("name"));
                System.out.print(" test_employees " + res.getString("position"));
                System.out.println(" test_employees " + res.getDouble("salary"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception {
// Close DB connection
        if(stmt != null){
            stmt.close();
        }

        if (con != null) {
            con.close();
        }
    }
}