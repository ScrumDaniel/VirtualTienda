function logicaNegocio(url, param) {
  switch (url) {
    // Categorias
    // ***************************************************************
    case "src/componentes/catelistar.html":
      obtenerCateListar();
      break;
    case "src/componentes/cateadmin.html":
      obtenerCateListarAdmin();
      break;
    case "src/componentes/cateborrar.html":
      eliminarCate(param);
      break;
    case "src/componentes/cateactualizar.html":
      obtenerCateActual(param);
      break;

    case "src/componentes/produccrear.html":
      cateCombitoPro();
      proveeCombitoPro();
      break;

    case "src/componentes/productolistar.html":
      capturarProducto();
    // Inicio
    // ***************************************************************
    case "src/componentes/inicio.html":
      break;

    default:
      console.log("Componente no requiere Javascript personalizado");
  }
}
