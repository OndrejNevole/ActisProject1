package org.MyApp.controllers;

import org.MyApp.Data.DbStructure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ApiController {
    @GetMapping("/Hello")
    public String getHelloMessage(){
        return "Hello World!";
    }

    @GetMapping("/TrialDb/SelectAll")
    public ArrayList<DbStructure> getSelectAll() { return DatabaseController.selectEverything("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "prisoners");}

    @GetMapping("/TrialDb/SelectById")
    public DbStructure getSelectById(@RequestParam String id) {return DatabaseController.selectById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", "prisoners", id);}
}
