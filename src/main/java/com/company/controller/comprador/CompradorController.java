package com.company.controller.comprador;

import com.company.model.comprador.Comprador;
import com.company.model.comprador.CompradorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUS
 */
public class CompradorController implements IComprador {

    @Override
    public String addC(String[] data) {
        String res = "Error al agregar el comprador a la base de datos";

        try {
            CompradorDAO dao = CompradorDAO.getInstance();
            if (dao.add(new Comprador(data))) {
                res = "Comprador guardado exitosamente";
            }
        } catch (Exception ex) {
            res = ex.getMessage();
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public String[] find(String id) {
        String[] data = new String[5];
        try {
            CompradorDAO dao = CompradorDAO.getInstance();
            Comprador comprador = dao.get(id);
            if (comprador != null) {
                data[0] = comprador.getId();
                data[1] = comprador.getNombre();
                data[2] = comprador.getApellido();
                data[3] = comprador.getEmail();
                data[4] = comprador.getTelefono();
            }
        } catch (Exception e) {
            data = null;
        }
        return data;
    }

    @Override
    public String deleteC(String id) {
        String resp = "Error, Comprador no eliminado";

        try {
            CompradorDAO dao = CompradorDAO.getInstance();
            if (dao.delete(id)) {
                resp = "Comprador eliminado exitosamente";
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resp;
    }

    @Override
    public String[][] getAll() {
        try {
            CompradorDAO dao = CompradorDAO.getInstance();
            ArrayList<Comprador> compradores = dao.getAll();
            String[][] data = new String[compradores.size()][6]; // [fila][columna]

            for (int i = 0; i < data.length; i++) {
                Comprador c = compradores.get(i);
                data[i][0] = c.getId();
                data[i][1] = c.getNombre();
                data[i][2] = c.getApellido();
                data[i][3] = c.getEmail();
                data[i][4] = c.getTelefono();
                data[i][5] = String.valueOf(c.getNumeroRegistro());
            }
            return data;
        } catch (Exception ex) {
            return null;
        }
    }

}
