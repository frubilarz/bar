/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.boaboa.modelo.Pedido;
import org.boaboa.modelo.PedidoProducto;
import org.boaboa.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "pedidoProductoRepository")
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer> {

    public List<PedidoProducto> findByPedido(Pedido pedido);

    public List<PedidoProducto> findByProducto(Producto producto);

    public List<PedidoProducto> findByPedidoAndFecha(Pedido pedido, Date fecha);

    public List<PedidoProducto> findByFecha(Date fecha);

}
