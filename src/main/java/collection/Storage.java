package collection;

import models.ChessPlayer;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance = null;
    private List<ChessPlayer> players;
    private int id = 1;

    public Storage() {
        players = new ArrayList<>();
    }

    public List<ChessPlayer> getPlayers() {
        return new ArrayList<>(players);
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addPlayer(ChessPlayer player) {
        player.setFideId(id++);
        players.add(player);
    }

    public ChessPlayer showPlaayerByID(int id) {
        for (int i = 0; i < players.size(); i++) {
            ChessPlayer player = players.get(i);
            if (player.getFideId() == id) {
                return player;
            }
        }
        return null;
    }


}
