package demo_jdbc.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ConstructorResult {
    private SimpleStringProperty constructor;
    private SimpleIntegerProperty wins;
    private SimpleIntegerProperty totalPoints;
    private SimpleIntegerProperty rank;

    public ConstructorResult(String constructor, int wins, int totalPoints, int rank) {
        this.constructor = new SimpleStringProperty(constructor);
        this.wins = new SimpleIntegerProperty(wins);
        this.totalPoints = new SimpleIntegerProperty(totalPoints);
        this.rank = new SimpleIntegerProperty(rank);
    }

    public String getConstructor() {
        return constructor.get();
    }

    public void setConstructor(String constructor) {
        this.constructor.set(constructor);
    }

    public int getWins() {
        return wins.get();
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }

    public int getTotalPoints() {
        return totalPoints.get();
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints.set(totalPoints);
    }

    public int getRank() {
        return rank.get();
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }
}