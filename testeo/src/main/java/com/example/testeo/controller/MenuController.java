package com.example.testeo.controller;

import com.example.testeo.model.Tarea;
import com.example.testeo.model.Usuario;
import com.example.testeo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/menu")
    public String mostrarMenu(Model model) {
        model.addAttribute("tarea", new Usuario());
        return "menu";
    }

    @PostMapping("/saveTask")
    public void saveTask(@RequestBody Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @GetMapping("/loadTasks")
    public List<Tarea> loadTasks(@RequestParam String email) {
        return tareaRepository.findByEmail(email);
    }
    @GetMapping("/currentUser")
    @ResponseBody
    public String getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}