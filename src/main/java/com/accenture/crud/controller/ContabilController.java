package com.accenture.crud.controller;

import com.accenture.crud.entity.DTO.ContabilDTO;
import com.accenture.crud.service.ContabilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/contabil")
public class ContabilController {
    //@Autowired
    ContabilService contabilService;

    //@GetMapping("/{id}")
    public ResponseEntity<ContabilDTO> findById(@PathVariable Integer id, @RequestParam String startDate, @RequestParam String endDate){
        return null;
    }
}
