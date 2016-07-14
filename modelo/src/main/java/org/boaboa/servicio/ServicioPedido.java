/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.boaboa.servicio;

import java.util.Date;
import java.util.List;
import org.boaboa.modelo.Mesa;
import org.boaboa.modelo.Pedido;
import org.boaboa.modelo.PedidoProducto;
import org.boaboa.modelo.Producto;
import org.boaboa.modelo.Usuario;

/**
 *
 * @author frubilar
 */
public interface ServicioPedido {
    
 //   public Mesa consultarMesa(Integer id);
    
    public Mesa guardar(Mesa mesa);
    
    public boolean eliminar(Mesa mesa);
    
    public List<Mesa> consultarMesas();
    
    public List<Mesa> consultarMesa(Integer capacidad);
    
    //pedido
    
    public Pedido guardar(Pedido pedido);
    
    public boolean eliminar(Pedido pedido);
    
    public List<Pedido> consultarPedidos();
    
    public List<Pedido> consultarPedidos(Mesa mesa);
    
    public List<Pedido> consultarPedidos(Usuario usuario);
    
    public Pedido consultarPedido(Integer id);
    
    
    //pedidoProducto
    
    public PedidoProducto guardar(PedidoProducto pedidoProducto);
    
    public boolean eliminar(PedidoProducto pedidoProducto);
    
    public PedidoProducto consultarPedidoProducto(Integer id);
    
    public List<PedidoProducto> consultarPedidoProductos();
    
    public List<PedidoProducto> consultarPedidoProductos(Pedido pedido);
    
    public List<PedidoProducto> consultarPedidoProductos(Producto producto);
    
    public List<PedidoProducto> consultarPedidoProductos(Pedido pedido, Date fecha);
    
    public List<PedidoProducto> consultarPedidoProductos(Date fecha);
    
    
}
