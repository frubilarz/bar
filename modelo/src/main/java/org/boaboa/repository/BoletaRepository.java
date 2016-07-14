package org.boaboa.repository;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.boaboa.modelo.Boleta;
import org.boaboa.modelo.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource(name = "boletaRepository")
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {

    public List<Boleta> findByFecha(Date fecha);

    public List<Boleta> findByFormaPago(FormaPago formaPago);
}
