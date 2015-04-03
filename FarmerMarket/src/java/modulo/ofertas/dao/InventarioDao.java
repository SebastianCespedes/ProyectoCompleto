/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modulo.ofertas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class InventarioDao {
    
     PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";
    
    public String insertarInventario(int idOferta, float cantidad, Connection unaConexion) {
        try {
            String sqlInsert = "INSERT INTO inventario VALUES(?,?,now())";
            pstm = unaConexion.prepareStatement(sqlInsert);

            pstm.setInt(1, idOferta);
            pstm.setFloat(2, cantidad);                      
            rtdo = pstm.executeUpdate();

            if (rtdo != 0) {
                mensaje = "ok";
            } else {
                mensaje = "okno";
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return mensaje;
    }
}
