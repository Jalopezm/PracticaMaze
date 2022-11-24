package com.esliceu.practicaMaze.DAO;

import com.esliceu.practicaMaze.model.Winner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.esliceu.practicaMaze.DAO.ConnectionMysql.getConnection;

public class WinnersMysql implements WinnersDAOMysql {
    @Override
    public void insertWinner(Winner winner) {

        try {
            Connection con = getConnection();
            String query = "insert into winners (NAME, MAZE NAME, TIME) values (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, winner.getWinnerName());
            preparedStatement.setString(2, winner.getMazeSolved());
            preparedStatement.setInt(3, (int) winner.getTime());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                winner.setWinnerId(id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Winner> getAllWinners() {
        try {
            List<Winner> allWinners = new ArrayList<>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from winners");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String playerName = resultSet.getString(2);
                String mazeName = resultSet.getString(3);
                Long time = resultSet.getLong(4);
                Winner winner = new Winner();
                winner.setWinnerId(id);
                winner.setWinnerName(playerName);
                winner.setMazeSolved(mazeName);
                winner.setTime(time);
                allWinners.add(winner);
            }
            return allWinners;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
