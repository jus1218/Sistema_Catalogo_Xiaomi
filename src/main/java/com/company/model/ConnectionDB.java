package com.company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JUS
 */
public class ConnectionDB {
     private final String driver="com.mysql.cj.jdbc.Driver";
    private final String strConn="jdbc:mysql://localhost/icondb?user=root&password=";
    
    public ConnectionDB() throws ClassNotFoundException{
        Class.forName(driver);
    }
    public Connection getConenction() throws SQLException{
        return DriverManager.getConnection(strConn);
    }
    protected void close(Connection con, Statement stm){
        this.close(con, stm, null);
    }
    protected void close(Connection con, Statement stm, ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
