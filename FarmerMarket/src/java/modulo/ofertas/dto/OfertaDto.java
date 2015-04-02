package modulo.ofertas.dto;

import modulo.pedidos.dto.InventarioDto;
import modulo.pedidos.dto.PedidoDto;

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
    private PedidoDto peDto = new PedidoDto();
    private InventarioDto inDto = new InventarioDto();
    private ProductoAsociadoDto proAso = new ProductoAsociadoDto();
    private PresentacionDto preDto = new PresentacionDto();

    @Override
    public String toString() {
        return "OfertaDto{" + "idOferta=" + idOferta + ", idProdAsoc=" + idProdAsoc + ", precioVenta=" + precioVenta + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", cantidad=" + cantidad + ", idPromocion=" + idPromocion + ", idPresentacion=" + idPresentacion + ", peDto=" + peDto + ", inDto=" + inDto + ", proAso=" + proAso + ", preDto=" + preDto + '}';
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

    /**
     * @return the peDto
     */
    public PedidoDto getPeDto() {
        return peDto;
    }

    /**
     * @param peDto the peDto to set
     */
    public void setPeDto(PedidoDto peDto) {
        this.peDto = peDto;
    }

    /**
     * @return the inDto
     */
    public InventarioDto getInDto() {
        return inDto;
    }

    /**
     * @param inDto the inDto to set
     */
    public void setInDto(InventarioDto inDto) {
        this.inDto = inDto;
    }

    /**
     * @return the proAso
     */
    public ProductoAsociadoDto getProAso() {
        return proAso;
    }

    /**
     * @param proAso the proAso to set
     */
    public void setProAso(ProductoAsociadoDto proAso) {
        this.proAso = proAso;
    }

    /**
     * @return the preDto
     */
    public PresentacionDto getPreDto() {
        return preDto;
    }

    /**
     * @param preDto the preDto to set
     */
    public void setPreDto(PresentacionDto preDto) {
        this.preDto = preDto;
    }

}
