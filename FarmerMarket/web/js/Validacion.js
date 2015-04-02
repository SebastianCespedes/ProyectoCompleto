
$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var numeroDocumento = $('#ruDocumento').val();
        if (numeroDocumento === "" || numeroDocumento === null) {
            document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ingresar su número de documento, no debe estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;

        } else if (isNaN(numeroDocumento)) {
            document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ingresar sólo números, no se admiten letras');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (numeroDocumento.length < 10) {
            document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ser de 10 digitos el campo');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('ruDocumento').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDocumento').removeAttribute('data-original-title', 'Este campo no debe ir vacio');
            document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');

        }
        var rol = $('#ruRol').val();
        if (rol.selectedIndex === 0) {
            document.getElementById('ruRol').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruRol').setAttribute('data-original-title', 'Debe selecciona un rol');
            $(document).ready(function() {
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpRol').setAttribute('class', 'form-group has-error');
            document.getElementById('botonRegistro').setAttribute('disabled', 'true');
        } else {
            document.getElementById('ruRol').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruRol').removeAttribute('data-original-title', 'Debe selecciona un rol');
            document.getElementById('inpRol').setAttribute('class', 'form-group has-success');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {

        if ($('#ruRol').val().trim() === '') {
            document.getElementById('ruRol').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruRol').setAttribute('data-original-title', 'Debe selecciona un rol');
            $(document).ready(function() {
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpRol').setAttribute('class', 'form-group has-error');
            return false;
        } else {
            document.getElementById('ruRol').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruRol').removeAttribute('data-original-title', 'Debe selecciona un rol');
            document.getElementById('inpRol').setAttribute('class', 'form-group has-success');

        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var letras = /^[a-zA-Z-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜñÑ ]+$/;
        var campoNombres = $('#ruNombres').val();
        if (campoNombres === null || campoNombres === "") {
            document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruNombres').setAttribute('data-original-title', 'El campo no puede estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (!letras.test(campoNombres)) {
            document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruNombres').setAttribute('data-original-title', 'El nombre no puede ser un número');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (campoNombres.length < 3) {
            document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruNombres').setAttribute('data-original-title', 'Tienen que ser más de 3 carácteres');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruNombres').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruNombres').removeAttribute('data-original-title', 'El nombre no puede ser un número');
            document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {
        var letras = /^[a-zA-Z-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜñÑ ]+$/;
        var campoApellidos = $('#ruApellidos').val();
        if (campoApellidos === null || campoApellidos === "") {
            document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruApellidos').setAttribute('data-original-title', 'El campo no puede estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (!letras.test(campoApellidos)) {
            document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruApellidos').setAttribute('data-original-title', 'El apellido no puede ser un número');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (campoApellidos.length < 3) {
            document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruApellidos').setAttribute('data-original-title', 'Tienen que ser más de 3 carácteres');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruApellidos').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruApellidos').removeAttribute('data-original-title', 'El apellido no puede ser un número');
            document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');

        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {
        var correo = $('#ruCorreo').val();
        if (correo === null || correo === "") {
            document.getElementById('ruCorreo').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo').setAttribute('data-original-title', 'El campo no puede estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(correo))) {
            document.getElementById('ruCorreo').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo').setAttribute('data-original-title', 'El correo no está en un formato correcto, correo@ejemplo.com');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            document.getElementById('ruCorreo2').setAttribute('disabled');
            return false;
        } else {
            document.getElementById('ruCorreo').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo2').removeAttribute('disabled');
            document.getElementById('ruCorreo').removeAttribute('data-original-title', 'El correo no está en un formato correcto, correo@ejemplo.com');
            document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var correo1 = $('#ruCorreo2').val();
        var correo2 = $('#ruCorreo').val();
        if (correo1 === null || correo1 === "") {
            document.getElementById('ruCorreo2').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo2').setAttribute('data-original-title', 'El campo no puede estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (correo1 !== correo2) {
            document.getElementById('ruCorreo2').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo2').setAttribute('data-original-title', 'Los correos no coinciden, verifique');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruCorreo2').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCorreo2').removeAttribute('data-original-title');
            document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {
        var direccion = $('#ruDireccion').val();
        if (direccion === null || direccion === "") {
            document.getElementById('ruDireccion').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDireccion').setAttribute('data-original-title', 'El campo no puede estar vacio');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'top'
                });
            });
            document.getElementById('inpDireccion').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackDireccion').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruDireccion').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDireccion').removeAttribute('data-original-title');
            document.getElementById('inpDireccion').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackDireccion').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }

    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var departamento = $('#ruDepartamento').val();
        if (departamento === null || departamento === "") {
            document.getElementById('ruDepartamento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDepartamento').setAttribute('data-original-title', 'Debe seleccionar un departamento');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'top'
                });
            });
            document.getElementById('inpDepartamento').setAttribute('class', 'form-group has-feedback has-error');
            return false;
        } else {
            document.getElementById('ruDepartamento').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruDepartamento').removeAttribute('data-original-title');
            document.getElementById('inpDepartamento').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }

    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {
        var ciudad = $('#ruCiudad').val();
        if (ciudad === null || ciudad === "") {
            document.getElementById('ruCiudad').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCiudad').setAttribute('data-original-title', 'Debe seleccionar un departamento antes');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'top'
                });
            });
            document.getElementById('inpCiudad').setAttribute('class', 'form-group has-feedback has-error');
            return false;
        } else {
            document.getElementById('ruCiudad').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruCiudad').removeAttribute('data-original-title');
            document.getElementById('inpCiudad').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {
        var clave = $('#ruClave').val();
        if (clave === null || clave === "") {
            document.getElementById('ruClave').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruClave').setAttribute('data-original-title', 'Debe ingresar una contraseña');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'top'
                });
            });
            document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else if (clave.length < 6) {
            document.getElementById('ruClave').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruClave').setAttribute('data-original-title', 'Tiene que ser de más de 6 caráctres');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruClave').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruClave').removeAttribute('data-original-title');
            document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }


    });
});


$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var fecha = $('#ruFecha').val();
        if (fecha === null || fecha === "") {
            document.getElementById('ruFecha').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruFecha').setAttribute('data-original-title', 'Debe ingresar su fecha de nacimiento');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'top'
                });
            });
            document.getElementById('inpFecha').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('iconFeedbackFecha').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('ruFecha').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruFecha').removeAttribute('data-original-title');
            document.getElementById('inpFecha').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('iconFeedbackFecha').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonRegistro').removeAttribute('disabled');
        }



    });
});

$(document).ready(function() {

    $("#botonRegistro").click(function() {

        var terminos = document.getElementsByName("ruTerminos");
        var seleccion = false;
        for (var i = 0; i < terminos.length; i++) {
            if (terminos[i].checked) {
                seleccion = true;
                break;
            }
        }
        if (seleccion !== true) {
            document.getElementById('ruTerminos').setAttribute('data-toggle', 'tooltip');
            document.getElementById('ruTerminos').setAttribute('data-original-title', 'Debe aceptar nuestros terminos y condiciones');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'left'
                });
            });
            document.getElementById('inpTerminos').setAttribute('class', 'form-group has-feedback has-error');
            return false;
        }
        else {
            document.getElementById('ruTerminos').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('ruTerminos').removeAttribute('data-original-title');
            document.getElementById('ruTerminos').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('botonRegistro').removeAttribute('disabled');

        }


    });
});


$(document).ready(function() {

    $("#botonIniciar").click(function() {
        var documento = $('#isDocumento').val();
        if (documento === "" || documento === null) {
            document.getElementById('isDocumento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('isDocumento').setAttribute('data-original-title', 'Debe ingresar su documento');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'bottom'
                });
            });
            document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;

        } else if (isNaN(documento)) {
            document.getElementById('isDocumento').setAttribute('data-toggle', 'tooltip');
            document.getElementById('isDocumento').setAttribute('data-original-title', 'Debe ingresar sólo números, no se admiten letras');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'bottom'
                });
            });
            document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;

        } else {
            document.getElementById('isDocumento').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('isDocumento').removeAttribute('data-original-title');
            document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonIniciar').removeAttribute('disabled');
        }

    });
});

$(document).ready(function() {

    $("#botonIniciar").click(function() {
        var clave = $('#isClave').val();
        if (clave === null || clave === "") {
            document.getElementById('isClave').setAttribute('data-toggle', 'tooltip');
            document.getElementById('isClave').setAttribute('data-original-title', 'Debe ingresar su contraseña');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'bottom'
                });
            });
            document.getElementById('iuClave').setAttribute('class', 'form-group has-feedback has-error');
            document.getElementById('inFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
            return false;
        } else {
            document.getElementById('isClave').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('isClave').removeAttribute('data-original-title');
            document.getElementById('iuClave').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('inFeedbackClave').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('botonIniciar').removeAttribute('disabled');
        }

    });
});

$(document).ready(function() {

    $("#recuperar").click(function() {
        var clave = $('#rcCorreo').val();
        if (clave === null || clave === "") {
            document.getElementById('rcCorreo').setAttribute('data-toggle', 'tooltip');
            document.getElementById('rcCorreo').setAttribute('data-original-title', 'Debe ingresar su correo electronico');
            $(document).ready(function() {
                // Initialize tooltip
                $('[data-toggle="tooltip"]').tooltip({
                    placement: 'bottom'
                });
            });
            document.getElementById('eCorreo').setAttribute('class', 'has-error');
            return false;
        } else {
            document.getElementById('rcCorreo').removeAttribute('data-toggle', 'tooltip');
            document.getElementById('rcCorreo').removeAttribute('data-original-title');
            document.getElementById('eCorreo').setAttribute('class', 'form-group has-feedback has-success');
            document.getElementById('inFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
            document.getElementById('rcEnviar').removeAttribute('disabled');
        }
    });
});















function validarRol(rol) {
    if (rol.selectedIndex === 0) {
        document.getElementById('ruRol').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruRol').setAttribute('data-original-title', 'Debe selecciona un rol');
        $(document).ready(function() {
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpRol').setAttribute('class', 'form-group has-error');
        return false;
    } else {
        document.getElementById('ruRol').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruRol').removeAttribute('data-original-title', 'Debe selecciona un rol');
        document.getElementById('inpRol').setAttribute('class', 'form-group has-success');

    }
}
;

function validarDocumento(numeroDocumento) {

    if (numeroDocumento.value === "" || numeroDocumento.value === null) {
        document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ingresar su número de documento, no debe estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;

    } else if (isNaN(numeroDocumento.value)) {
        document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ingresar sólo números, no se admiten letras');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;

    } else if (numeroDocumento.value.length < 10) {
        document.getElementById('ruDocumento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDocumento').setAttribute('data-original-title', 'Debe ser de 10 digitos el campo');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('ruDocumento').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDocumento').removeAttribute('data-original-title', 'Este campo no debe ir vacio');
        document.getElementById('inpDocumento').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');

    }
}

function validarNombres(campoNombres) {
    var letras = /^[a-zA-Z-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜñÑ ]+$/;
    if (campoNombres.value === null || campoNombres.value === "") {
        document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruNombres').setAttribute('data-original-title', 'El campo no puede estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (!(/^[a-zA-Z-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜñÑ ]+$/.test(campoNombres.value))) {
        document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruNombres').setAttribute('data-original-title', 'El nombre no puede ser un número');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (campoNombres.value.length < 3) {
        document.getElementById('ruNombres').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruNombres').setAttribute('data-original-title', 'Tienen que ser más de 3 carácteres');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;


    } else {
        document.getElementById('ruNombres').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruNombres').removeAttribute('data-original-title', 'El nombre no puede ser un número');
        document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('inpNombres').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackNombres').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}
;


function validarApellidos(campoApellidos) {

    if (campoApellidos.value === null || campoApellidos.value === "") {
        document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruApellidos').setAttribute('data-original-title', 'El campo no puede estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;


    } else if (!(/^[a-zA-Z-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜñÑ ]+$/.test(campoApellidos.value))) {
        document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruApellidos').setAttribute('data-original-title', 'El apellido no puede ser un número');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (campoApellidos.value.length < 3) {
        document.getElementById('ruApellidos').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruApellidos').setAttribute('data-original-title', 'Tienen que ser más de 3 carácteres');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('ruApellidos').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruApellidos').removeAttribute('data-original-title', 'El apellido no puede ser un número');
        document.getElementById('inpApellidos').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackApellidos').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');

    }
}


function validarCorreo(correo) {
    if (correo.value === null || correo.value === "") {
        document.getElementById('ruCorreo').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo').setAttribute('data-original-title', 'El campo no puede estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(correo.value))) {
        document.getElementById('ruCorreo').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo').setAttribute('data-original-title', 'El correo no está en un formato correcto, correo@ejemplo.com');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        document.getElementById('ruCorreo2').setAttribute('disabled');
        return false;
    } else {
        document.getElementById('ruCorreo').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo2').removeAttribute('disabled');
        document.getElementById('ruCorreo').removeAttribute('data-original-title', 'El correo no está en un formato correcto, correo@ejemplo.com');
        document.getElementById('inpCorreo').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarRepetirCorreo(correo1) {
    var correo2 = document.getElementById('ruCorreo');
    if (correo1.value === null || correo1.value === "") {
        document.getElementById('ruCorreo2').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo2').setAttribute('data-original-title', 'El campo no puede estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (correo1.value !== correo2.value) {
        document.getElementById('ruCorreo2').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo2').setAttribute('data-original-title', 'Los correos no coinciden, verifique');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('ruCorreo2').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCorreo2').removeAttribute('data-original-title');
        document.getElementById('inpCorreoRepetido').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackCorreo2').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarDireccion(direccion) {
    if (direccion.value === null || direccion.value === "") {
        document.getElementById('ruDireccion').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDireccion').setAttribute('data-original-title', 'El campo no puede estar vacio');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpDireccion').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackDireccion').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('ruDireccion').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDireccion').removeAttribute('data-original-title');
        document.getElementById('inpDireccion').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackDireccion').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarDepartamento(departamento) {
    if (departamento.value === null || departamento.value === "") {
        document.getElementById('ruDepartamento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDepartamento').setAttribute('data-original-title', 'Debe seleccionar un departamento');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpDepartamento').setAttribute('class', 'form-group has-feedback has-error');
        return false;
    } else {
        document.getElementById('ruDepartamento').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruDepartamento').removeAttribute('data-original-title');
        document.getElementById('inpDepartamento').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarCiudad(ciudad) {
    if (ciudad.value === null || ciudad.value === "") {
        document.getElementById('ruCiudad').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCiudad').setAttribute('data-original-title', 'Debe seleccionar un departamento antes');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpCiudad').setAttribute('class', 'form-group has-feedback has-error');
        return false;
    } else {
        document.getElementById('ruCiudad').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruCiudad').removeAttribute('data-original-title');
        document.getElementById('inpCiudad').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}


function validarClave(clave) {

    if (clave.value === null || clave.value === "") {
        document.getElementById('ruClave').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruClave').setAttribute('data-original-title', 'Debe ingresar una contraseña');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else if (clave.value.length < 6) {
        document.getElementById('ruClave').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruClave').setAttribute('data-original-title', 'Tiene que ser de más de 6 caráctres');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'left'
            });
        });
        document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('ruClave').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruClave').removeAttribute('data-original-title');
        document.getElementById('inpClave').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackClave').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarFecha(fecha) {
    if (fecha.value === null || fecha.value === "") {
        document.getElementById('ruFecha').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruFecha').setAttribute('data-original-title', 'Debe ingresar su fecha de nacimiento');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpFecha').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('iconFeedbackFecha').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('ruFecha').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruFecha').removeAttribute('data-original-title');
        document.getElementById('inpFecha').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('iconFeedbackFecha').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonRegistro').removeAttribute('disabled');
    }
}

function validarTerminos() {
    var rol = document.getElementsByName("ruTerminos");
    var seleccion = false;
    for (var i = 0; i < rol.length; i++) {
        if (rol[i].checked) {
            seleccion = true;
            break;
        }
    }
    if (seleccion !== true) {
        document.getElementById('ruTerminos').setAttribute('data-toggle', 'tooltip');
        document.getElementById('ruTerminos').setAttribute('data-original-title', 'Debe aceptar nuestros terminos y condiciones');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'top'
            });
        });
        document.getElementById('inpTerminos').setAttribute('class', 'form-group has-feedback has-error');
        return false;
    }
    else {
        document.getElementById('ruTerminos').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('ruTerminos').removeAttribute('data-original-title');
        document.getElementById('inpTerminos').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('botonRegistro').removeAttribute('disabled');

    }
}

function validarClaveIngreso(clave) {

    if (clave.value === null || clave.value === "") {
        document.getElementById('isClave').setAttribute('data-toggle', 'tooltip');
        document.getElementById('isClave').setAttribute('data-original-title', 'Debe ingresar su contraseña');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'bottom'
            });
        });
        document.getElementById('iuClave').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('inFeedbackClave').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;
    } else {
        document.getElementById('isClave').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('isClave').removeAttribute('data-original-title');
        document.getElementById('iuClave').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('inFeedbackClave').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonIniciar').removeAttribute('disabled');
    }
}


function validarDocumentoIngreso(documento) {

    if (documento.value === "" || documento.value === null) {
        document.getElementById('isDocumento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('isDocumento').setAttribute('data-original-title', 'Debe ingresar su documento');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'bottom'
            });
        });
        document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;

    } else if (isNaN(documento.value)) {
        document.getElementById('isDocumento').setAttribute('data-toggle', 'tooltip');
        document.getElementById('isDocumento').setAttribute('data-original-title', 'Debe ingresar sólo números, no se admiten letras');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'bottom'
            });
        });
        document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-error');
        document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-remove form-control-feedback');
        return false;

    } else {
        document.getElementById('isDocumento').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('isDocumento').removeAttribute('data-original-title');
        document.getElementById('iuDocumento').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('inFeedbackDocumento').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('botonIniciar').removeAttribute('disabled');
    }
}

function validarOlvidada(clave) {

    if (clave.value === null || clave.value === "") {
        document.getElementById('rcCorreo').setAttribute('data-toggle', 'tooltip');
        document.getElementById('rcCorreo').setAttribute('data-original-title', 'Debe ingresar su correo electronico');
        $(document).ready(function() {
            // Initialize tooltip
            $('[data-toggle="tooltip"]').tooltip({
                placement: 'bottom'
            });
        });
        document.getElementById('eCorreo').setAttribute('class', 'has-error');


        return false;
    } else {
        document.getElementById('rcCorreo').removeAttribute('data-toggle', 'tooltip');
        document.getElementById('rcCorreo').removeAttribute('data-original-title');
        document.getElementById('eCorreo').setAttribute('class', 'form-group has-feedback has-success');
        document.getElementById('inFeedbackCorreo').setAttribute('class', 'glyphicon glyphicon-ok form-control-feedback');
        document.getElementById('rcEnviar').removeAttribute('disabled');
    }
}

function enviarFormulario(nombreForm) {
    document.getElementById(nombreForm).submit();
//    document.getElementsByClassName(nombreForm).submit();
}