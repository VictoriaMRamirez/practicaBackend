window.addEventListener("load", function () {
  (function () {
    /* Con fetch invocamos a la API de estudiantes con el método GET. Esto nos devolverá un JSON con una colección de estudiantes.*/
    const url = "/estudiantes"; //url = "/students/list"
    const settings = {
      method: "GET",
    };
    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        for (estudiante of data) { /* Recorremos la colección de estudiantes del JSON.*/ // for (student of data)

          /* Por cada estudiante armamos una fila de la tabla. Cada fila tendrá un
          id que luego nos permitirá borrar la fila si eliminamos el estudiante. */
          var table = document.getElementById("tablaEstudiante"); //document.getElementById
          var studentRow = table.insertRow();
          let tr_id = "tr_" + estudiante.id;
          studentRow.id = tr_id;

          /* Por cada estudiante creamos un botón delete que agregaremos en cada fila para poder eliminar la misma. Dicho
          botón invocará a la función de JS deleteByKey que se encargará de llamar a la API para eliminar al estudiante.*/
          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            estudiante.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            estudiante.id +
            ')" class="btn btn-danger btn_delete">' +
            "&times" +
            "</button>";

          /* Por cada estudiante creamos un botón que muestra el id y que, al hacerle click, invocará a la función de JS
          findBy que se encargará de buscar al estudiante que queremos modificar y mostrar los datos del mismo en un formulario.*/
          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            estudiante.id +
            '"' +
            ' type="button" onclick="findBy(' +
            estudiante.id +
            ')" class="btn btn-info btn_id">' +
            estudiante.id +
            "</button>";

          /* Armamos cada columna de la fila. Como primer columna pondremos el botón
          modificar, luego los datos del estudiante y como última columna el botón eliminar. */
          studentRow.innerHTML =
            "<td>" +
            updateButton +
            "</td>" +
            '<td class="td_first_name">' +
            estudiante.nombre.toUpperCase() +
            "</td>" +
            '<td class="td_last_name">' +
            estudiante.apellido.toUpperCase() +
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      });
  })
  (function () {
    let pathname = window.location.pathname;
    if (pathname == "/listaEstudiantes.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});
