package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy}") // To read application properties
    private String dummy;

    @Value("${spring.h2.console.path}") // To read application properties
    private String path;

    @Autowired
    private PropertyService propertyService;

    //Restful api: is just mapping of url to java class function
    @GetMapping("/hello")
    public String sayHello() {
        System.out.println(dummy);
        System.out.println(path);
        return "hello";
    }

    @PostMapping("/save-properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/update-property/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable("propertyId") Long propertyId) {
        propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/patch-property/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@PathVariable("propertyId") Long propertyId, @RequestBody PropertyDTO propertyDTO) {
        propertyService.updatePropertyDescription(propertyId, propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete-property/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable("propertyId") Long propertyId) {
        propertyService.deleteProperty(propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
       return responseEntity;
    }
}
