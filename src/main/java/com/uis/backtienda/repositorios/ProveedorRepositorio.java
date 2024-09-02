package com.uis.backtienda.repositorios;

import com.uis.backtienda.entidades.Proveedor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {

    @Query("SELECT prov FROM Proveedor prov")
    public List<Proveedor> obtenerTodos();
}
