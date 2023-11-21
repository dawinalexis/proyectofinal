package com.example.testeo.confing;

import com.example.testeo.model.Usuario;
import com.example.testeo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Cargar el usuario desde la base de datos utilizando el repositorio
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
        }

        // Devolver un UserDetails con los detalles del usuario
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getContraseña())
                .authorities("ROLE_USER", "READ_PRIVILEGE", "WRITE_PRIVILEGE")
                .build();
    }
}
