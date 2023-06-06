package com.softtek.mockito1.service;

import com.softtek.mockito1.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPeliculaService {
    Pelicula getPeliculaById(int idPelicula) throws Exception;
    Pelicula createPelicula(Pelicula pelicula) throws Exception;
    List<Pelicula> getPeliculas()  throws Exception;


}
