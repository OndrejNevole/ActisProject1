package org.prisonerApp.main.services;

import org.prisonerApp.main.Repository.PrisonerRepository;
import org.prisonerApp.main.entity.prisoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrisonerService {

    //Reference of PrisonerRepository
    private final PrisonerRepository prisonerRepository;

    @Autowired
    public PrisonerService(PrisonerRepository repository) {
        this.prisonerRepository = repository;
    }

    //SELECT all prisoners from database
    public List<prisoner> getPrisoners() {
        return prisonerRepository.findAll();
    }

    //SELECT prisoner by id
    public Optional<prisoner> getPrisonerbyId(int id) {
        //Check if prisoner exists
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        //Return prisoner
        return prisonerRepository.findById(id);
    }

    //INSERT prisoner to the database
    public void addNewPrisoner(prisoner prisoner) {
        prisonerRepository.save(prisoner);
    }

    //DELETE prisoner from the database
    public void deletePrisoner(int id) {
        //Check if prisoner exists
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        //Delete prisoner
        prisonerRepository.deleteById(id);
    }

    //UPDATE prisoner
    @Transactional
    public void updatePrisoner(int id, prisoner updatedPrisoner) {
        //Check if prisoner exists
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        //Find prisoner to update
        prisonerRepository.findById(id).map(prisoner -> {
            //Update with provided values
            if (updatedPrisoner.getLastName() != null) {
                prisoner.setLastName(updatedPrisoner.getLastName());
            }
            if (updatedPrisoner.getFirstName() != null) {
                prisoner.setFirstName(updatedPrisoner.getFirstName());
            }
            if (updatedPrisoner.getBirthday() != null) {
                prisoner.setBirthday(updatedPrisoner.getBirthday());
            }
            if (updatedPrisoner.getGender() != null) {
                prisoner.setGender(updatedPrisoner.getGender());
            }
            if (updatedPrisoner.getCrime() != null) {
                prisoner.setCrime(updatedPrisoner.getCrime());
            }
            if (updatedPrisoner.getSentanceStart() != null) {
                prisoner.setSentanceStart(updatedPrisoner.getSentanceStart());
            }
            if (updatedPrisoner.getSentanceEnd() != null) {
                prisoner.setSentanceEnd(updatedPrisoner.getSentanceEnd());
            }
            //Save updated prisoner
           return prisonerRepository.save(prisoner);
        });
    }
}
