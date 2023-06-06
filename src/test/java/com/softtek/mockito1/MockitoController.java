package com.softtek.mockito1;

import com.softtek.mockito1.controller.PeliculaController;
import com.softtek.mockito1.model.Pelicula;
import com.softtek.mockito1.service.PeliculaService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.beans.Beans;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class MockitoController {
    @Mock
    private PeliculaService service;

    @InjectMocks
    private PeliculaController controller;

    @DisplayName("Test getPeliculaById")
    @Test
    public void testGetPeliculaById() throws Exception {
        Pelicula salida = new Pelicula(1, "Pelicula 1", "Sinopsis", "url");

        Mockito.when(service.getPeliculaById(Mockito.anyInt())).thenReturn(salida);

        final ResponseEntity<Pelicula> response = controller.getPeliculaById(1);
        Pelicula resultado = response.getBody();
        Assertions.assertEquals(salida, resultado);

    }

    @DisplayName("Test createPelicula")
    @Test
    public void testCreatePelicula() throws Exception {
        Pelicula entrada = new Pelicula(1, "Pelicula 1", "Sinopsis", "url");

        Mockito.when(service.createPelicula(Mockito.any(Pelicula.class))).thenReturn(entrada);
        final ResponseEntity<Pelicula> response = controller.createPelicula(entrada);
        Pelicula resultado = response.getBody();
        Mockito.verify(service).createPelicula(entrada);
    }

    @DisplayName("Test getPeliculas")
    @Test
    public void testGetPeliculas() throws Exception {
        List<Pelicula> peliculas = List.of(
                new Pelicula(1, "Pelicula 1", "Sinopsis", "url"),
                new Pelicula(2, "Pelicula 2", "Sinopsis", "url"),
                new Pelicula(3, "Pelicula 3", "Sinopsis", "url")
        );

        Mockito.when(service.getPeliculas()).thenReturn(peliculas);
        final ResponseEntity<List<Pelicula>> response = controller.getPeliculas();
       Object resultado = response.getBody();
        assertThat(resultado).isInstanceOf(List.class);

        List<Pelicula> listaPeliculas = (List<Pelicula>) resultado;
        assertThat(listaPeliculas.size()).isEqualTo(3);
        assertThat(((List<Pelicula>)response.getBody()).size()).isEqualTo(3);

    }


}
