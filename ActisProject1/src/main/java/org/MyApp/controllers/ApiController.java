package org.MyApp.controllers;

import org.MyApp.Data.Config;
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
    public ArrayList<DbStructure> getSelectAll() {
        Config Config = new Config();
        return DatabaseController.selectEverything(Config.DbAddress, Config.Username, Config.Password);}

    @GetMapping("/TrialDb/SelectById")
    public DbStructure getSelectById(@RequestParam String id) {
        Config Config = new Config();
        return DatabaseController.selectById(Config.DbAddress, Config.Username, Config.Password, id);}

    @PostMapping("/TrialDb/PostToDb")
    public void postToDB(@RequestBody String[] Data) {
        Config Config = new Config();
        try {
            DatabaseController.insertToDB(Config.DbAddress, Config.Username, Config.Password, Data);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    @DeleteMapping("/TrialDb/Delete")
    public void deleteById(@RequestParam String id) {
        Config Config = new Config();
        DatabaseController.deleteById(Config.DbAddress, Config.Username, Config.Password, id); }

    @PutMapping("/TrialDb/Update")
    public void updateById(@RequestBody String id, String updateColumn, String updateValue) {
        Config Config = new Config();
        DatabaseController.updateById(Config.DbAddress, Config.Username, Config.Password, id, updateColumn, updateValue);}
}
