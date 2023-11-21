package org.prisonerApp.main.Repository;

import org.prisonerApp.main.entity.prisoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface for fancy JpaRepository functions
@Repository
public interface PrisonerRepository extends JpaRepository<prisoner, Integer> {

}
