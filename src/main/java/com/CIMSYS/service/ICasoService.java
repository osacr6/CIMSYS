package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import java.util.List;

public interface ICasoService {
    public List<Caso> getAll();
    public Caso getById (long id);
    public void saveCaso (Caso caso);
    public Caso getCaso (long id);
    public void deleteCaso (long id);
    public List<Comentario> getComentarios(long casoId);
}