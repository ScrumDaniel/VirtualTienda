/*==============================================================*/
/* Table: categorias                                            */
/*==============================================================*/
create table categorias
(
   cod_categoria     int not null auto_increment,
   nombre_categoria  varchar(150) unique not null,
   estado_categoria  smallint UNSIGNED not null default 1,
   CONSTRAINT CHK_ESTADO CHECK (estado_categoria>0 AND estado_categoria<3),
   primary key (cod_categoria)
);

/*==============================================================*/
/* Table: clientes                                              */
/*==============================================================*/
create table clientes
(
   cod_cliente          int not null auto_increment,
   nombre_cliente       varchar(200) not null,
   documento_cliente    varchar(50) unique not null,
   celular_cliente      varchar(50) not null,
   primary key (cod_cliente)
);

/*==============================================================*/
/* Table: detallefacturas                                       */
/*==============================================================*/
create table detallefacturas
(
   cod_detallefactura   int not null auto_increment,
   cod_factura          int not null,
   cod_producto         int not null,
   cantidad_detallefactura int not null,
   subotal_detallefactura numeric(10,2) not null,
   subtotaliva_detallefactura numeric(10,2) not null,
   primary key (cod_detallefactura)
);

/*==============================================================*/
/* Table: facturas                                              */
/*==============================================================*/
create table facturas
(
   cod_factura          int not null auto_increment,
   cod_cliente          int not null,
   fecha_factura        date not null,
   valor_factura        numeric(10,2) not null,
   primary key (cod_factura)
);

/*==============================================================*/
/* Table: inventarios                                           */
/*==============================================================*/
create table inventarios
(
   cod_producto         int not null,
   cantidad_producto    int not null,
   minimo_producto      int not null,
   maximo_producto      int not null,
   primary key (cod_producto)
);

/*==============================================================*/
/* Table: productos                                             */
/*==============================================================*/
create table productos
(
   cod_producto         int not null auto_increment,
   cod_categoria        int not null,
   cod_proveedor        int not null,
   nombre_producto      varchar(200) not null,
   precio_producto      numeric(10,2) not null,
   iva_producto         int not null,
   imagen_nombre_producto varchar(200),
   imagen_base64_producto LONGTEXT,
   primary key (cod_producto)
);

/*==============================================================*/
/* Table: proveedores                                           */
/*==============================================================*/
create table proveedores
(
   cod_proveedor        int not null auto_increment,
   nombre_proveedor     varchar(150) unique not null,
   primary key (cod_proveedor)
);

alter table detallefacturas add constraint fk_detallef_reference_facturas foreign key (cod_factura)
      references facturas (cod_factura) on delete restrict on update cascade;

alter table detallefacturas add constraint fk_detallef_reference_producto foreign key (cod_producto)
      references productos (cod_producto) on delete restrict on update cascade;

alter table facturas add constraint fk_facturas_reference_clientes foreign key (cod_cliente)
      references clientes (cod_cliente) on delete restrict on update cascade;

alter table inventarios add constraint fk_inventar_reference_producto foreign key (cod_producto)
      references productos (cod_producto) on delete restrict on update cascade;

alter table productos add constraint fk_producto_reference_categori foreign key (cod_categoria)
      references categorias (cod_categoria) on delete restrict on update cascade;

alter table productos add constraint fk_producto_reference_proveedo foreign key (cod_proveedor)
      references proveedores (cod_proveedor) on delete restrict on update cascade;

