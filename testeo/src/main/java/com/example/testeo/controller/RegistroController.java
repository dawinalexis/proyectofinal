package com.example.testeo.controller;

import com.example.testeo.model.Usuario;
import com.example.testeo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        // Agrega un objeto Usuario al modelo
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        // Realiza validaciones y lógica de registro aquí

        // Ejemplo de validación simple (puedes agregar más según tus requisitos)
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            model.addAttribute("error", "El nombre es obligatorio");
            return "registro";
        }

        // Guarda el usuario en la base de datos
        usuarioRepository.save(usuario);

        // Redirige al usuario a la página de inicio de sesión
        return "redirect:/registro";
    }

}
