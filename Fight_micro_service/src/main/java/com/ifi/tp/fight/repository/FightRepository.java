package com.ifi.tp.fight.repository;

import com.ifi.tp.fight.bo.Fight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends CrudRepository<Fight, Integer> {
}
