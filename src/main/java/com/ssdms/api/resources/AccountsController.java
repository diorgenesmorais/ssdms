package com.ssdms.api.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Accounts;
import com.ssdms.domain.repository.AccountsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Contas")
@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private AccountsRepository repository;

    public AccountsController(AccountsRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Lista de contas")
    @GetMapping
    public ResponseEntity<List<Accounts>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
