package com.boat.repository;

import com.boat.model.ReservationModel;
import com.boat.model.ScoreModel;
import com.boat.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScore(){
        return(List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(int idScoreModel){
        return scoreCrudRepository.findById(idScoreModel);
    }

    public ScoreModel save(ScoreModel score){
        return scoreCrudRepository.save(score);
    }
    public void delete(ScoreModel score){
        scoreCrudRepository.delete(score);
    }
}
