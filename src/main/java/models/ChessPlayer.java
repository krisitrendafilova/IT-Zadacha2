package models;

import java.util.Objects;


public class ChessPlayer {
    private int fideId;
    private String name;
    private String lastName;
    private int elo;

    public ChessPlayer() {
    }

    public ChessPlayer(String name, String lastName, int elo) {
        this.name = name;
        this.lastName = lastName;
        this.elo = elo;
    }

    public ChessPlayer(int fideId, String name, String lastName, int elo) {
        this(name, lastName, elo);
        this.fideId = fideId;
    }

    public int getFideId() {
        return fideId;
    }

    public void setFideId(int fideId) {
        this.fideId = fideId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChessPlayer that = (ChessPlayer) o;
        return fideId == that.fideId && elo == that.elo && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fideId, name, lastName, elo);
    }

    @Override
    public String toString() {
        return "ChessPlayer{" +
                "fideId=" + fideId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", elo=" + elo +
                '}';
    }
}
