package ar.com.franco.AppJava.form.validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.franco.AppJava.form.UserForm;

@Component
public class UserFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserForm form = (UserForm) target;

        // USUARIO
        if (form.getUsuario() == null || form.getUsuario().isEmpty()) {
            errors.rejectValue("usuario", "usuario.empty", "El usuario es obligatorio");
        } else if (form.getUsuario().length() < 5) {
            errors.rejectValue("usuario", "usuario.short", "Mínimo 5 caracteres");
        }

        // CONTRASEÑA
        if (form.getContrasena() == null || form.getContrasena().isEmpty()) {
            errors.rejectValue("contrasena", "contrasena.empty", "La contraseña es obligatoria");
        } else if (form.getContrasena().length() < 6) {
            errors.rejectValue("contrasena", "contrasena.short", "Mínimo 6 caracteres");
        }

        // GENERO (solo en registro)
        if (form.getGenero() == null || form.getGenero().isEmpty()) {
            errors.rejectValue("genero", "genero.empty", "Seleccioná un género");
        }
    }
}

