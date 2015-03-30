package modulo.usuarios.dao;

/**
 * @author Kennit David Ruz Romero Fecha: 4 de de Enero de 2015
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modulo.usuarios.dto.PermisoDto;

public class PermisoDao {

    PreparedStatement pstm = null;
    int rtdo;
    ResultSet rs = null;
    String mensaje = "";
    String sqlTemp = "";

    public List obtenerPermisosPorRol(int rol, Connection unaConexion) {
        ArrayList<PermisoDto> permisos = null;
        String sql = "SELECT p.idPermiso, p.permisos, p.url"
                + "FROM `permisos` as p JOIN permisosrol as pr ON (p.idPermiso = pr.idPermiso) "
                + "JOIN roles as r ON (r.idRol = pr.idRol) WHERE r.idRol = ?";
        try {
            pstm = unaConexion.prepareStatement(sql);
            pstm.setInt(1, rol);
            rs = pstm.executeQuery();

            permisos = new ArrayList();
            while (rs.next()) {
                PermisoDto temp = new PermisoDto();
                temp.setIdPermiso(rs.getInt("idPermiso"));
                temp.setPermiso(rs.getString("permisos"));
                temp.setUrl(rs.getString("url"));
                permisos.add(temp);
            }
        } catch (SQLException sqle) {
            System.out.println("Error, detalle: " + sqle.getMessage());
        }
        return permisos;
    }

}
