package com.example.RenewApp2.Repository;

import com.example.RenewApp2.Entity.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViniloRepository extends JpaRepository<Vinilo,Integer> {
}
