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

    @PostMapping("/TrialDb/SelectAll")
    public ArrayList<DbStructure> getSelectAll(@RequestBody String address, String user, String password) { return DatabaseController.selectEverything(address, user, password);}

    @PostMapping("/TrialDb/SelectById")
    public DbStructure getSelectById(@RequestBody String address, String user, String password, String id) {return DatabaseController.selectById(address, user, password, id);}

    @PostMapping("/TrialDb/PostToDb")
    public void postToDB(@RequestBody String address, String user, String password, String[] Data) {
        try {
            DatabaseController.insertToDB(address, user, password, Data);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    @DeleteMapping("/TrialDb/Delete")
    public void deleteById(@RequestBody String address, String user, String password, String id) { DatabaseController.deleteById(address, user, password, id); }

    @PutMapping("/TrialDb/Update")
    public void updateById(@RequestBody String address, String user, String password, String id, String updateColumn, String updateValue) { DatabaseController.updateById(address, user, password, id, updateColumn, updateValue);}
}
