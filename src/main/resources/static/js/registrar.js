// Call the dataTables jQuery plugin
$(document).ready(function() {
});


async function registrarUsuario(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value
    datos.apellido = document.getElementById('txtApellido').value
    datos.email = document.getElementById('txtEmail').value
     datos.telefono = document.getElementById('txtTelefono').value
    datos.password = document.getElementById('txtContraseña').value

    let repetirContraseña = document.getElementById('txtRepetirContraseña').value


if (datos.nombre == ""|| datos.apellido == "" ||datos.email == "" ||datos.telefono == "" ||datos.password == "") {
    return

    }
    if (repetirContraseña != datos.password) {
    alert(' Las contraseñas no coinciden')
    return

    }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(datos)

    });
    alert('Se registro correctamente')
            location.reload()
}