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
        model.addAttribute("caso", caso);
        return "caso";
    }

}
