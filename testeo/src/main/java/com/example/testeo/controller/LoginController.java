package com.example.testeo.controller;

import com.example.testeo.model.Usuario;
import com.example.testeo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }



    @PostMapping("/login")
    public String manejarInicioSesion(Usuario usuario, Model model) {
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente != null && usuarioExistente.getPassword().equals(usuario.getPassword())) {
            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Correo electrónico o contraseña incorrectos");
            return "login";
        }
    }
}
