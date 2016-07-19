/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.boaboa.servicio;

import java.util.Date;
import java.util.List;
import org.boaboa.modelo.Rol;
import org.boaboa.modelo.Turno;
import org.boaboa.modelo.Usuario;

/**
 *
 * @author frubilar
 */
public interface ServicioUsuario {
    
    public Usuario guardar(Usuario usuario);
    
    public boolean eliminar(Usuario usuario);
    
    public List<Usuario> consultarUsuarios();
    
    public Usuario ConsultarUsuario(Integer rut);
    
    public Usuario ConsultarUsuario(String nombre);
    
    public Usuario consultarUsuario(Integer id);
    
    //roles
    
    public Rol consultarRol(Integer id);
    
    public Rol guardar(Rol rol);
    
    public boolean eliminar(Rol rol);
    
    public List<Rol> consultarRoles();
    
    public Rol consultarRol(String nombre);
    
    //turno
    
    public Turno consultarTurno(Integer id);
    
    public Turno guardar(Turno turno);
    
    public boolean eliminar(Turno turno);
    
    public List<Turno> consultarTurnos();
    
    public List<Turno> consultarTurnos(Usuario usuario);
    
    public List<Turno> consultarTurnos(Date fecha);
     
}
