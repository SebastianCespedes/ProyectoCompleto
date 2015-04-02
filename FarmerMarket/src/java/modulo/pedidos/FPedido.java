/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.pedidos;

import java.sql.Connection;
import modulo.ofertas.FOferta;
import modulo.ofertas.dao.OfertaDao;
import modulo.ofertas.dto.OfertaDto;
import modulo.pedidos.dao.InventarioDao;
import modulo.pedidos.dao.PedidoDao;
import modulo.pedidos.dto.InventarioDto;
import modulo.pedidos.dto.PedidoDto;
import utilidades.Conexion;

/**
 *
 * @author User
 */
public class FPedido {

    //Conexion
    Connection miConexion = null;

    //Clases DataAccessObject (DAO)
    PedidoDao peDao = null;
    InventarioDao inDao = null;
    OfertaDao ofDao = null;
    //Clases DataTransferObject (DTO)
    PedidoDto peDto = null;
    InventarioDto inDto = null;
    OfertaDto ofDto = null;

    public FPedido() {
        this.miConexion = Conexion.getInstance();
        //Clases DataAccessObject (DAO)
        this.peDao = new PedidoDao();
        this.inDao = new InventarioDao();
        this.ofDao = new OfertaDao();
        //Clases DataTransferObject (DTO)
        this.peDto = new PedidoDto();
        this.inDto = new InventarioDto();
        this.ofDto = new OfertaDto();
    }
}
