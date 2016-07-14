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
import org.apache.commons.lang3.StringUtils;
import org.boaboa.modelo.Boleta;
import org.boaboa.modelo.FormaPago;
import org.boaboa.repository.BoletaRepository;
import org.boaboa.repository.FormaPagoRepository;
import org.boaboa.servicio.ServicioBoleta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author frubilar
 */
@Service("servicioBoleta")
public class ServicioBoletaImpl implements ServicioBoleta, Serializable {

    private static final long serialVersionUID = 3533130047836877824L;
    @Resource(name = "boletaRepository")
    private BoletaRepository boletaRepository;
    @Resource(name = "formaPagoRepository")
    private FormaPagoRepository formaPagoRepository;
    private static final Logger logger = LoggerFactory.getLogger(ServicioBoletaImpl.class);

    @Override
    public Boleta consultarBoleta(Integer id) {
        Boleta salida = null;
        try {
            if (id != null) {
                salida = boletaRepository.findOne(id);
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al obtener boleta: {}", e.toString());
            logger.debug("Error al obtener boleta: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public List<Boleta> consultarBoletas() {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
            boletas = boletaRepository.findAll();
        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.debug("error al intentar obtener todas las boletas: {}", e.toString(), e);
            logger.error("error al intentar obtener todas las boletas: {}", e.toString());
        }
        return boletas;
    }

    @Override
    public List<Boleta> consultarBoleta(Date fecha) {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
            if (fecha != null) {
                boletas = boletaRepository.findByFecha(fecha);
            }
        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.error("Error al intentar obtener boletas por fecha: {}", e.toString());
            logger.debug("Error al intentar obtener boletas por fecha: {}", e.toString(), e);
        }
        return boletas;
    }

    @Override
    public List<Boleta> consultarBoleta(FormaPago formaPago) {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
            if (formaPago != null) {
                boletas = boletaRepository.findByFormaPago(formaPago);
            }
        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.error("Error al intentar obtener boletas por forma de pago: {}", e.toString());
            logger.debug("Error al intentar obtener boletas por forma de pago: {}", e.toString(), e);
        }
        return boletas;
    }

    @Override
    @Transactional
    public Boleta guardar(Boleta boleta) {
        Boleta salida = null;
        try {
            if (boleta != null) {
                salida = boletaRepository.save(boleta);
                logger.info("Boleta persistida correctamente con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar persistir una boleta: {}", e.toString(), e);
            logger.error("Error al intentar Persistir una boleta: {}", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Boleta boleta) {
        boolean salida = false;
        try {
            if (boleta != null) {
                boletaRepository.delete(boleta);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar eliminar boleta: {}", e.toString(), e);
            logger.error("Error al intentar eliminar boleta: {}", e.toString());
        }
        return salida;

    }

    @Override
    @Transactional
    public FormaPago guardar(FormaPago formaPago) {
        FormaPago salida = null;
        try {
            if (formaPago != null) {
                salida = formaPagoRepository.save(formaPago);
                logger.info("forma de pago persistida con exito: {}", salida.getId());
            }
        } catch (Exception e) {
            formaPago = null;
            logger.debug("Error al intentar persistir una forma de pago: {} ", e.toString(), e);
            logger.error("Error al intentar persistir una forma de pago: {} ", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(FormaPago formaPago) {
        boolean salida = false;
        try {
            if (formaPago != null) {
                formaPagoRepository.delete(formaPago);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.error("Error al intentar eliminar: {}", e.toString());
            logger.debug("Error al intentar eliminar: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public FormaPago consultarFormaPago(Integer id) {
        FormaPago formaPago = null;
        try {
            if (id != null) {
                formaPago = formaPagoRepository.findOne(id);
            }
        } catch (Exception e) {
            formaPago = null;
            logger.error("Error al intentar buscar por id forma de pago: {}", e.toString());
            logger.debug("Error al intentar buscar por id forma de pago: {}", e.toString(), e);
        }
        return formaPago;
    }

    @Override
    public List<FormaPago> consultarFormaPagos() {
        List<FormaPago> formaPagos = new ArrayList<FormaPago>();
        try {
            formaPagos = formaPagoRepository.findAll();
        } catch (Exception e) {
            formaPagos = new ArrayList<FormaPago>();
            logger.error("Error al intetar obtener todas las formas de pago: {}", e.toString());
            logger.debug("Error al intetar obtener todas las formas de pago: {}", e.toString(), e);
        }
        return formaPagos;
    }

    @Override
    public FormaPago consultarFormaPago(String formapago) {
        FormaPago salida = null;
        try {
            if (StringUtils.isEmpty(formapago)) {
                salida = formaPagoRepository.findByNombreIgnoreCase(formapago);
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar obtener forma de pago por nombre: {}", e.toString());
            logger.debug("Error al intentar obtener forma de pago por nombre: {}", e.toString(), e);
        }
        return salida;
    }

}
