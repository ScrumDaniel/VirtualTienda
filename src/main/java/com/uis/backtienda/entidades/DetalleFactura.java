package com.uis.backtienda.entidades;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallefacturas")
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_detallefactura")
    private Integer codDetallefactura;

    @Column(name = "cantidad_detallefactura")
    private int cantidadDetallefactura;

    @Column(name = "subotal_detallefactura")
    private BigDecimal subotalDetallefactura;

    @Column(name = "subtotaliva_detallefactura")
    private BigDecimal subtotalivaDetallefactura;

    @JoinColumn(name = "cod_factura", referencedColumnName = "cod_factura")
    @ManyToOne(optional = false)
    private Factura codFactura;

    @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto")
    @ManyToOne(optional = false)
    private Producto codProducto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer codDetallefactura) {
        this.codDetallefactura = codDetallefactura;
    }

    public DetalleFactura(Integer codDetallefactura, int cantidadDetallefactura, BigDecimal subotalDetallefactura, BigDecimal subtotalivaDetallefactura) {
        this.codDetallefactura = codDetallefactura;
        this.cantidadDetallefactura = cantidadDetallefactura;
        this.subotalDetallefactura = subotalDetallefactura;
        this.subtotalivaDetallefactura = subtotalivaDetallefactura;
    }

    public Integer getCodDetallefactura() {
        return codDetallefactura;
    }

    public void setCodDetallefactura(Integer codDetallefactura) {
        this.codDetallefactura = codDetallefactura;
    }

    public int getCantidadDetallefactura() {
        return cantidadDetallefactura;
    }

    public void setCantidadDetallefactura(int cantidadDetallefactura) {
        this.cantidadDetallefactura = cantidadDetallefactura;
    }

    public BigDecimal getSubotalDetallefactura() {
        return subotalDetallefactura;
    }

    public void setSubotalDetallefactura(BigDecimal subotalDetallefactura) {
        this.subotalDetallefactura = subotalDetallefactura;
    }

    public BigDecimal getSubtotalivaDetallefactura() {
        return subtotalivaDetallefactura;
    }

    public void setSubtotalivaDetallefactura(BigDecimal subtotalivaDetallefactura) {
        this.subtotalivaDetallefactura = subtotalivaDetallefactura;
    }

    public Factura getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Factura codFactura) {
        this.codFactura = codFactura;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetallefactura != null ? codDetallefactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        return !((this.codDetallefactura == null && other.codDetallefactura != null) || (this.codDetallefactura != null && !this.codDetallefactura.equals(other.codDetallefactura)));
    }

    @Override
    public String toString() {
        return "com.uis.backtienda.entidades.Detallefacturas[ codDetallefactura=" + codDetallefactura + " ]";
    }

}
