package modulo.ofertas.dto;

/**
 *
 * @author kennross
 */
public class OfertaDto {

    private int idOferta = 0;
    private int idProdAsoc = 0;
    private float precioVenta = 0;
    private String fechaInicio = "";
    private String fechaFin = "";
    private float cantidad = 0.f;
    private int idPromocion = 0;
    private int idPresentacion = 0;

    @Override
    public String toString() {
        return "OfertaDto{" + "idOferta=" + idOferta + ", idProdAsoc=" + idProdAsoc + ", precioVenta=" + precioVenta + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cantidadDisponible=" + cantidad + ", idPromocion=" + idPromocion + ", idPresentacion=" + idPresentacion + '}';
    }

    /**
     * @return the idOferta
     */
    public int getIdOferta() {
        return idOferta;
    }

    /**
     * @param idOferta the idOferta to set
     */
    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
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
     * @return the precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idPromocion
     */
    public int getIdPromocion() {
        return idPromocion;
    }

    /**
     * @param idPromocion the idPromocion to set
     */
    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    /**
     * @return the idPresentacion
     */
    public int getIdPresentacion() {
        return idPresentacion;
    }

    /**
     * @param idPresentacion the idPresentacion to set
     */
    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

}
