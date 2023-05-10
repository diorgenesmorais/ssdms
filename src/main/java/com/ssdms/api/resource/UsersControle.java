package com.ssdms.api.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Users;
import com.ssdms.domain.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersControle {

    private UsersRepository repository;

    public UsersControle(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
}
