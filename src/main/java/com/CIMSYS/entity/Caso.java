package com.CIMSYS.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="caso")
public class Caso implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String Codigo;
    private String Titulo;
    private String Descripcion;
    private String fecha_inicio;
    private String fecha_resolucion;
    private String resolucion;
    private String Status;
    @ManyToOne
    @JoinColumn (name="usuario_id") 
    private Usuario Asignado;
    @ManyToOne
    @JoinColumn (name="persona_id") 
    private Persona cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_resolucion() {
        return fecha_resolucion;
    }

    public void setFecha_resolucion(String fecha_resolucion) {
        this.fecha_resolucion = fecha_resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }   

    public Usuario getAsignado() {
        return Asignado;
    }

    public void setAsignado(Usuario Asignado) {
        this.Asignado = Asignado;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

}

