package com.ssdms.api.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Rates;
import com.ssdms.domain.repository.RatesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Taxas")
@RestController
@RequestMapping("/rates")
public class RatesController {

    private RatesRepository repository;

    public RatesController(RatesRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Lista de taxas")
    @GetMapping
    public ResponseEntity<List<Rates>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
