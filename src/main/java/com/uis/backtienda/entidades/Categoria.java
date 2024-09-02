package com.uis.backtienda.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria")
    private Integer codCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "estado_categoria")
    private Short estadoCategoria;

    public Categoria() {
    }

    public Categoria(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Categoria(Integer codCategoria, String nombreCategoria) {
        this.codCategoria = codCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Integer codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Short getEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(Short estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCategoria != null ? codCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        return !((this.codCategoria == null && other.codCategoria != null) || (this.codCategoria != null && !this.codCategoria.equals(other.codCategoria)));
    }

    @Override
    public String toString() {
        return "com.uis.backtienda.entidades.Categorias[ codCategoria=" + codCategoria + " ]";
    }

}
