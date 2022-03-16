package com.CIMSYS.controller;

import com.CIMSYS.entity.*;
import com.CIMSYS.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonasController {
    @Autowired
    private PersonaService IPersonaService;
    
    @PostMapping("/singIn")
    public String singIn(@ModelAttribute Usuario usuario) {
        Persona persona = IPersonaService.login(usuario);
        return "redirect:/inicio";
    }
}
