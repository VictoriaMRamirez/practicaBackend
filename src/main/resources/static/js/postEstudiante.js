window.addEventListener("load", function () {
  /* Al cargar la página buscamos y obtenemos el formulario donde estarán los datos que el usuario cargará del nuevo estudiante.*/
  const formulario = document.querySelector("#agregar_nuevo_estudiante"); // document.querySelector("#add_new_student");

  formulario.addEventListener("submit", function (event) {
    /* Ante un submit del formulario se ejecutará la siguiente función.*/
    const formData = {
        /* Creamos un JSON que tendrá los datos del nuevo estudiante.*/
        nombre: document.querySelector("#nombre").value,
        apellido: document.querySelector("#apellido").value,
    };

    /* Invocamos utilizando la funcion fetch la API estudiantes con el método POST que guardará al estudiante que enviaremos en formato JSON.*/
    const url = "/estudiantes"; // url = "/students"
    const settings = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        /* Si no hay ningún error se muestra un msj diciendo que el estudiante se agregó bien.*/
        let successAlert =
          '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          "<strong>Estudiante agregado</strong></div>";
        document.querySelector("#response").innerHTML = successAlert;
        document.querySelector("#response").style.display = "block";
        /* Se dejan todos los campos vacíos por si se quiere ingresar otro estudiante.*/
        resetUploadForm();
      })
      .catch((error) => {
        /* Si hay algún error se muestra un msj diciendo que el estudiante no se pudo guardar y se intente nuevamente.*/
        let errorAlert =
          '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          "<strong>Error: intente nuevamente</strong></div>";
        document.querySelector("#response").innerHTML = errorAlert;
        document.querySelector("#response").style.display = "block";
        /* Se dejan todos los campos vacíos por si se quiere ingresar otro estudiante.*/
        resetUploadForm();
      });
  });

  function resetUploadForm() {
    document.querySelector("#nombre").value = "";
    document.querySelector("#apellido").value = "";
  }

  (function () {
    let pathname = window.location.pathname;
    if (pathname === "/") {
      document.querySelector(".nav .nav-item a:first").addClass("active");
    } else if (pathname == "/listaEstudiantes.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })();
});