function deleteBy(id) {
    /* Con fetch invocamos a la API de estudiantes con el método DELETE pasándole el id en la URL.*/
    const url = "/estudiantes/" + id; //url = "/students/" + id;
    const settings = {
        method: "DELETE",
    };
    fetch(url, settings).then((response) => response.json());
    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove(); /* Borrar la fila del estudiante eliminado.*/
}