package com.paulb.apiBurger.service;

import com.paulb.apiBurger.modele.Burger;
import java.util.List;

public interface BurgerService {

    Burger creer(Burger burger);

    List<Burger> lire();

    Burger lireById(Long id);

    Burger modifier(Long id, Burger burger);

    String supprimer(Long id);


}
