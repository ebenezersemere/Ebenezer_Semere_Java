package com.company.gamestore.controller;


import com.company.gamestore.model.Shirt;
import com.company.gamestore.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShirtController {

    @Autowired
    private ShirtRepository shirtRepo;

    @PostMapping("/shirt")
    @ResponseStatus(HttpStatus.CREATED)
    public Shirt createShirt(@RequestBody Shirt shirt) {
        return shirtRepo.save(shirt);
    }

    @DeleteMapping("/shirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShirt(@PathVariable Integer id) {
        shirtRepo.deleteById(id);
    }

    @PutMapping("/shirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateShirt(@RequestBody Shirt shirt) {
        shirtRepo.save(shirt);
    }

    @GetMapping("/shirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Shirt getShirtById(@PathVariable Integer id) {
        return shirtRepo.findById(id).get();
    }

}

