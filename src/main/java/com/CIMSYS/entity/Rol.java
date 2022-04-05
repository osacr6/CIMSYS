/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CIMSYS.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="rol")
public class Rol implements Serializable{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String RolName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolName() {
        return RolName;
    }

    public void setRolName(String RolName) {
        this.RolName = RolName;
    }

}
