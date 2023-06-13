package com.example.itemjson.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itemjson.service.ItemService;
import com.example.itemjson.service.ItemjsonApplicationService;

@RestController
public class ItemjsonApplicationController {
    @Autowired 
    public ItemService itemService ;


    @GetMapping("/getitemdata")
        public ResponseEntity<String>getAllItemData(){

            String data = ItemService.getAllData();
            return new ResponseEntity<String>(data,HttpStatus.OK);

    }

}
