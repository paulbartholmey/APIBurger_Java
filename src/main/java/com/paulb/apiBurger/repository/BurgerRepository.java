package com.paulb.apiBurger.repository;

import com.paulb.apiBurger.modele.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
