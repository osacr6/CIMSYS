/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CIMSYS.controller;

import com.CIMSYS.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RouteController {
    @GetMapping("/")
    public String index (){
        return "index";
    }
    
    @GetMapping("/login")
    public String login (Model model){
        Usuario usuario = new Usuario();
        model.addAttribute ("usuario", usuario);
        return "login";
    }
    
    @GetMapping("/inicio")
    public String inicio (){
        return "inicio";
    }
    
    @GetMapping("/control")
    public String control (){
        return "control";
    }
    
    @GetMapping("/faq")
    public String faq (){
        return "faq";
    }
    
    @GetMapping("/soporte")
    public String soporte (){
        return "soporte";
    }
}
