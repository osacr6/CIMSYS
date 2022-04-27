package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import java.util.List;

public interface IPersonaService {
    public List<Persona> getAll();
    public Persona getById(long id);
    public Persona savePersona (Persona persona);
    public Persona getPersona (long id);
    public void deletePersona (long id);
    public Persona login(Persona data);
}