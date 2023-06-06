package com.softtek.mockito1.service;

import com.softtek.mockito1.model.Pelicula;
import com.softtek.mockito1.repository.IPeliculaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {
    @Autowired
    private IPeliculaRepo repo;

    @Override
    public Pelicula getPeliculaById(int idPelicula) throws Exception {
        return repo.findById(idPelicula).orElse(null);
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) throws Exception {
        return repo.save(pelicula);
    }

    @Override
    public List<Pelicula> getPeliculas() throws Exception{
        return repo.findAll();
    }
}
