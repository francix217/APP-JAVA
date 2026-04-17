$(document).ready(function () {

    let modo = "ADMIN";
    let submodo = "LOGIN";

    // CAMBIO ADMIN
    $("#adminTab").click(function () {
        modo = "ADMIN";
        $("#userOptions").hide();
        $("#genero").hide();

        $(".tab").removeClass("active");
        $(this).addClass("active");
    });

    // CAMBIO USER
    $("#userTab").click(function () {
        modo = "USER";
        $("#userOptions").show();

        $(".tab").removeClass("active");
        $(this).addClass("active");
    });

    // LOGIN USER
    $("#loginUserTab").click(function () {
        submodo = "LOGIN";
        $("#genero").hide();

        $(".subtab").removeClass("active");
        $(this).addClass("active");
    });

    // REGISTRO USER
    $("#registerUserTab").click(function () {
        submodo = "REGISTER";
        $("#genero").show();

        $(".subtab").removeClass("active");
        $(this).addClass("active");
    });

    // MOSTRAR PASSWORD
    $("#togglePass").click(function () {
        let input = $("#password");
        if (input.attr("type") === "password") {
            input.attr("type", "text");
        } else {
            input.attr("type", "password");
        }
    });

    // LOGIN / REGISTRO
    $("#loginForm").submit(function (e) {
        e.preventDefault();

        let user = $("#usuario").val();
        let pass = $("#password").val();
        let genero = $("#genero").val();

        $("#error").text("");
        $("#success").text("");

        if (modo === "ADMIN") {
            if (user === "root" && pass === "1234") {
                $("#success").text("Admin logueado 💪");
            } else {
                $("#error").text("Datos incorrectos");
            }
        }

        if (modo === "USER") {

            if (submodo === "LOGIN") {
                $("#success").text("Usuario logueado 🏋️");
            }

            if (submodo === "REGISTER") {
                if (genero === "") {
                    $("#error").text("Seleccioná un género");
                    return;
                }

                $("#success").text("Usuario registrado 💪");
            }
        }
    });

});