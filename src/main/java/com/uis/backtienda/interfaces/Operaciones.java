package com.uis.backtienda.interfaces;

import java.util.List;

public interface Operaciones<T> {

    public List<T> consultar();

    public boolean eliminar(Integer codigo);

    public boolean agregar(T miObjeto);

    public T buscar(Integer llavePrimaria);

    public boolean actualizar(T miObjeto);

    public int cantidadRegistros();

}
