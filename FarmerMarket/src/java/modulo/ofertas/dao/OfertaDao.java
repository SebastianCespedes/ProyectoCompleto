/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.ofertas.dao;

import modulo.ofertas.dto.OfertaDto;
import modulo.ofertas.dto.PromocionDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kennross
 */
public class OfertaDao {
        
    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";
    
    public List obtenerOfertasPorProductor(long idProductor, Connection unaConexion) {
        ArrayList<OfertaDto> ciudades = null;
        sqlTemp = "";
        try {
            pstm = unaConexion.prepareStatement(sqlTemp);
            pstm.setLong(1, idProductor);
            rs = pstm.executeQuery();

            ciudades = new ArrayList();
            while (rs.next()) {
                OfertaDto temp = new OfertaDto();
                
                ciudades.add(temp);
            }
        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return ciudades;
    }
        
    
    public String insertOferta(OfertaDto nuevoOferta, int idProductoAsociado, Connection unaConexion) {
        try {
            //1- idProductoAsociado 2- PrecioVenta 3- Cantidad 4- idPromocion 5- idEstado
            String sqlInsert = "INSERT INTO ofertas VALUES (null, ?, ?, now(), adddate(now(),8), ?, ?)";
            pstm = unaConexion.prepareStatement(sqlInsert);

            pstm.setInt(1, idProductoAsociado);
            pstm.setFloat(2, nuevoOferta.getPrecioVenta());
            pstm.setFloat(3, nuevoOferta.getCantidad());
            pstm.setInt(4, 1);
            
            
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
