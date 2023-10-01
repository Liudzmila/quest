package in.javarush.sobaleva.quest;

import in.javarush.sobaleva.quest.service.GameService;

public class GameLauncher {
    /**
     * You can set GAME_ID to 1 or 2,
     * 1 - the game 'Hedgehog in the Mist',
     * 2 - the game 'A Mother for a Mammoth'.
     * You can also add a new JSON file,
     * changing the JSON_FILE_PATH,
     * then you can load games from a new file.
     */
    private static GameService gameService;
    private static final String JSON_FILE_PATH = "quest_logic.json";
    private static final int GAME_ID = 2;

    private GameLauncher() {
        gameService = new GameService(GAME_ID, JSON_FILE_PATH);
    }

    private static class Holder {
        private static final GameLauncher INSTANCE = new GameLauncher();
    }

    public static GameService getGameService() {
        return Holder.INSTANCE.gameService;
    }
}