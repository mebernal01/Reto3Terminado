package com.boat.service;

import com.boat.model.ScoreModel;
import com.boat.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAll() {
        return scoreRepository.getAllScore();
    }

    public Optional<ScoreModel> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public ScoreModel save(ScoreModel score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<ScoreModel> scoreEncontrado = getScore(score.getIdScore());
            if (scoreEncontrado.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public ScoreModel update(ScoreModel score){
        if(score.getIdScore() != null){
            Optional<ScoreModel>scoreEncontrado = getScore(score.getIdScore());
            if(!scoreEncontrado.isEmpty()){
                if(score.getMessageText() != null){
                    scoreEncontrado.get(). setMessageText(score.getMessageText());
                }
                if(score.getStarts() != null ){
                    scoreEncontrado.get().setStarts(score.getStarts());
                }
                return scoreRepository.save(scoreEncontrado.get());
            }
        }
        return score;
    }

    public boolean delete(int id){
        Boolean resultado = getScore(id).map(elemento ->{
            scoreRepository.delete(elemento);
            return true;
        }).orElse(false);

        return resultado;
    }
}
