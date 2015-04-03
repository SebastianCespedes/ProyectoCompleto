/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modulo.ofertas.dao;

import modulo.ofertas.dto.PromocionDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author LENOVO
 */
public class PromocionesDao {
    String mensaje="";
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    public LinkedList<PromocionDto> listartodos(Connection unaConexion){
        LinkedList<PromocionDto> novedades = new LinkedList<PromocionDto>();
        try {
            String query = "Select * from promociones;";
            ps = unaConexion.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PromocionDto novedad = new PromocionDto();
                    novedad.setIdPromocion(rs.getInt("idPromocion"));
                    novedad.setDescripcion(rs.getString("descripcion"));
                    novedad.setDetalle(rs.getFloat("detalle"));
                    novedades.add(novedad);

                }
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getSQLState() + " - " + ex.getMessage();
        }
        
        return novedades;
        
    }
    public PromocionDto obtenerUno(int id, Connection unaConexion){
        PromocionDto novedad=new PromocionDto();
        try{
            String query="Select * from promociones where idPromocion=?;";
            ps=unaConexion.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if(rs!=null){
                while (rs.next()){
                    novedad.setIdPromocion(rs.getInt("idPromocion"));
                    novedad.setDescripcion(rs.getString("descripcion"));
                }
            }
        }catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
         return novedad;
        
    }
    
}
