/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.servicio;

import java.util.Date;
import java.util.List;
import org.boaboa.modelo.Boleta;
import org.boaboa.modelo.FormaPago;

/**
 *
 * @author frubilar
 */
public interface ServicioBoleta {

    public Boleta consultarBoleta(Integer id);

    public List<Boleta> consultarBoletas();

    public List<Boleta> consultarBoleta(Date fecha);
    
    public List<Boleta> consultarBoleta(FormaPago formaPago);
    
    public Boleta guardar(Boleta boleta);
    
    public boolean eliminar(Boleta boleta);
    
    // forma pago
    
    public FormaPago guardar(FormaPago formaPago);
    
    public boolean eliminar(FormaPago formaPago);
    
    public FormaPago consultarFormaPago(Integer id);
    
    public List<FormaPago> consultarFormaPagos();
    
    public FormaPago consultarFormaPago(String formapago);
    
    
    
    
}