/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modulo.ofertas.dao;

import modulo.ofertas.dto.PresentacionDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author LENOVO
 */
public class PresentacionDao {
    String mensaje="";
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    public LinkedList<PresentacionDto> listarTodos(Connection unaConexion){
        LinkedList<PresentacionDto> presentaciones = new LinkedList<PresentacionDto>();
        try {
            String query = "Select * from presentacion;";
            ps = unaConexion.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    PresentacionDto presentacion = new PresentacionDto();
                    presentacion.setIdPresentacion(rs.getInt("idPresentacion"));
                    presentacion.setDescripcion(rs.getString("descripcion"));
                    presentaciones.add(presentacion);

                }
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getSQLState() + " - " + ex.getMessage();
        }
        
        return presentaciones;
    
}
    public PresentacionDto obtenerUno(int id, Connection unaConexion){
        PresentacionDto presentacion=new PresentacionDto();
        try{
            String query="Select * from presentacion where idPresentacion=?;";
            ps=unaConexion.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            if(rs!=null){
                while (rs.next()){
                    presentacion.setIdPresentacion(rs.getInt("idPresentacion"));
                    presentacion.setDescripcion(rs.getString("descripcion"));
                    
                }
            }
        }catch (SQLException ex) {
            mensaje = ex.getMessage();

        }
         return presentacion;
        
    }
}
