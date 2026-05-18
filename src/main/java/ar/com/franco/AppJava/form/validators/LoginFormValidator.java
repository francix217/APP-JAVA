package ar.com.franco.AppJava.form.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.franco.AppJava.form.LoginForm;
import ar.com.franco.AppJava.servicios.UserService;

@Component
public class LoginFormValidator implements Validator {
	
	@Autowired
	private UserService userService;
	
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm f = (LoginForm) target;

        if (f.getUsername() == null || f.getUsername().isBlank()) {
            errors.rejectValue("username", "username.empty");

        } else {
            var usuario = this.userService.buscarPorUsuario(f.getUsername());

            if (usuario == null) {
                errors.rejectValue("username", "username.not.exists");

            } else {
                if (f.getPassword() == null || f.getPassword().isBlank()) {
                    errors.rejectValue("password", "password.empty");

                } else if (!usuario.getContrasena().equals(f.getPassword())) {
                    errors.rejectValue("password", "password.invalid");
                }
            }
        }
    }

}
