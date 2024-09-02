package com.uis.backtienda.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.uis.backtienda.entidades.Categoria;
import org.springframework.http.ResponseEntity;
import com.uis.backtienda.servicios.CategoriaServicio;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/catego")
@CrossOrigin(origins = "*")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio cateServicio;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public List<Categoria> obtenerTodasCategorias() {
        return cateServicio.consultar();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/activas", method = RequestMethod.GET)
    public List<Categoria> obtenerActivas() {
        Short estadoActivas = 1;
        return cateServicio.consultarActivas(estadoActivas);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria objCatego) {
        Short estadoInicial = 1;
        objCatego.setEstadoCategoria(estadoInicial);
        if (cateServicio.agregar(objCatego)) {
            return ResponseEntity.ok(objCatego);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto eliminado")
    @RequestMapping(value = "/borrar/{codigo}", method = RequestMethod.DELETE)
    public void borrarCategoria(@PathVariable Integer codigo) {
        cateServicio.eliminar(codigo);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/uno/{codigo}", method = RequestMethod.GET)
    public Categoria obtenerUno(@PathVariable int codigo) {
        return cateServicio.buscar(codigo);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Objeto actualizado correctamente")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public boolean actualCategoria(@RequestBody Categoria objCategoria) {
        return cateServicio.actualizar(objCategoria);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/cantidad", method = RequestMethod.GET)
    public Integer obtenerCantidad() {
        return cateServicio.cantidadRegistros();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/estado/{codigo}", method = RequestMethod.GET)
    public Integer cambiarEstado(@PathVariable Integer codigo) {
        Short estadoFinal = 1;
        Categoria objeto = cateServicio.buscar(codigo);

        if (objeto.getEstadoCategoria() == 1) {
            estadoFinal = 2;
        }
        return cateServicio.cambiarEstado(estadoFinal, codigo);

    }

}
