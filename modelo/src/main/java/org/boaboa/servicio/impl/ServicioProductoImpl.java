/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.servicio.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.boaboa.modelo.Producto;
import org.boaboa.modelo.TipoProducto;
import org.boaboa.repository.ProductoRepository;
import org.boaboa.repository.TipoProductoRepository;
import org.boaboa.servicio.ServicioProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author frubilar
 */
@Service("servicioProducto")
public class ServicioProductoImpl implements Serializable, ServicioProducto {

    private static final long serialVersionUID = 3533130047836877824L;
    private static final Logger logger = LoggerFactory.getLogger(ServicioProductoImpl.class);

    @Resource(name = "productoRepository")
    private ProductoRepository productoRepository;

    @Resource(name = "tipoProductoRepository")
    private TipoProductoRepository tipoProductoRepository;

    @Override
    @Transactional
    public Producto guardar(Producto producto) {
        Producto salida = null;
        try {
            if (producto != null) {
                salida = productoRepository.save(producto);
                logger.info("Producto persistido con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar persistir producto: {}", e.toString(), e);
            logger.error("Error al intentar persistir producto: {}", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Producto producto) {
        boolean salida = false;
        try {
            if (producto != null) {
                productoRepository.delete(producto);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.error("Error al intentar eliminar producto: {}", e.toString());
            logger.debug("Error al intentar eliminar producto: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public Producto consultarProducto(Integer id) {
        Producto salida = null;
        try {
            if (id != null) {
                salida = productoRepository.findOne(id);
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar obtener un producto por id: {}", e.toString());
            logger.debug("Error al intentar obtener un producto por id: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public List<Producto> consultarProductos() {
        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = productoRepository.findAll();
        } catch (Exception e) {
            productos = new ArrayList<Producto>();
            logger.debug("Error al intentar obtener todos los productos: {}", e.toString(), e);
            logger.error("Error al intentar obtener todos los productos: {}", e.toString());
        }
        return productos;
    }

    @Override
    public Producto consultarProducto(String nombre) {
        Producto producto = null;
        try {
            if (StringUtils.isNotEmpty((nombre))) {
                producto = productoRepository.findByNombreIgnoreCase(nombre);
            }
        } catch (Exception e) {
            producto = null;
            logger.error("Error al intentar obtener un producto por nombre: {}", e.toString());
            logger.debug("Error al intentar obtener un producto por nombre: {}", e.toString(), e);
        }
        return producto;
    }

    @Override
    public List<Producto> consultarProductos(TipoProducto tipoProducto) {
        List<Producto> productos = new ArrayList<Producto>();
        try {
            if (tipoProducto != null) {
                productos = productoRepository.findByTipoProducto(tipoProducto);
            }
        } catch (Exception e) {
            productos = new ArrayList<Producto>();
            logger.error("Error al intentar obtener productos por tipo: {}", e.toString());
            logger.debug("Error al intentar obtener productos por tipo: {}", e.toString(), e);
        }
        return productos;
    }

    @Override
    public List<Producto> consutlarProductos(boolean stock) {
        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = productoRepository.findByStock(stock);
        } catch (Exception e) {
            productos = new ArrayList<Producto>();
            logger.debug("Error al intentar obtener productos por stock: {}", e.toString(), e);
            logger.error("Error al intentar obtener productos por stock: {}", e.toString());
        }
        return productos;
    }

    @Override
    public TipoProducto guardar(TipoProducto tipoProducto) {
        TipoProducto salida = null;
        try {
            if (tipoProducto != null) {
                salida = tipoProductoRepository.save(tipoProducto);
                logger.info("Tipo producto persistido con exito : {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar persistir un tipo producto: {}", e.toString());
            logger.debug("Error al intentar persistir un tipo producto: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public boolean eliminar(TipoProducto tipoProducto) {
        boolean salida = false;
        try {
            if (tipoProducto != null) {
                tipoProductoRepository.delete(tipoProducto);
                salida = true;
            }
        } catch (Exception e) {
            salida = true;
            logger.debug("Error al intentar eliminar un  tipo producto :{} ", e.toString(), e);
            logger.error("Error al intentar eliminar un  tipo producto :{} ", e.toString());
        }
        return salida;
    }

    @Override
    public List<TipoProducto> consultarTiposProductos() {
        List<TipoProducto> tipoProductos = new ArrayList<TipoProducto>();
        try {
            tipoProductos = tipoProductoRepository.findAll();
        } catch (Exception e) {
            tipoProductos= new ArrayList<TipoProducto>();
            logger.error("Error al intentar consultar toos tipos producto: {}",e.toString());
            logger.debug("Error al intentar consultar toos tipos producto: {}",e.toString(),e);
        }
        return tipoProductos;
    }

    @Override
    public TipoProducto consultarTipoProducto(String nombre) {
        TipoProducto salida = null;
        try {
            if(StringUtils.isNotEmpty(nombre)){
                salida = tipoProductoRepository.findByNombreIgnoreCase(nombre);
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar obtener un tipo producto por nombre: {}",e.toString());
            logger.debug("Error al intentar obtener un tipo producto por nombre: {}",e.toString(),e);
        }
        return salida;
    }

    @Override
    public TipoProducto consultarTipoProducto(Integer id) {
        TipoProducto salida = null;
        try {
            if(id!=null){
                salida = tipoProductoRepository.findOne(id);
            }
        } catch (Exception e) {
            salida  = null;
            logger.error("Error al intentar obtener un tipo producto por id: {}",e.toString());
            logger.debug("Error al intentar obtener un tipo producto por id: {}",e.toString(),e);
        }
        return salida;
    }

}
