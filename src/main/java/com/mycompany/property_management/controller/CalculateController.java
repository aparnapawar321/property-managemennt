package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.MultiplyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculate")
public class CalculateController {

    @GetMapping("/add/{num3}")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2,
                      @PathVariable("num3") Double num3) {
        return num1 + num2+ num3;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public Double subtract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result= num1-num2;
        }else result = num2-num1;
        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody MultiplyDTO multiplyDTO){
        Double result= null;
        result = multiplyDTO.getNum1()*multiplyDTO.getNum2()*multiplyDTO.getNum3()*multiplyDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}

