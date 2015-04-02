/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modulo.pedidos.dto;

/**
 *
 * @author User
 */
public class InventarioDto {
    
    private int idOferta = 0;
    private int cantidad = 0;
    private String fechaCargue = "";

    @Override
    public String toString() {
        return "InventarioDto{" + "idOferta=" + idOferta + ", cantidad=" + cantidad + ", fechaCargue=" + fechaCargue + '}';
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fechaCargue
     */
    public String getFechaCargue() {
        return fechaCargue;
    }

    /**
     * @param fechaCargue the fechaCargue to set
     */
    public void setFechaCargue(String fechaCargue) {
        this.fechaCargue = fechaCargue;
    }
}
