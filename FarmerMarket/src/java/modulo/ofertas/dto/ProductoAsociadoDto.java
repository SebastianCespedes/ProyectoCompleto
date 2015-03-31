package modulo.ofertas.dto;



/**
 *
 * @author kennross
 */
public class ProductoAsociadoDto {

    private int idProdAsoc = 0;
    private long idUsuario = 0;
    private int idProducto = 0;

    @Override
    public String toString() {
        return "ProductoAsociadoDto{" + "idProdAsoc=" + idProdAsoc + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + '}';
    }

    /**
     * @return the idProdAsoc
     */
    public int getIdProdAsoc() {
        return idProdAsoc;
    }

    /**
     * @param idProdAsoc the idProdAsoc to set
     */
    public void setIdProdAsoc(int idProdAsoc) {
        this.idProdAsoc = idProdAsoc;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

}
