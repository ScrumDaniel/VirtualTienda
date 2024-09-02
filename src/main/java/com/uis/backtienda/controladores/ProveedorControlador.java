package com.uis.backtienda.controladores;

import com.uis.backtienda.entidades.Proveedor;
import com.uis.backtienda.servicios.ProveedorServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provee")
@CrossOrigin(origins = "*")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveeServicio;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/obtener", method = RequestMethod.GET)
    public List<Proveedor> obtenerTodosProveedores() {
        return proveeServicio.consultar();
    }
}
