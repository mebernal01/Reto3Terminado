package com.boat.repository.crudrepository;

import com.boat.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<ScoreModel, Integer> {
}
