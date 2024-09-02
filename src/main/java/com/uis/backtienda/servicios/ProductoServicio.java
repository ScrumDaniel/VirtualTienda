package com.uis.backtienda.servicios;

import com.uis.backtienda.entidades.Producto;
import com.uis.backtienda.interfaces.Operaciones;
import com.uis.backtienda.repositorios.ProductoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("ProductService")
public class ProductoServicio implements Operaciones<Producto> {

    @Autowired
    private ProductoRepositorio produRepo;

    @Override
    public List<Producto> consultar() {
        return produRepo.obtenerTodos();
    }

    @Override
    public boolean agregar(Producto miObjeto) {
        Producto temporal = produRepo.save(miObjeto);
        return temporal != null;
    }

    @Override
    public boolean eliminar(Integer codigo) {
        produRepo.deleteById(codigo);
        return !produRepo.existsById(codigo);
    }

    @Override
    public Producto buscar(Integer llavePrimaria) {
        return produRepo.findById(llavePrimaria).get();
    }

    @Override
    public boolean actualizar(Producto miObjeto) {
        Optional<Producto> objetoVerificado = produRepo.findById(miObjeto.getCodProducto());
        if (!objetoVerificado.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Objeto no aceptado");
        } else {
            produRepo.save(miObjeto);
            return true;
        }
    }

    @Override
    public int cantidadRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
