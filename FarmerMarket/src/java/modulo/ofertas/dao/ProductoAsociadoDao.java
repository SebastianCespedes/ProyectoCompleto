package modulo.ofertas.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kennross
 */
public class ProductoAsociadoDao {

    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";
    boolean poder = false;    

    public String insertProductoAsociado(long idProductor, int[] idProducto, Connection unaConexion) {
        try {
            String sqlInsert = "INSERT INTO `productoasociado` VALUES (null, ?, ?)";
            pstm = unaConexion.prepareStatement(sqlInsert);

            for (int i = 0; i < idProducto.length; i++) {                
                pstm.setInt(1, idProducto[i]);
                pstm.setLong(2, idProductor);
                rtdo = pstm.executeUpdate();
            }

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

     public String eliminarUnProductoAsociado(int idProductoAsociado, Connection unaConexion) {
        try {
            String sqlInsert = "delete from productoasociado where idProdAsoc = ? AND (select count(*) AS existeOferta from ofertas where idProdAsoc = ?) = 0;";
            pstm = unaConexion.prepareStatement(sqlInsert);

            pstm.setInt(1, idProductoAsociado);
            pstm.setInt(2, idProductoAsociado);
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

    //Contar el número de productos que tiene un usuario
    public String obtenerNumeroProductosAsociados(long idProductor, Connection unaConexion) {
        try {
            String sqlInsert = "SELECT count(idProducto) as Cantidad FROM productoasociado WHERE idUsuario = ?";
            pstm = unaConexion.prepareStatement(sqlInsert);
            pstm.setLong(1, idProductor);
            rs = pstm.executeQuery();

            while (rs.next()) {
                mensaje = rs.getString("Cantidad");
            }

        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return mensaje;
    }

    //Validar producto ya asociado
    public boolean validarYaProdAso(long idProductor, int idProducto, Connection unaConexion) {
        try {
            String sqlInsert = "SELECT idProdAsoc FROM productoasociado WHERE idUsuario = ? AND idProducto = ?";
            pstm = unaConexion.prepareStatement(sqlInsert);
            pstm.setLong(1, idProductor);
            pstm.setInt(2, idProducto);
            rs = pstm.executeQuery();
            rtdo=0;

            if (rs.next()) {
                rtdo = rs.getInt("idProdAsoc");
            }

            if (rtdo == 0) {
                poder = false;
            }
            else {
                poder = true;
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return poder;
    }

    //Validar producto ya asociado
    public int obtenerIdPA(long idProductor, int idProducto, Connection unaConexion) {
        try {
            String sqlInsert = "SELECT idProdAsoc FROM productoasociado WHERE idUsuario = ? AND idProducto = ?";
            pstm = unaConexion.prepareStatement(sqlInsert);
            pstm.setLong(1, idProductor);
            pstm.setInt(2, idProducto);
            rs = pstm.executeQuery();

            while (rs.next()) {
                rtdo = rs.getInt("idProdAsoc");
            }

        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }
        return rtdo;
    }
}
