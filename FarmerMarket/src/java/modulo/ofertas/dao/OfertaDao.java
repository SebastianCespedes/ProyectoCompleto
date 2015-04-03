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
import modulo.ofertas.dto.PresentacionDto;
import modulo.ofertas.dto.ProductoAsociadoDto;
import modulo.pedidos.dto.InventarioDto;
import modulo.pedidos.dto.PedidoDto;

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

    public List obtenerOfertas(Connection unaConexion) {

        ArrayList<OfertaDto> ofertas = new ArrayList();

        try {
            pstm = unaConexion.prepareStatement("select o.idOferta as oferta, concat(u.nombres, ' ' , u.apellidos) as productor, i.cantidad as cantidad,  p.nombres as producto, o.precioVenta as precio, o.fechaFin as vence,  pre.descripcion as presentacion from ofertas as o \n"
                    + "join productoasociado as pa on o.idProdAsoc = pa.idProdAsoc \n"
                    + "join presentacion as pre on pre.idPresentacion = o.idPresentacion join productos as p on p.idProducto = pa.idProdAsoc join usuarios as u on u.idUsuario = pa.idUsuario \n"
                    + "join inventario as i on i.idOferta = o.idOferta;");
            rs = pstm.executeQuery();
            while (rs.next()) {
                OfertaDto oferta = new OfertaDto();
                oferta.setIdOferta(rs.getInt("oferta"));
                oferta.getProAso().getUsDto().setNombres(rs.getString("productor"));
                oferta.getProAso().getProDto().setNombres(rs.getString("producto"));
                oferta.getInDto().setCantidad(rs.getInt("cantidad"));
                oferta.setPrecioVenta(rs.getFloat("precio"));
                oferta.setFechaFin(rs.getString("vence"));
                oferta.getPreDto().setDescripcion(rs.getString("presentacion"));
                ofertas.add(oferta);
            }
        } catch (SQLException ex) {

        }
        return ofertas;
    }

    public OfertaDto obtenerOfertaPorId(int idOferta, Connection unaConexion) {
        OfertaDto oferta = new OfertaDto();        
        try {
            pstm = unaConexion.prepareStatement("select o.idOferta as oferta, concat(u.nombres, ' ' , u.apellidos) as productor, i.cantidad as cantidad,  p.nombres as producto, o.precioVenta as precio, o.fechaFin as vence,  pre.descripcion as presentacion, pro.descripcion as promocion\n"
                    + "from ofertas as o\n"
                    + "join productoasociado as pa on o.idProdAsoc = pa.idProdAsoc \n"
                    + "join presentacion as pre on pre.idPresentacion = o.idPresentacion \n"
                    + "join promociones as pro on pro.idPromocion = o.idPromocion\n"
                    + "join productos as p on p.idProducto = pa.idProdAsoc \n"
                    + "join usuarios as u on u.idUsuario = pa.idUsuario\n"
                    + "join inventario as i on i.idOferta = o.idOferta where o.idOferta = ?");
            pstm.setInt(1, idOferta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                oferta.setIdOferta(rs.getInt("oferta"));
                oferta.getProAso().getUsDto().setNombres(rs.getString("productor"));
                oferta.getProAso().getProDto().setNombres(rs.getString("producto"));
                oferta.getInDto().setCantidad(rs.getInt("cantidad"));
                oferta.setPrecioVenta(rs.getFloat("precio"));
                oferta.setFechaFin(rs.getString("vence"));
                oferta.getPreDto().setDescripcion(rs.getString("presentacion"));
                oferta.getProDto().setDescripcion(rs.getString("promocion"));
            }
        } catch (SQLException ex) {

        }
        return oferta;
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
    
    public String actualizarCantidad(int idOferta, Connection unaConexion){
        String cantidad = "";
        try{
            pstm = unaConexion.prepareStatement("select i.cantidad as cantidad from ofertas as o "
                    + "join inventario as i on o.idOferta = i.idOferta where o.idOferta = ?;");
            pstm.setInt(1, idOferta);
            rs = pstm.executeQuery();
            while(rs.next()){
                cantidad = rs.getString("cantidad");
            }
        }catch (SQLException ex) {
            
        }
        
        return cantidad;
    }
    
}
