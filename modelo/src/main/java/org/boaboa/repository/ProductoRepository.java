/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.repository;

import java.util.List;
import javax.annotation.Resource;
import org.boaboa.modelo.Producto;
import org.boaboa.modelo.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frubilar
 */
@Resource(name = "productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public Producto findByNombreIgnoreCase(String nombre);

    public List<Producto> findByTipoProducto(TipoProducto tipoProducto);

    public List<Producto> findByStock(boolean b);
}
