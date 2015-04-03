/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.ofertas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modulo.ofertas.FOferta;
import modulo.ofertas.dto.OfertaDto;
import modulo.usuarios.FUsuario;
import utilidades.Correo;

/**
 *
 * @author User
 */
public class ControladorOferta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        FOferta faOfer = new FOferta();
        FUsuario faUsu = new FUsuario();
        String salida;
        String correo;
        String mensajeCorreo;
        //Asociar un Producto
        if (request.getParameter("apEnviar") != null && request.getParameter("apEnviar").equals("Asociar")) {
            String codeProductosEnString[];
            long idProductor = Long.parseLong(request.getParameter("apidProductor"));
            codeProductosEnString = request.getParameterValues("apProductos");

            List<Integer> codeProductosInt = new ArrayList<Integer>();
            for (int i = 0; i < codeProductosEnString.length; i++) {
                if (!faOfer.validarProductoYaAsociado(idProductor, Integer.parseInt(codeProductosEnString[i]))) {
                    codeProductosInt.add(Integer.parseInt(codeProductosEnString[i]));
                }
            }

            //Después de validar todos los productos, en caso de que alguno de ellos ya se haya asociado, retornará un falso
            if (codeProductosInt.size() > 0) {
                int codProductosArray[] = new int[codeProductosInt.size()];
                for (int i = 0; i < codeProductosInt.size(); i++) {
                    codProductosArray[i] = codeProductosInt.get(i).intValue();
                }
                salida = faOfer.asociarProductos(idProductor, codProductosArray);

                mensajeCorreo = "Se le han asociado unos productos a petición suya.";

                correo = faUsu.obtenerCorreoPorDocumento(idProductor);

                if (salida.equals("ok")) {
                    if (Correo.sendMail("Productos Asociados", mensajeCorreo, correo)) {
                        //Respuesta afirmativa y envío de correo
                        response.sendRedirect("pages/asociarproducto.jsp?msg=<strong>¡Asociasión Éxitosa! <i class='glyphicon glyphicon-ok'></i></strong> Revise su correo para ver el listado de productos ó mírelos en Mis Productos.&tipoAlert=success");
                    } else {
                        //Respuesta afirmativa y no se envío de correo
                        response.sendRedirect("pages/asociarproducto.jsp?msg=<strong>¡Asociasión Éxitosa! <i class='glyphicon glyphicon-ok'></i></strong> Mírelos en Mis Productos.&tipoAlert=success");
                    }
                } else if (salida.equals("okno")) {
                    //Respuesta desconocida, no se realizó
                    response.sendRedirect("pages/asociarproducto.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> Por favor intentelo de nuevo.&tipoAlert=warning");
                } else {
                    //Respuesta conocida, no se realizó
                    response.sendRedirect("pages/asociarproducto.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
                }
            } else {
                //respuesta a productos ya asociados anteriormente.
                response.sendRedirect("pages/asociarproducto.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Producto(s) ya asociado(s)!</strong> Por favor intentelo de nuevo, no puede asociar un producto dos veces.&tipoAlert=warning");
            }

            //Eliminar Producto Asociado
        } else if (request.getParameter("op") != null && request.getParameter("op").equals("eliaso")) {
            int idProductoAso = Integer.parseInt(request.getParameter("idProductoAso"));

            salida = faOfer.eliminarAsociasionDeProducto(idProductoAso);

            if (salida.equals("ok")) {
                //Respuesta afirmativa y envío de corre
                response.sendRedirect("pages/misproductos.jsp?msg=<strong>¡Eliminación Éxitosa! <i class='glyphicon glyphicon-ok'></i></strong> Se desasocio el producto.&tipoAlert=success");
            } else if (salida.equals("okno")) {
                //Respuesta desconocida, no se realizó
                response.sendRedirect("pages/misproductos.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> No se puede des-asociar productos que tienen ofertas.&tipoAlert=warning");
            } else {
                //Respuesta conocida, no se realizó
                response.sendRedirect("pages/misproductos.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
            }
        } else if (request.getParameter("ofertar") != null) {
            OfertaDto ofertas = new OfertaDto();
            ofertas.setPrecioVenta(Integer.parseInt(request.getParameter("opPrecioVenta")));
            ofertas.setIdPresentacion(Integer.parseInt(request.getParameter("Presentacion")));
            ofertas.setIdPromocion(Integer.parseInt(request.getParameter("novedad")));
            ofertas.setCantidad(Float.parseFloat(request.getParameter("cantidad")));
            int idProductoAso = Integer.parseInt(request.getParameter("idProductoAsociado"));

            if (!faOfer.existeOfertaPorIdProducto(idProductoAso)) {
                salida = faOfer.insertarOferta(ofertas, idProductoAso);
                if (salida.equals("ok")) {
                    //Respuesta afirmativa y envío de corre
                    response.sendRedirect("pages/misofertas.jsp?msg=<strong>¡Oferta exitosa! <i class='glyphicon glyphicon-ok'></i></strong> Se agrego la oferta correctamente.&tipoAlert=success");
                } else if (salida.equals("okno")) {
                    //Respuesta desconocida, no se realizó
                    response.sendRedirect("pages/misproductos.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> Por favor intentelo de nuevo.&tipoAlert=warning");
                } else {
                    //Respuesta conocida, no se realizó
                    response.sendRedirect("pages/misproductos.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
                }
            } else {
                response.sendRedirect("pages/misproductos.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> No se puede realizar dos ofertas del mismo producto.&tipoAlert=warning");

            }

        } else if (request.getParameter("modificarof") != null) {
            int idoferta = Integer.parseInt(request.getParameter("idOfertaSeleccionada"));
            int dias = Integer.parseInt(request.getParameter("mdfechafin"));
            int promocion = Integer.parseInt(request.getParameter("novedad"));
            salida = faOfer.modificarOferta(idoferta, dias, promocion);
            if (salida.equals("ok")) {
                //Respuesta afirmativa y envío de corre
                response.sendRedirect("pages/misofertas.jsp?msg=<strong>¡Oferta exitosa! <i class='glyphicon glyphicon-ok'></i></strong> Se modifico la oferta correctamente.&tipoAlert=success");
            } else if (salida.equals("okno")) {
                //Respuesta desconocida, no se realizó
                response.sendRedirect("pages/misofertas.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> Por favor intentelo de nuevo.&tipoAlert=warning");
            } else {
                //Respuesta conocida, no se realizó
                response.sendRedirect("pages/misofertas.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
            }

        } else if (request.getParameter("op") != null && request.getParameter("op").equals("eliminarOferta")) {
            int idOferta = Integer.parseInt(request.getParameter("idOferta"));

            salida = faOfer.eliminarOferta(idOferta);

            if (salida.equals("ok")) {
                //Respuesta afirmativa y envío de corre
                response.sendRedirect("pages/misofertas.jsp?msg=<strong>¡Eliminación Éxitosa! <i class='glyphicon glyphicon-ok'></i></strong> Se elimino la oferta.&tipoAlert=success");
            } else if (salida.equals("okno")) {
                //Respuesta desconocida, no se realizó
                response.sendRedirect("pages/misofertas.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Algo salió mal!</strong> No se puede eliminar ofertas que tienen pedidos.&tipoAlert=warning");
            } else {
                //Respuesta conocida, no se realizó
                response.sendRedirect("pages/misofertas.jsp?msg=<strong><i class='glyphicon glyphicon-exclamation-sign'></i> ¡Ocurrió un error!</strong> Detalle: " + salida + "&tipoAlert=danger");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
