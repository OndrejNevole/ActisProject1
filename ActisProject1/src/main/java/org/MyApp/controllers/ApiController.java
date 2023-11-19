package org.MyApp.controllers;

import org.MyApp.Data.DbStructure;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {
    @GetMapping("/Hello")
    public String getHelloMessage(){
        return "Hello ;)";
    }

    @GetMapping("/TrialDb/SelectAll")
    public ArrayList<DbStructure> getSelectAll() { return DatabaseController.selectEverything("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000");}

    @GetMapping("/TrialDb/SelectById")
    public DbStructure getSelectById(@RequestParam String id) {return DatabaseController.selectById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", id);}

    @PostMapping("/TrialDb/PostToDb")
    public void postToDB(@RequestBody String[] Data) {
        try {
            DatabaseController.insertToDB("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", Data);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    @DeleteMapping("/TrialDb/Delete")
    public void deleteById(@RequestParam String id) { DatabaseController.deleteById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", id); }

    @PutMapping("/TrialDb/Update")
    public void updateById(@RequestBody String id, String updateColumn, String updateValue) { DatabaseController.updateById("jdbc:postgresql://localhost:5432/TrialDB", "postgres", "000", id, updateColumn, updateValue);}
}
