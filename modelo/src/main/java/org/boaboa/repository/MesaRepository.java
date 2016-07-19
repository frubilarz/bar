/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.repository;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.boaboa.modelo.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "mesaRepository")
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    public Mesa findByNumero(Integer numero);

    public List<Mesa> findByCapacidadGreaterThan(Integer capacidad);

}
