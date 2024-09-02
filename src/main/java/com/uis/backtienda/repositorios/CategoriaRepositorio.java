package com.uis.backtienda.repositorios;

import com.uis.backtienda.entidades.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

    // Cantidad de registros de una tabla
    @Query("SELECT COUNT(c.codCategoria) FROM Categoria c")
    public Integer cantidadTotal();

    
    // Todos los registros de una tabla ordenados por un código
    @Query("SELECT c FROM Categoria c ORDER BY c.codCategoria")
    public List<Categoria> obtenerTodas();

    
    // Registros con estado como parámetro 
    @Query("SELECT c FROM Categoria c WHERE c.estadoCategoria= :estado ORDER BY c.codCategoria")
    public List<Categoria> obtenerActivas(@Param("estado") Short valorEstado);

    
    // Update a una tabla estableciendo un campo personalizado
    @Modifying
    @Transactional
    @Query("UPDATE Categoria c SET c.estadoCategoria = :nuevoEstado WHERE c.codCategoria = :codigo")
    public Integer cambiarEstado(@Param("nuevoEstado") Short valorNuevoEstado, @Param("codigo") Integer valorCodigo);

}
