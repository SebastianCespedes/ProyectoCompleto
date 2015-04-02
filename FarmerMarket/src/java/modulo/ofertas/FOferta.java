package modulo.ofertas;

import modulo.ofertas.dao.CategoriaDao;
import modulo.ofertas.dao.OfertaDao;
import modulo.ofertas.dao.ProductoAsociadoDao;
import modulo.ofertas.dao.ProductoDao;
import modulo.ofertas.dto.CategoriaDto;
import modulo.ofertas.dto.OfertaDto;
import modulo.ofertas.dto.ProductoAsociadoDto;
import modulo.ofertas.dto.ProductoDto;
import modulo.ofertas.dto.PromocionDto;
import utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 * @author kennross
 */
public class FOferta {
    //Conexion
    Connection miConexion = null;
    
    //Clases DataAccessObject (DAO)
    OfertaDao ofDao = null;
    ProductoDao pDao = null;
    CategoriaDao caDao = null;
    ProductoAsociadoDao paDao = null;
    
    //Clases DataTransferObject (DTO)
    OfertaDto ofDto = null;
    ProductoDto pDto = null;
    ProductoAsociadoDto paDto = null;
    PromocionDto promoDto = null;
    CategoriaDto caDto = null;
    
    public FOferta() {
        //Instancio la conexion
        this.miConexion = Conexion.getInstance();
        
        this.ofDao = new OfertaDao();
        this.pDao = new ProductoDao();
        this.caDao = new CategoriaDao();
        this.paDao = new ProductoAsociadoDao();        
        this.ofDto = new OfertaDto();
        this.pDto = new ProductoDto();        
        this.promoDto = new PromocionDto();
        this.caDto = new CategoriaDto();
        this.paDto = new ProductoAsociadoDto();
    }
        
    //Insert's a la base de datos directamente
    public String asociarProductos(long idProductor, int[] idProducto) {
        return paDao.insertProductoAsociado(idProductor, idProducto, miConexion);
    }
    
    //Consultas Por Un Criterio (ProductosAsociados)
    public int obtenerIdPaPorIds(long idProductor, int idProducto) {
        return paDao.obtenerIdPA(idProductor, idProducto, miConexion);
    }
    
    //Consultas Por Un Criterio (Produtos)
    public List obtenerTodosLosProductos() {
        return pDao.obtenerProductos(miConexion);
    }
    
    public String obtenerNumeroDeProductosAsociadosPorProducto(long idProductor) {
        return paDao.obtenerNumeroProductosAsociados(idProductor, miConexion);
    }
    
    public boolean validarProductoYaAsociado(long idProductor, int idProducto) {
        return paDao.validarYaProdAso(idProductor, idProducto, miConexion);
    }
    
    public List obtenerProductosAsociados(long idProductor) {
        return pDao.obtenerProductosPorId(idProductor, miConexion);
    }
    
    public ProductoDto obtenerProductoConIdProductoAso(int idProductoAso) {
        return pDao.obtenerProductoIdProducoAso(idProductoAso, miConexion);
    }
        
    //Consultas Por Un Criterio (Categorias)
    public String obtenerNombreDeCategoriaPorId(int idCategoria) {
        return caDao.obtenerNombrePorId(idCategoria, miConexion);
    }
    
    //Eliminación de registros directamente
    public String eliminarAsociasionDeProducto(int idProductoAso) {
        return paDao.eliminarUnProductoAsociado(idProductoAso, miConexion);
    }
    
    public List obtenerOfertas(){
        return ofDao.obtenerOfertas(miConexion);
    }
    
    public OfertaDto obtenerOfertaPorId(int idOferta){
        return ofDao.obtenerOfertaPorId(idOferta, miConexion);
    }
}
