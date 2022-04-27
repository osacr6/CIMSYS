package com.CIMSYS.controller;

import com.CIMSYS.entity.*;
import com.CIMSYS.service.*;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public String singIn(HttpServletResponse response, @ModelAttribute Persona usuario) {
        Persona logged = personaService.login(usuario);
        if(logged != null) {
            String s = String.valueOf(logged.getId());
            Cookie cookie = new Cookie("user", s);
            response.addCookie(cookie);
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
        return "registro";
    }
    
    @PostMapping("/guardarPersona")
    public String guardarPersona(HttpServletResponse response, @ModelAttribute Persona persona) {
        if( persona.getId() > -1 ) {
            Persona newUsuario = personaService.savePersona(persona);
            String s = String.valueOf(newUsuario.getId());
            Cookie cookie = new Cookie("user", s);
            response.addCookie(cookie);
            return "redirect:/persona/" + newUsuario.getId();
        } else {
            return "registro";
        }
    }
}
