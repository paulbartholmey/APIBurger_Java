package com.paulb.apiBurger.service;

import com.paulb.apiBurger.modele.Burger;
import com.paulb.apiBurger.repository.BurgerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class BurgerServiceImpl implements BurgerService {
    private final BurgerRepository burgerRepository;

    @Override
    public Burger creer(Burger burger) {
        return burgerRepository.save(burger) ;
    }

    @Override
    public List<Burger> lire() {
        return burgerRepository.findAll();
    }

    @Override
    public Burger lireById(Long id){
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        return optionalBurger.orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public Burger modifier(Long id, Burger burger) {
            return burgerRepository.findById(id)
                    .map(b-> {
                        b.setPrix(burger.getPrix());
                        b.setNom(burger.getNom());
                        b.setDescription(burger.getDescription());
                        b.setDisponible(burger.isDisponible());
                        return burgerRepository.save(b);
                    }).orElseThrow(()-> new EntityNotFoundException());
        }

    @Override
    public String supprimer(Long id) {
        if (burgerRepository.existsById(id)) {burgerRepository.deleteById(id);}
        else {throw new EntityNotFoundException();}
        return "";
    }
}
