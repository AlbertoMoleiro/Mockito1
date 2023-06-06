package com.softtek.mockito1.controller;


import com.softtek.mockito1.model.Pelicula;
import com.softtek.mockito1.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService service;

    @GetMapping("/{idPelicula}")
    public ResponseEntity<Pelicula> getPeliculaById(int idPelicula) throws Exception {
       Pelicula peli = service.getPeliculaById(idPelicula);
         return ResponseEntity.ok(peli);
    }

    @PostMapping("/create")
    public ResponseEntity<Pelicula> createPelicula(Pelicula pelicula) throws Exception {
        return ResponseEntity.ok(service.createPelicula(pelicula));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pelicula>> getPeliculas() throws Exception {
        List<Pelicula> peliculas = service.getPeliculas();
        return ResponseEntity.ok(peliculas);
    }

}
