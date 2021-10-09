package com.company.model.comprador;

import com.company.model.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JUS
 */
public class CompradorDAO extends ConnectionDB {
    
    private static CompradorDAO instance;
    
    private CompradorDAO() throws ClassNotFoundException {
        super();
    }
    
    public static CompradorDAO getInstance() throws ClassNotFoundException {
        if (instance == null) {
            instance = new CompradorDAO();
        }
        return instance;
    }
    
    public boolean add(Comprador comprador) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        String sql = "INSERT INTO comprador(id,nombre,apellido,email,telefono) VALUES(?,?,?,?,?)";
        try {
            con = this.getConenction();
            stm = con.prepareStatement(sql);
            stm.setString(1, comprador.getId());
            stm.setString(2, comprador.getNombre());
            stm.setString(3, comprador.getApellido());
            stm.setString(4, comprador.getEmail());
            stm.setString(5, comprador.getTelefono());
            
            result = stm.execute();
        } finally {
            this.close(con, stm);
        }
        return true;
    }
    
    public Comprador get(String id) throws Exception {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Comprador comprador = null;
        String sql = "SELECT * FROM comprador WHERE id=?";
        try {
            con = this.getConenction();
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                comprador = new Comprador();
                comprador.setId(rs.getString("id"));
                comprador.setNombre(rs.getString("nombre"));
                comprador.setApellido(rs.getString("apellido"));
                comprador.setEmail(rs.getString("email"));
                comprador.setTelefono(rs.getString("telefono"));
            }
            return comprador;
        } finally {
            this.close(con, stm, rs);
        }
    }

//    public Comprador exists(String name) throws SQLException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        Comprador comprador = null;
//        String sql = "SELECT * FROM user WHERE name=?";
//
//        try {
//            con = this.getConenction();
//            stm = con.prepareStatement(sql);
//            stm.setString(1, name);
//            rs = stm.executeQuery();
//            if (rs.next()) {
//                comprador = new Comprador();
//                comprador.setId(rs.getString("id"));
//                comprador.setName(rs.getString("name"));
//                comprador.setPassword(rs.getString("password"));
//                comprador.setTypeUser(rs.getString("type_user"));
//            }
//            return comprador;
//        } finally {
//            this.close(con, stm, rs);
//        }
//
//    }
    public boolean delete(String id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;// Para enviar datos
        ResultSet rs = null; // Devuelve los resultados
        String sql = "DELETE FROM comprador WHERE id=?";
        
        try {
            con = this.getConenction();//Hace la conexion
            stm = con.prepareStatement(sql);//Enviamos la consulta
            stm.setString(1, id);// Enviamos el valor ?
            stm.execute();// ejecuta y devuelve si se logro 
        } finally {
            this.close(con, stm, rs);
        }
        return true;
    }
    
    public ArrayList getAll() throws SQLException {
        ArrayList<Comprador> array = new ArrayList();
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM comprador";
        
        try {
            con = this.getConenction();
            stm = con.prepareStatement(sql);// Se utiliza a la hora de traer datos
            rs = stm.executeQuery();
            while (rs.next()) {
                String[] data = {rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getString("telefono"), String.valueOf(rs.getInt("numero_registro"))};
                Comprador comprador = new Comprador(data);
                array.add(comprador);
            }
            return array;
        } finally {
            this.close(con, stm, rs);
        }
    }
}
