package com.accenture.crud.api.controller;

import com.accenture.crud.domain.entity.DTO.ContabilDTO;
import com.accenture.crud.domain.service.ContabilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/contabil")
public class ContabilController {
    @Autowired
    private ContabilService contabilService;

    @GetMapping("/{id}")
    public ResponseEntity<ContabilDTO> findById(@PathVariable int id, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        ContabilDTO contabil = (startDate.isBlank() || endDate.isBlank()) ? contabilService.contabilById(id) : contabilService.findByIdAndDate(id, startDate,endDate);
        return ResponseEntity.ok().body(contabil);
    }
}
