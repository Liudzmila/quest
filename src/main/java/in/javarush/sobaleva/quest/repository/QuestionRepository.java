package in.javarush.sobaleva.quest.repository;

import in.javarush.sobaleva.quest.entity.Game;

public interface QuestionRepository {
    Game getGameById(int gameId);
}