/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Seagal Putra
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/ida";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;
    private ResultSet rs = null;
    
    
    public Database() {
        /* try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"JDBC Driver Error",JOptionPane.WARNING_MESSAGE);
        } **/
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = getConnection();
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpus",dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ""+e.getMessage(),"Connection Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Connection getConnection() throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ida",dbuser, dbpasswd);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet getData(String SQLString) {
        try {
            rs = statement.executeQuery(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :" +e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public void query(String SQLString) {
        try {
            statement.executeUpdate(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error:"+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}