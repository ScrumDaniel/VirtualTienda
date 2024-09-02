package com.uis.backtienda.repositorios;

import com.uis.backtienda.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
   @Query("SELECT pro FROM Producto pro")
    public List<Producto> obtenerTodos(); 
}
