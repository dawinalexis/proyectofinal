package com.example.testeo.confing;

import com.example.testeo.model.Usuario;
import com.example.testeo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // Aquí puedes realizar validaciones adicionales si es necesario
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // Aquí debes recuperar y devolver los detalles del usuario desde tu base de datos o cualquier otro origen
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new AuthenticationException("Usuario no encontrado") {};
        }
        return usuario;
    }
}