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
import org.boaboa.modelo.Turno;
import org.boaboa.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "turnoRepository")
public interface TurnoRepository extends JpaRepository<Turno, Integer>{
    
    public List<Turno> findByUsuario(Usuario usuario);
    
    public List<Turno> findByFecha(Date fecha);
}
