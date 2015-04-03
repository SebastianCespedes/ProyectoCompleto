/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.ofertas.dao;

import modulo.ofertas.dto.OfertaDto;
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

    public List<OfertaDto> listarOfertas(Connection unaConexion) {
        ArrayList<OfertaDto> mylist = new ArrayList();
        try {
            String query = "select productos.imagen as imagen, ofertas.idOferta, productos.nombres, categorias.descripcion as categoria, ofertas.precioVenta, ofertas.fechaInicio,\n"
                    + "ofertas.fechaFin, presentacion.descripcion as presentacion,promociones.idPromocion, promociones.descripcion as promocion\n"
                    + "from ofertas inner join productoasociado on ofertas.idProdAsoc = productoasociado.idProdAsoc\n"
                    + "inner join productos on productos.idProducto = productoasociado.idProducto\n"
                    + "inner join presentacion on ofertas.idPresentacion = presentacion.idPresentacion\n"
                    + "inner join promociones on promociones.idPromocion = ofertas.idPromocion\n"
                    + "inner join categorias on categorias.idCategoria = productos.idCategoria;";
            pstm = unaConexion.prepareStatement(query);
            rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    OfertaDto ofertas = new OfertaDto();
                    ofertas.getProdDto().setImagen(rs.getString("imagen"));
                    ofertas.setIdOferta(rs.getInt("idOferta"));
                    ofertas.getProdDto().setNombres(rs.getString("nombres"));
                    ofertas.getCategoriaDto().setDescripcion(rs.getString("categoria"));
                    ofertas.setPrecioVenta(rs.getFloat("precioVenta"));
                    ofertas.setFechaInicio(rs.getString("fechaInicio"));
                    ofertas.setFechaFin(rs.getString("fechaFin"));
                    ofertas.getPreDto().setDescripcion(rs.getString("presentacion"));
                    ofertas.getProDto().setDescripcion(rs.getString("promocion"));
                    ofertas.setIdPromocion(rs.getInt("idPromocion"));
                    mylist.add(ofertas);

                }
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getSQLState() + " - " + ex.getMessage());
        }
        return mylist;
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
            //1- idProductoAsociado 2- PrecioVenta 3- idpromocion 4- idPresentacion
            String sqlInsert = "INSERT INTO ofertas VALUES (null, ?, ?, ?, now(), adddate(now(),8), 1, ?)";
            pstm = unaConexion.prepareStatement(sqlInsert);

            pstm.setInt(1, idProductoAsociado);
            pstm.setFloat(2, nuevoOferta.getPrecioVenta());
            pstm.setInt(3, nuevoOferta.getIdPromocion());
            pstm.setInt(4, nuevoOferta.getIdPresentacion());
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
    
    public String modificarOferta(int idOferta, int dias, int promocion, Connection unaConexion) {
        try {
            pstm = unaConexion.prepareStatement("Update ofertas set fechaFin = adddate(fechaFin, ?), idPromocion=? where idOferta = ?");
            pstm.setInt(1, dias);
            pstm.setInt(2, promocion);
            pstm.setInt(3, idOferta);            
            rtdo = pstm.executeUpdate();

            if (rtdo != 0) {
                mensaje = "ok";
            } else {
                mensaje = "okno";
            }
        } catch (SQLException ex) {
            mensaje = "Error" + ex.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarOferta(int idOferta, Connection unaConexion) {
        try {
            String sqlInsert = "delete from ofertas where idOferta = ? AND (select count(*) AS existePedido from pedidos where idOferta = ?) = 0;";
            pstm = unaConexion.prepareStatement(sqlInsert);

            pstm.setInt(1, idOferta);
            pstm.setInt(2, idOferta);
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
    
    public int obtenerUltimaOfertaInsertada(Connection unaConexion) {
        int idOferta = 0;
        sqlTemp = "select idOferta from ofertas order by idOferta DESC Limit 1";
        try {
            pstm = unaConexion.prepareStatement(sqlTemp);
            rs = pstm.executeQuery();

            if (rs.next()) {
                idOferta = rs.getInt("idOferta");
            }
        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return idOferta;
    }
    
    public boolean existeOfertasPorIDProducto(int idProducto, Connection unaConexion) {

        try {
            pstm = unaConexion.prepareStatement("Select idOferta from ofertas where idProdAsoc=?");
            pstm.setInt(1, idProducto);
            rs = pstm.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error, detalle: " + ex.getMessage());
        }
        return false;
    
    }
    
}
