package com.mx.gapsi.proveedores.repository;

import com.mx.gapsi.proveedores.entity.proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProveedoresRepository extends JpaRepository<proveedores, Long> {


    proveedores findByNombre(String nombre);

    @Transactional
    void deleteByNombre(String nombre);
}
