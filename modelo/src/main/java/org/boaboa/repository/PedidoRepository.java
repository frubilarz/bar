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
import org.boaboa.modelo.Pedido;
import org.boaboa.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "pedidoRepository")
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

    public List<Pedido> findByMesa(Mesa mesa);
    
    public List<Pedido> finByUsuario(Usuario usuario);
    
}
