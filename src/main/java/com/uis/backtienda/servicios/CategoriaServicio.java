package com.uis.backtienda.servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.uis.backtienda.entidades.Categoria;
import com.uis.backtienda.interfaces.Operaciones;
import com.uis.backtienda.repositorios.CategoriaRepositorio;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

@Service("CategoService")
public class CategoriaServicio implements Operaciones<Categoria> {

    @Autowired
    private CategoriaRepositorio cateRepo;

    @Override
    public List<Categoria> consultar() {
        return cateRepo.obtenerTodas();
    }

    @Override
    public boolean agregar(Categoria miObjeto) {
        Categoria temporal = cateRepo.save(miObjeto);
        return temporal != null;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        cateRepo.deleteById(codigo);
        return !cateRepo.existsById(codigo);
    }

    @Override
    public Categoria buscar(Integer llavePrimaria) {
        return cateRepo.findById(llavePrimaria).get();
    }

    @Override
    public boolean actualizar(Categoria miObjeto) {
        Optional<Categoria> objetoVerificado = cateRepo.findById(miObjeto.getCodCategoria());
        if (!objetoVerificado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objeto no aceptado");
        } else {
            cateRepo.save(miObjeto);
            return true;
        }
    }

    @Override
    public int cantidadRegistros() {
        return cateRepo.cantidadTotal();
    }

    // No definidos en la interfaz
    // *************************************************************************
    public List<Categoria> consultarActivas(Short estado) {
        return cateRepo.obtenerActivas(estado);
    }

    public Integer cambiarEstado(Short nuevoEstado, Integer codigo) {
        return cateRepo.cambiarEstado(nuevoEstado, codigo);
    }

}
