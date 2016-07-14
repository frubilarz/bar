/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.servicio.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.boaboa.modelo.Mesa;
import org.boaboa.modelo.Pedido;
import org.boaboa.modelo.PedidoProducto;
import org.boaboa.modelo.Producto;
import org.boaboa.modelo.Usuario;
import org.boaboa.repository.MesaRepository;
import org.boaboa.repository.PedidoProductoRepository;
import org.boaboa.repository.PedidoRepository;
import org.boaboa.servicio.ServicioPedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author frubilar
 */
@Service("servicioPedido")
public class ServicioPedidoImpl implements ServicioPedido, Serializable {

    private static final long serialVersionUID = 3533130047836877824L;
    private static final Logger logger = LoggerFactory.getLogger(ServicioPedidoImpl.class);

    @Resource(name = "mesaRepository")
    private MesaRepository mesaRepository;
    @Resource(name = "pedidoRepository")
    private PedidoRepository pedidoRepository;
    @Resource(name = "pedidoProductoRepository")
    private PedidoProductoRepository pedidoProductoRepository;

    @Override
    @Transactional
    public Mesa guardar(Mesa mesa) {
        Mesa salida = null;
        try {
            if (mesa != null) {
                salida = mesaRepository.save(mesa);
                logger.info("Mesa Persistido con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar guardar mesa: {}", e.toString());
            logger.debug("Error al intentar guardar mesa: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Mesa mesa) {
        boolean salida = false;
        try {
            if (mesa != null) {
                mesaRepository.delete(mesa);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.error("Error al intentar eliminar una mesa: {}", e.toString());
            logger.debug("Error al intentar eliminar una mesa: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public List<Mesa> consultarMesas() {
        List<Mesa> mesas = new ArrayList<Mesa>();
        try {
            mesas = mesaRepository.findAll();
        } catch (Exception e) {
            mesas = new ArrayList<Mesa>();
            logger.error("Error al intentar traer todas las mesas: {}", e.toString());
            logger.debug("Error al intentar traer todas las mesas: {}", e.toString(), e);
        }
        return mesas;
    }

    @Override
    public List<Mesa> consultarMesa(Integer capacidad) {
        List<Mesa> mesas = new ArrayList<Mesa>();
        try {
            if (capacidad != null) {
                mesas = mesaRepository.findByCapacidadGreaterThan(capacidad);
            }
        } catch (Exception e) {
            mesas = new ArrayList<Mesa>();
            logger.error("Error al intentar obtener mesas por capacidad: {}", e.toString());
            logger.debug("Error al intentar obtener mesas por capacidad: {}", e.toString(), e);
        }
        return mesas;
    }

    @Override
    @Transactional
    public Pedido guardar(Pedido pedido) {
        Pedido salida = null;
        try {
            if (pedido != null) {
                salida = pedidoRepository.save(pedido);
                logger.info("persistido pedido con exito con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar persistir un pedido: {}", e.toString());
            logger.debug("Error al intentar persistir un pedido: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Pedido pedido) {
        boolean salida = false;
        try {
            if (pedido != null) {
                pedidoRepository.delete(pedido);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar eliminar un pedido: {}", e.toString(), e);
            logger.error("Error al intentar eliminar un pedido: {}", e.toString());
        }
        return salida;
    }

    @Override
    public List<Pedido> consultarPedidos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            pedidos = pedidoRepository.findAll();
        } catch (Exception e) {
            pedidos = new ArrayList<Pedido>();
            logger.debug("Error al intentar obtener todos los pedidos: {}", e.toString(), e);
            logger.error("Error al intentar obtener todos los pedidos: {}", e.toString());
        }
        return pedidos;
    }

    @Override
    public List<Pedido> consultarPedidos(Mesa mesa) {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            if (mesa != null) {
                pedidos = pedidoRepository.findByMesa(mesa);
            }
        } catch (Exception e) {
            pedidos = new ArrayList<Pedido>();
            logger.error("Error al intentar traer pedidos de una mesa: {}", e.toString(), e);
            logger.debug("Error al intentar traer pedidos por mesa: {}", e.toString());
        }
        return pedidos;
    }

    @Override
    public List<Pedido> consultarPedidos(Usuario usuario) {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            if (usuario != null) {
                pedidos = pedidoRepository.finByUsuario(usuario);
            }
        } catch (Exception e) {
            pedidos = new ArrayList<Pedido>();
            logger.debug("Error al intentar obtener pedido por usuario: {}", e.toString(), e);
            logger.error("Error al intentar obtener pedido por usuario: {}", e.toString());
        }
        return pedidos;
    }

    @Override
    public Pedido consultarPedido(Integer id) {
        Pedido pedido = null;
        try {
            if (id != null) {
                pedido = pedidoRepository.findOne(id);
            }
        } catch (Exception e) {
            pedido = null;
            logger.debug("Error al intentar obtener pedido por id: {}", e.toString(), e);
            logger.error("Error al intentar obtener pedido por id: {}", e.toString());
        }
        return pedido;
    }

    @Override
    @Transactional
    public PedidoProducto guardar(PedidoProducto pedidoProducto) {
        PedidoProducto salida = null;
        try {
            if (pedidoProducto != null) {
                salida = pedidoProductoRepository.save(pedidoProducto);
                logger.info("Pedido producto persistido con exito con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar persistir un pedido producto", e.toString());
            logger.debug("Error al intentar persistir un pedido producto", e.toString(), e);
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(PedidoProducto pedidoProducto) {
        boolean salida = false;
        try {
            if(pedidoProducto!=null){
                pedidoProductoRepository.delete(pedidoProducto);
                salida  = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.error("error al intentar eliminar un pedido producto: {}",e.toString());
            logger.debug("error al intentar eliminar un pedido producto: {}",e.toString(),e);
        }
        return salida;
    }

    @Override
    public PedidoProducto consultarPedidoProducto(Integer id) {
        PedidoProducto pedidoProducto = null;
        try {
            if(id!=null){
                pedidoProducto = pedidoProductoRepository.findOne(id);
            }
        } catch (Exception e) {
            pedidoProducto = null;
            logger.error("Error al intentar obtener un pedido producto por id: {}",e.toString());
            logger.debug("Error al intentar obtener un pedido producto por id: {}",e.toString(),e);
        }
        return pedidoProducto;
    }

    @Override
    public List<PedidoProducto> consultarPedidoProductos() {
        List<PedidoProducto> pedidoProductos = new ArrayList<PedidoProducto>();
        try {
            pedidoProductos = pedidoProductoRepository.findAll();
        } catch (Exception e) {
            pedidoProductos = new ArrayList<PedidoProducto>();
            logger.debug("Error al intentar obtener todos los pedidos productos",e.toString(),e);
            logger.error("Error al intentar obtener todos los pedidos productos",e.toString());
        }
        return pedidoProductos;
    }

    @Override
    public List<PedidoProducto> consultarPedidoProductos(Pedido pedido) {
        List<PedidoProducto> pedidoProductos = new ArrayList<PedidoProducto>();
        try {
            if(pedido!=null){
                pedidoProductos = pedidoProductoRepository.findByPedido(pedido);
            }
        } catch (Exception e) {
            pedidoProductos = new ArrayList<PedidoProducto>();
            logger.error("Error al intentar obtener pedido producto por pedido: {}",e.toString());
            logger.debug("Error al intentar obtener pedido producto por pedido: {}",e.toString(),e);
        }
        return pedidoProductos;
    }

    @Override
    public List<PedidoProducto> consultarPedidoProductos(Producto producto) {
        List<PedidoProducto>  pedidoProductos = new ArrayList<PedidoProducto>();
        try {
            if(producto!=null){
                pedidoProductos = pedidoProductoRepository.findByProducto(producto);
            }
        } catch (Exception e) {
            pedidoProductos = new ArrayList<PedidoProducto>();
            logger.error("Error al intentar obtener pedido producto por procudto: {}",e.toString());
            logger.debug("Error al intentar obtener pedido producto por procudto: {}",e.toString(),e);
        }
        return pedidoProductos;
    }

    @Override
    public List<PedidoProducto> consultarPedidoProductos(Pedido pedido, Date fecha) {
        List<PedidoProducto> pedidoProductos = new ArrayList<PedidoProducto>();
        try {
            if(pedido !=null && fecha != null){
                pedidoProductos = pedidoProductoRepository.findByPedidoAndFecha(pedido, fecha);
            }
        } catch (Exception e) {
            pedidoProductos = new ArrayList<PedidoProducto>();
            logger.error("Error al intentar obtener un pedido producto: {}",e.toString());
            logger.debug("Error al intentar obtener un pedido producto: {}",e.toString(),e);
        }
        return pedidoProductos;
    }

    @Override
    public List<PedidoProducto> consultarPedidoProductos(Date fecha) {
        List<PedidoProducto> pedidoProductos = new ArrayList<PedidoProducto>();
        try {
            if(fecha!=null){
                pedidoProductos = pedidoProductoRepository.findByFecha(fecha);
            }
        } catch (Exception e) {
            logger.debug("Error al intentar obtener un pedido producto: {}",e.toString(),e);
            logger.error("Error al intentar obtener un pedido producto: {}",e.toString());
        }
        return pedidoProductos;
    }

}
