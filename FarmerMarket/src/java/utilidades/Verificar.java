/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.sql.Connection;
import java.util.ArrayList;
import modulo.ofertas.FOferta;
import modulo.usuarios.FUsuario;
import modulo.usuarios.dto.PermisoDto;

/**
 *
 * @author User
 */
public class Verificar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnn = Conexion.getInstance();
        if (cnn != null) {
            System.out.println("Run");
        }
         FUsuario f = new FUsuario();
         FOferta fa = new FOferta();
         
         System.out.println(fa.obtenerProductoConIdProductoAso(1073247453));
 
                            
                            
                            
                            
    }
    
   
    
}
