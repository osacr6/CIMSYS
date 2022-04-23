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
public class CasosController {
    @Autowired
    private CasoService casoService;
    
    @GetMapping("/caso/{id}")
    public String Caso(Model model, @PathVariable("id") Long idCaso) {
        Caso caso = casoService.getById(idCaso);
        Comentario nuevoComentario = new Comentario();
        model.addAttribute("caso", caso);
        List<Comentario> comentario = casoService.getComentarios(idCaso);
        model.addAttribute("comentarios", comentario);
        nuevoComentario.setCaso(caso);
        nuevoComentario.setUsuario(caso.getAsignado());
        model.addAttribute("nuevoComentario", nuevoComentario);
        return "caso";
    }
    
    @PostMapping("/guardarComentario")
    public String guardarPersona(@ModelAttribute Comentario comentario) {
        casoService.saveComentario(comentario);
        return "redirect:/caso/" + comentario.getCaso().getId();
    }
    
    @GetMapping("/eliminarComentario/{id}")
    public String Persona(Model model, @PathVariable("id") Long idComentario) {
        Comentario comentario = casoService.getComentario(idComentario);
        Caso caso = comentario.getCaso();
        casoService.deleteComentario(comentario);
        return "redirect:/caso/" + caso.getId();
    }
}
