package com.uis.backtienda.controladores;

import com.uis.backtienda.entidades.Producto;
import com.uis.backtienda.servicios.ProductoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoServicio produServicio;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public List<Producto> obtenerTodosProductos() {
        return produServicio.consultar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto objProduct) {
        if (produServicio.agregar(objProduct)) {
            return ResponseEntity.ok(objProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Producto eliminado correctamente")
    @RequestMapping(value = "/eliminar/(codigo)", method = RequestMethod.DELETE)
    public void eliminarYa(@PathVariable Integer codigo) {
        produServicio.eliminar(codigo);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/uno/{codigo}", method = RequestMethod.GET)
    public Producto obtenerUno(@PathVariable int codigo) {
        return produServicio.buscar(codigo);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Producto actualizado correctamente")
    @RequestMapping(value = "/editar", method = RequestMethod.PUT)
    public boolean actualProducto(@RequestBody Producto objProduct) {
        return produServicio.actualizar(objProduct);
    }

}
