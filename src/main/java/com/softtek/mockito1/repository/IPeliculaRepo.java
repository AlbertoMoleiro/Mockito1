package com.softtek.mockito1.repository;

import com.softtek.mockito1.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepo extends JpaRepository<Pelicula, Integer> {
}
