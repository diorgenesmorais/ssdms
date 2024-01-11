package com.ssdms.api.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Users;
import com.ssdms.domain.repository.UsersRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Usuários")
@RestController
@RequestMapping("/users")
public class UsersController {

    private UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Lista de usuários")
    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
