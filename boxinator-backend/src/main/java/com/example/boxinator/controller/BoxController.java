package com.example.boxinator.controller;

import com.example.boxinator.dto.BoxDto;
import com.example.boxinator.exception.DataConstraintViolationException;
import com.example.boxinator.exception.DataDuplicateException;
import com.example.boxinator.exception.DataNotFoundException;
import com.example.boxinator.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin("*")
public class BoxController {

    @Autowired
    BoxService service;

    @GetMapping("/listboxes")
    public ResponseEntity<List<BoxDto>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }



    @PostMapping("/addbox")
    public ResponseEntity<BoxDto> create(@RequestBody @Valid BoxDto dto) throws DataDuplicateException,DataNotFoundException{
        System.out.println("dto = " + dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));

    }



}
