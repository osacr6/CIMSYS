package com.CIMSYS.service;

import com.CIMSYS.entity.*;
import java.util.List;

public interface ICasoService {
    public List<Caso> getAll(String userId);
    public Caso getById (long id);
    public void saveCaso (Caso caso);
    public Caso getCaso (long id);
    public void deleteCaso (long id);
    public List<Comentario> getComentarios(long casoId);
    public void saveComentario(Comentario comentario);
    public Comentario getComentario(long id);
    public void deleteComentario (Comentario comentario);
}