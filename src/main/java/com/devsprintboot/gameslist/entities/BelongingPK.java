package com.devsprintboot.gameslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK() {
    }

    public BelongingPK(Games game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK that)) return false;

        if (getGame() != null ? !getGame().equals(that.getGame()) : that.getGame() != null) return false;
        return getGameList() != null ? getGameList().equals(that.getGameList()) : that.getGameList() == null;
    }

    @Override
    public int hashCode() {
        int result = getGame() != null ? getGame().hashCode() : 0;
        result = 31 * result + (getGameList() != null ? getGameList().hashCode() : 0);
        return result;
    }
}
