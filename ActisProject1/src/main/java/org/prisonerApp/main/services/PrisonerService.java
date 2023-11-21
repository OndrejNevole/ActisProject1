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

    private final PrisonerRepository prisonerRepository;

    @Autowired
    public PrisonerService(PrisonerRepository repository) {
        this.prisonerRepository = repository;
    }

    public List<prisoner> getPrisoners() {
        return prisonerRepository.findAll();
    }

    public Optional<prisoner> getPrisonerbyId(int id) {
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        return prisonerRepository.findById(id);
    }

    public void addNewPrisoner(prisoner prisoner) {
        prisonerRepository.save(prisoner);
    }

    public void deletePrisoner(int id) {
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        prisonerRepository.deleteById(id);
    }

    @Transactional
    public void updatePrisoner(int id, prisoner updatedPrisoner) {
        boolean exists = prisonerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Prisoner with Id: " + id + " does not exist"
            );
        }
        prisonerRepository.findById(id).map(prisoner -> {
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
           return prisonerRepository.save(prisoner);
        });
    }
}
