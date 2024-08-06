package com.example.RenewApp2.Repository;

import com.example.RenewApp2.Entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Integer> {
}
