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
import org.boaboa.modelo.Rol;
import org.boaboa.modelo.Turno;
import org.boaboa.modelo.Usuario;
import org.boaboa.repository.RolRepository;
import org.boaboa.repository.TurnoRepository;
import org.boaboa.repository.UsuarioRepository;
import org.boaboa.servicio.ServicioUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author frubilar
 */
@Service("servicioUsuario")
public class ServicioUsuarioImpl implements ServicioUsuario, Serializable {

    private static final long serialVersionUID = 3533130047836877824L;
    private static final Logger logger = LoggerFactory.getLogger(ServicioUsuarioImpl.class);

    @Resource(name = "usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Resource(name = "rolRepository")
    private RolRepository rolRepository;

    @Resource(name = "turnoRepository")
    private TurnoRepository turnoRepository;

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {

        Usuario salida = null;
        try {
            if (usuario != null) {
                salida = usuarioRepository.save(usuario);
                logger.info("Usuario Persistido con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar persistir usuario: {}", e.toString(), e);
            logger.error("Error al intentar persistir usuario: {}", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Usuario usuario) {
        boolean salida = false;
        try {
            if (usuario != null) {
                usuarioRepository.delete(usuario);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.error("Error al intentar eliminar un usuario: {}", e.toString());
            logger.debug("Error al intentar eliminar un usuario: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            usuarios = usuarioRepository.findAll();
        } catch (Exception e) {
            usuarios = new ArrayList<Usuario>();
            logger.error("Error al intentar obtener todos los usuarios: {}", e.toString());
            logger.debug("Error al intentar obtener todos los usuarios: {}", e.toString(), e);
        }
        return usuarios;
    }

    @Override
    public Usuario ConsultarUsuario(Integer rut) {
        Usuario usuario = null;
        try {
            if (rut != null) {
                usuario = usuarioRepository.findByRut(rut);
            }
        } catch (Exception e) {
            usuario = null;
            logger.debug("Error al intentar obtener usuario por rut: {}", e.toString(), e);
            logger.error("Error al intentar obtener usuario por rut: {}", e.toString());
        }
        return usuario;
    }

    @Override
    public Usuario ConsultarUsuario(String nombre) {
        Usuario usuario = null;
        try {
            if (StringUtils.isEmpty(nombre)) {
                usuario = usuarioRepository.findByNombreIgnoreCase(nombre);
            }
        } catch (Exception e) {
            usuario = null;
            logger.error("Error al intentar obtener un usuario por nombre: {}", e.toString());
            logger.debug("Error al intentar obtener un usuario por nombre: {}", e.toString(), e);
        }
        return usuario;
    }

    @Override
    public Usuario consultarUsuario(Integer id) {
        Usuario usuario = null;
        try {
            if (id != null) {
                usuario = usuarioRepository.findOne(id);
            }
        } catch (Exception e) {
            usuario = null;
            logger.error("Error al intentar obtener usuario id: {}", e.toString());
            logger.debug("Error al intentar obtener usuario id: {}", e.toString(), e);
        }
        return usuario;
    }

    @Override
    public Rol consultarRol(Integer id) {
        Rol rol = null;
        try {
            if (id != null) {
                rol = rolRepository.findOne(id);
            }
        } catch (Exception e) {
            rol = null;
            logger.error("Error al intentar obtener un rol por id: {}", e.toString());
            logger.debug("Error al intentar obtener un rol por id: {}", e.toString(), e);
        }
        return rol;
    }

    @Override
    @Transactional
    public Rol guardar(Rol rol) {
        Rol salida = null;
        try {
            if (rol != null) {
                salida = rolRepository.save(rol);
                logger.info("Guardado  rol con exito: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar persistir un rol: {}", e.toString(), e);
            logger.error("Error al intentar persistir un rol: {}", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Rol rol) {
        boolean salida = false;
        try {
            if (rol != null) {
                rolRepository.delete(rol);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar eliminar un rol: {}", e.toString(), e);
            logger.error("Error al intentar eliminar un rol: {}", e.toString());
        }
        return salida;
    }

    @Override
    public List<Rol> consultarRoles() {
        List<Rol> roles = new ArrayList<Rol>();
        try {
            roles = rolRepository.findAll();
        } catch (Exception e) {
            roles = new ArrayList<Rol>();
            logger.debug("Error al intentar traer todos los roles  :{}", e.toString(), e);
            logger.error("Error al intentar traer todos los roles  :{}", e.toString());
        }
        return roles;
    }

    @Override
    public Rol consultarRol(String nombre) {
        Rol salida = null;
        try {
            if (StringUtils.isNotEmpty(nombre)) {
                salida = rolRepository.findByNombreIgnoreCase(nombre);
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar consultar rol por nombre: {}", e.toString(), e);
            logger.error("Error al intentar consultar rol por nombre: {}", e.toString());
        }
        return salida;
    }

    @Override
    public Turno consultarTurno(Integer id) {
        Turno salida = null;
        try {
            if (id != null) {
                salida = turnoRepository.findOne(id);
            }
        } catch (Exception e) {
            salida = null;
            logger.error("Error al intentar obtener turno por id: {}", e.toString());
            logger.debug("Error al intentar obtener turno por id: {}", e.toString(), e);
        }
        return salida;
    }

    @Override
    @Transactional
    public Turno guardar(Turno turno) {
        Turno salida = null;
        try {
            if (turno != null) {
                salida = turnoRepository.save(turno);
                logger.info("turno persistido con id: {}", salida.getId());
            }
        } catch (Exception e) {
            salida = null;
            logger.debug("Error al intentar persistir un turno: {}", e.toString(), e);
            logger.error("Error al intentar persistir un turno: {}", e.toString());
        }
        return salida;
    }

    @Override
    @Transactional
    public boolean eliminar(Turno turno) {
        boolean salida = false;
        try {
            if (turno != null) {
                turnoRepository.delete(turno);
                salida = true;
            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar eliminar un turno :{}", e.toString(), e);
            logger.error("Error al intentar eliminar un turno :{}", e.toString());
        }
        return salida;
    }

    @Override
    public List<Turno> consultarTurnos() {
        List<Turno> turnos = new ArrayList<Turno>();
        try {
            turnos = turnoRepository.findAll();
        } catch (Exception e) {
            turnos = new ArrayList<Turno>();
            logger.debug("Error al intentar obtener todos los turnos: {}", e.toString(), e);
            logger.error("Error al intentar obtener todos los turnos: {}", e.toString());
        }
        return turnos;
    }

    @Override
    public List<Turno> consultarTurnos(Usuario usuario) {
        List<Turno> turnos = new ArrayList<Turno>();
        try {
            if (usuario != null) {
                turnos = turnoRepository.findByUsuario(usuario);
            }
        } catch (Exception e) {
            turnos = new ArrayList<Turno>();
            logger.error("Error al intentar obtener turnos por usuario: {}", e.toString());
            logger.debug("Error al intentar obtener turnos por usuario: {}", e.toString(), e);
        }
        return turnos;
    }

    @Override
    public List<Turno> consultarTurnos(Date fecha) {
        List<Turno> turnos = new ArrayList<Turno>();
        try {
            if(fecha !=null){
                turnos = turnoRepository.findByFecha(fecha);
            }
        } catch (Exception e) {
            turnos = new ArrayList<Turno>();
            logger.error("Error al intentar consultar turnos por fecha: {}",e.toString());
            logger.debug("Error al intentar consultar turnos por fecha: {}",e.toString(),e);
        }
        return turnos;
    }

}
