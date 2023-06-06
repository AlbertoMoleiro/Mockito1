package com.softtek.mockito1;

import com.softtek.mockito1.model.Pelicula;
import com.softtek.mockito1.repository.IPeliculaRepo;
import com.softtek.mockito1.service.PeliculaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MockitoService {
    @Mock
    private IPeliculaRepo repo;

    @InjectMocks
    private PeliculaService service;

    @DisplayName("Test getPeliculaById")
    @Test
    public void testGetPeliculaById() throws Exception {
        Pelicula salida = new Pelicula(1, "Pelicula 1", "Sinopsis", "url");

        Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(salida));
        Pelicula resultado = service.getPeliculaById(1);
        Assertions.assertEquals(salida, resultado);
    }

    @DisplayName("Test createPelicula")
    @Test
    public void testCreatePelicula() throws Exception {
        Pelicula entrada = new Pelicula(1, "Pelicula 1", "Sinopsis", "url");
        Pelicula salida = new Pelicula(1, "Pelicula 1", "Sinopsis", "url");

        Mockito.when(repo.save(Mockito.any(Pelicula.class))).thenReturn(salida);
        service.createPelicula(entrada);
        Mockito.verify(repo).save(entrada);
    }

    @DisplayName("Test getPeliculas")
    @Test
    public void testGetPeliculas() throws Exception {
        List<Pelicula> salida = List.of(
                new Pelicula(1, "Pelicula 1", "Sinopsis", "url"),
                new Pelicula(2, "Pelicula 2", "Sinopsis", "url"),
                new Pelicula(3, "Pelicula 3", "Sinopsis", "url")
        );

        Mockito.when(repo.findAll()).thenReturn(salida);
        List<Pelicula> resultado = service.getPeliculas();
        Assertions.assertEquals(salida, resultado);
    }
}
