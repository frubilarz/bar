/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.servicio;

import java.util.List;
import org.boaboa.modelo.Producto;
import org.boaboa.modelo.TipoProducto;

/**
 *
 * @author frubilar
 */
public interface ServicioProducto {

    public Producto guardar(Producto producto);

    public boolean eliminar(Producto producto);
    
    public Producto consultarProducto(Integer id);

    public List<Producto> consultarProductos();

    public Producto consultarProducto(String nombre);

    public List<Producto> consultarProductos(TipoProducto tipoProducto);

    public List<Producto> consutlarProductos(boolean stock);

    //tipo Producto
    public TipoProducto guardar(TipoProducto tipoProducto);

    public boolean eliminar(TipoProducto tipoProducto);

    public List<TipoProducto> consultarTiposProductos();

    public TipoProducto consultarTipoProducto(String nombre);

    public TipoProducto consultarTipoProducto(Integer id);
    
}
