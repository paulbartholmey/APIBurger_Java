package com.paulb.apiBurger.controller;

import com.paulb.apiBurger.modele.Burger;
import com.paulb.apiBurger.service.BurgerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/burgers")
@AllArgsConstructor
public class BurgerController {
    private final BurgerService burgerService;

    @PostMapping("")
    public Burger create(@RequestBody Burger burger){
        return burgerService.creer(burger);
    }

    @GetMapping("")
    public List<Burger> read(){
        return burgerService.lire();
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id){
        try {
            Burger burger =  burgerService.lireById(id);
            return ResponseEntity.ok(burger);
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(BAD_REQUEST).body("Pas de burger avec cet ID");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Burger burger){
        try {
            burgerService.modifier(id, burger);
            return ResponseEntity.ok("Burger mis à jour");
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(BAD_REQUEST).body("Pas de burger avec cet ID");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            burgerService.supprimer(id);
            return ResponseEntity.ok("Burger supprimé");
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(BAD_REQUEST).body("Pas de burger avec cet ID");
        }
    }

}
