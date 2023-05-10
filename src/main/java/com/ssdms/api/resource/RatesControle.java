package com.ssdms.api.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Rates;
import com.ssdms.domain.repository.RatesRepository;

@RestController
@RequestMapping("/rates")
public class RatesControle {

    private RatesRepository repository;

    public RatesControle(RatesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Rates>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
