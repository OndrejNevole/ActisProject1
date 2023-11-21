package org.prisonerApp.main.Repository;

import org.prisonerApp.main.entity.prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrisonerRepository extends JpaRepository<prisoner, Integer> {
    //Interface for JpaRepository functions
}
