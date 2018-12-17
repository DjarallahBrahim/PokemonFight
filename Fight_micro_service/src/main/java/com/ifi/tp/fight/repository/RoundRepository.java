package com.ifi.tp.fight.repository;

import com.ifi.tp.fight.bo.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository< Round , Long> {
}
