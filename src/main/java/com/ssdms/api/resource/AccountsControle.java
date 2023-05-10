package com.ssdms.api.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Accounts;
import com.ssdms.domain.repository.AccountsRepository;

@RestController
@RequestMapping("/accounts")
public class AccountsControle {

    private AccountsRepository repository;

    public AccountsControle(AccountsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Accounts>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
