package org.prisonerApp.main.controllers;

import org.prisonerApp.main.entity.prisoner;
import org.prisonerApp.main.services.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Prisoners") //Setting url
public class PrisonerController {

    //Reference for PrisonerService
    private final PrisonerService prisonerService;

    //Dependency injection of PrisonerController
    @Autowired
    public PrisonerController(PrisonerService Prisoner) {
        this.prisonerService = Prisoner;
    }

    //GET endpoint for selecting all prisoners
    //GET http://localhost:8080/Prisoners/All
    @GetMapping("/All")
    public List<prisoner> getPrisoner() {
        return prisonerService.getPrisoners();
    }

    //GET endpoint for getting prisoner by Id
    //GET http://localhost:8080/Prisoners/{id here}
    @GetMapping(path = "{prisonerId}")
    public Optional<prisoner> getPrisonerById(@PathVariable("prisonerId") int prisonerId) {
        return prisonerService.getPrisonerbyId(prisonerId);
    }

    //POST endpoint for adding prisoners
    //POST http://localhost:8080/Prisoners
    @PostMapping()
    public void postPrisoner(@RequestBody prisoner prisoner) {
        prisonerService.addNewPrisoner(prisoner);
    }

    //DELETE endpoint
    //DELETE http://localhost:8080/Prisoners/{id here}
    @DeleteMapping(path = "{prisonerId}")
    public void deletePrisoner(@PathVariable("prisonerId") int id) {
        prisonerService.deletePrisoner(id);
    }

    //PUT endpoint for editing prisoners
    //PUT http://localhost:8080/Prisoners/{id here}
    @PutMapping(path = "{prisonerId}")
    public void putPrisoner(@PathVariable("prisonerId") int id, @RequestBody prisoner updatedPrisoner) {
        prisonerService.updatePrisoner(id, updatedPrisoner);
    }
}
