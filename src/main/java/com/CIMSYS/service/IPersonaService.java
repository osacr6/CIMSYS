package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import java.util.List;

public interface IPersonaService {
    public void savePersona (Persona persona);
    public Persona getPersona (long id);
    public void deletePersona (long id);
    public Persona login(Usuario data);
}