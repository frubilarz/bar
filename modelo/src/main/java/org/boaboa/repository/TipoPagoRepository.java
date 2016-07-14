/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.repository;

import javax.annotation.Resource;
import org.boaboa.modelo.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "tipoPagoRepository")
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {

    public TipoPago findByNombreIgnoreCase(String nombre);
}
