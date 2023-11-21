package org.prisonerApp.main.controllers;

import org.prisonerApp.main.entity.prisoner;
import org.prisonerApp.main.services.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Prisoners")
public class PrisonerController {

    private final PrisonerService prisonerService;

    @Autowired
    public PrisonerController(PrisonerService Prisoner) {
        this.prisonerService = Prisoner;
    }

    @GetMapping
    public List<prisoner> getPrisoner() {
        return prisonerService.getPrisoners();
    }

    @PostMapping()
    public void postPrisoner(@RequestBody prisoner prisoner) {
        prisonerService.addNewPrisoner(prisoner);
    }

    @GetMapping(path = "{prisonerId}")
    public Optional<prisoner> getPrisonerById(@PathVariable("prisonerId") int prisonerId) {
        return prisonerService.getPrisonerbyId(prisonerId);
    }

    @DeleteMapping(path = "{prisonerId}")
    public void deletePrisoner(@PathVariable("prisonerId") int id) {
        prisonerService.deletePrisoner(id);
    }

    @PutMapping(path = "{prisonerId}")
    public void putPrisoner(@PathVariable("prisonerId") int id, @RequestBody prisoner updatedPrisoner) {
        prisonerService.updatePrisoner(id, updatedPrisoner);
    }
}
