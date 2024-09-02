package com.uis.backtienda.entidades;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_producto")
    private Integer codProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_producto")
    private BigDecimal precioProducto;

    @Column(name = "iva_producto")
    private int ivaProducto;

    @Column(name = "imagen_nombre_producto")
    private String imagenNombreProducto;

    @Lob
    @Column(name = "imagen_base64_producto")
    private String imagenBase64Producto;

    @JoinColumn(name = "cod_categoria", referencedColumnName = "cod_categoria")
    @ManyToOne(optional = false)
    private Categoria codCategoria;

    @JoinColumn(name = "cod_proveedor", referencedColumnName = "cod_proveedor")
    @ManyToOne(optional = false)
    private Proveedor codProveedor;

    public Producto() {
    }

    public Producto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Producto(Integer codProducto, String nombreProducto, BigDecimal precioProducto, int ivaProducto) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.ivaProducto = ivaProducto;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(int ivaProducto) {
        this.ivaProducto = ivaProducto;
    }

    public String getImagenNombreProducto() {
        return imagenNombreProducto;
    }

    public void setImagenNombreProducto(String imagenNombreProducto) {
        this.imagenNombreProducto = imagenNombreProducto;
    }

    public String getImagenBase64Producto() {
        return imagenBase64Producto;
    }

    public void setImagenBase64Producto(String imagenBase64Producto) {
        this.imagenBase64Producto = imagenBase64Producto;
    }

    public Categoria getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Categoria codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Proveedor getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(Proveedor codProveedor) {
        this.codProveedor = codProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProducto != null ? codProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        return !((this.codProducto == null && other.codProducto != null) || (this.codProducto != null && !this.codProducto.equals(other.codProducto)));
    }

    @Override
    public String toString() {
        return "com.uis.backtienda.entidades.Productos[ codProducto=" + codProducto + " ]";
    }

}
