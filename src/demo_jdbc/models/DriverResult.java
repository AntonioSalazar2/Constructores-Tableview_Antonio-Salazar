package demo_jdbc.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DriverResult {
    private SimpleStringProperty driverName;
    private SimpleIntegerProperty wins;
    private SimpleIntegerProperty totalPoints;
    private SimpleIntegerProperty rank;

    public DriverResult(String driverName, int wins, int totalPoints, int rank) {
        this.driverName = new SimpleStringProperty(driverName);
        this.wins = new SimpleIntegerProperty(wins);
        this.totalPoints = new SimpleIntegerProperty(totalPoints);
        this.rank = new SimpleIntegerProperty(rank);
    }

    public String getDriverName() {
        return driverName.get();
    }

    public void setDriverName(String driverName) {
        this.driverName.set(driverName);
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
