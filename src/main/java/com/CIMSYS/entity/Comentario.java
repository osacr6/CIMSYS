/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CIMSYS.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="comentario")
public class Comentario implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String Comentario;
    private String Fecha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="usuario_id") 
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="caso_id") 
    private Caso caso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }
}
