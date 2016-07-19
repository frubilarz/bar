/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.repository;

import java.io.Serializable;
import javax.annotation.Resource;
import org.boaboa.modelo.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "formaPagoRepository")
public interface FormaPagoRepository extends JpaRepository<FormaPago, Integer> {

    public FormaPago findByNombreIgnoreCase(String nombre);
}
