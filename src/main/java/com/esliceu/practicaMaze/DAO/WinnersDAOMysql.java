package com.esliceu.practicaMaze.DAO;

import com.esliceu.practicaMaze.model.Winner;

import java.util.List;

public interface WinnersDAOMysql {
    List<Winner> getAllWinners();
   void insertWinner(Winner winner);

}
