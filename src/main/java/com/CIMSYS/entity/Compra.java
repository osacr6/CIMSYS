package com.CIMSYS.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="compra")
public class Compra implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn (name="persona_id") 
    private Persona cliente;
    private String tipo_pago;
    private String Fecha;
    private String Articulos; //
    private String Precio;
    private String Modalidad;
    private String Riesgo;
    private String Direccion;
}

