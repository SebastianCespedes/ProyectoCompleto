package modulo.usuarios.dto;

/**
 * @author Kennit David Ruz Romero Hora de creación: 11:18 a.m. Fecha: 4 de
 * Marzo de 2015
 */
public class PermisoDto {

    private int idPermiso = 0;
    private String permiso = "";
    private String url = "";

    /**
     * @return the idPermiso
     */
    public int getIdPermiso() {
        return idPermiso;
    }

    /**
     * @param idPermiso the idPermiso to set
     */
    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    /**
     * @return the permiso
     */
    public String getPermiso() {
        return permiso;
    }

    /**
     * @param permiso the permiso to set
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
