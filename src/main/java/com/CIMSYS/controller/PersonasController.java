package com.CIMSYS.controller;

import com.CIMSYS.entity.*;
import com.CIMSYS.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonasController {
    @Autowired
    private PersonaService personaService;
    
    
    @PostMapping("/singIn")
    public String singIn(Model model, @ModelAttribute Usuario usuario) {
        Persona logged = personaService.login(usuario);
        if(logged != null) {
            return "redirect:/inicio";
        } else {
            return "redirect:/login";
        }
    }
    
    @GetMapping("/persona/{id}")
    public String Persona(Model model, @PathVariable("id") Long idPersona) {
        Persona persona = personaService.getById(idPersona);
        model.addAttribute("persona", persona);
        return "persona";
    }
    
    @GetMapping("/registro")
    public String crearPersona(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }
    
    @PostMapping("/guardarPersona")
    public String guardarPersona(@ModelAttribute Persona persona, @ModelAttribute Usuario usuario) {
        Persona newPersona = personaService.savePersona(persona);
        return "redirect:/inicio";
    }
}
