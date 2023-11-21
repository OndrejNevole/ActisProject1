package org.MyApp.controllers;

import org.MyApp.Data.Config;
import org.MyApp.Data.DbStructure;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {
    //Test GET endpoint
    @GetMapping("/Hello")
    public String getHelloMessage(){
        return "Hello ;)";
    } //Return hello string

    //Select all row from database
    //GET endpoint
    @GetMapping("/TrialDb/SelectAll")
    public ArrayList<DbStructure> getSelectAll() {
        //Load config
        Config Config = new Config();
        //Call database controller
        return DatabaseController.selectEverything(Config.DbAddress, Config.Username, Config.Password);}

    //Select row by Id
    //GET endpoint
    @GetMapping("/TrialDb/SelectById")
    public DbStructure getSelectById(@RequestParam String id) {
        //Load config
        Config Config = new Config();
        //Call database controller
        return DatabaseController.selectById(Config.DbAddress, Config.Username, Config.Password, id);}

    //Insert data to database
    //POST endpoint
    @PostMapping("/TrialDb/PostToDb")
    public void postToDB(@RequestBody String[] Data) {
        //Load config
        Config Config = new Config();
        //try INSERT data
        try {
            //Call database controller
            DatabaseController.insertToDB(Config.DbAddress, Config.Username, Config.Password, Data);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    //Delete data from database by Id
    //DELETE endpoint
    @DeleteMapping("/TrialDb/Delete")
    public void deleteById(@RequestParam String id) {
        //Load config
        Config Config = new Config();
        //Call database controller
        DatabaseController.deleteById(Config.DbAddress, Config.Username, Config.Password, id); }

    //Update row in database by Id
    //PUT endpoint
    @PutMapping("/TrialDb/Update")
    public void updateById(@RequestBody String id, String updateColumn, String updateValue) {
        //Load config
        Config Config = new Config();
        //Call database controller
        DatabaseController.updateById(Config.DbAddress, Config.Username, Config.Password, id, updateColumn, updateValue);}
}
