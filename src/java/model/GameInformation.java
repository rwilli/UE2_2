package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Die Klasse GameInformation verwaltet alle relevanten
 * Informationen zum Spiel. Die Anzahl der Spieler, die
 * aktuelle Runde + Zeit, ob das Spiel gewonnen wurde und
 * welcher Spieler gerade führt.
 */
public class GameInformation {
    // Sammlung von Spielern
    private HashMap<String, Player> players = null;
    
    // aktuelle Runde
    private int round = 0;
    
    // Startzeit
    private long start = 0;
    
    // Rundenzeit Sekunden
    private int sec = 0;
    
    // Rundenzeit Minuten
    private int min = 0;
    
    // Führender
    private String leader = "";
    
    // Würfelergebnisse des Computers
    private String cubeComputer = "";
    
    // Flag für das Spielende
    private boolean isFinished = false;
    
    public GameInformation() {
        players = new HashMap<String, Player>();
        start = System.currentTimeMillis();
    }
    
    public void setPlayers(HashMap<String, Player> players) {
        this.players = players;
    }
    
    public List<Player> getPlayers() {
        return new ArrayList<Player>(players.values());
    }
    
    public Player getPlayerById(String str) {
        return this.players.get(str);
    }
    
    public int getNumberOfPlayers() {
        return this.players.size();
    }
    
    public void addPlayer(String id, Player player) {
        if(!players.containsKey(id)) {
            players.put(id, player);
        }
    }
    
    public void incrementRound() {
        this.round++;
    }
    
    public int getRound() {
        return this.round;
    }
    
    public String getTime() {
        String str = "";
        
        sec = (int) ((System.currentTimeMillis() - start) / 1000);
        
        min = sec / 60;
        sec = sec % 60;
        
        str += this.min + " min, " + this.sec + " sec";
        
        return str;
    }
    
    public void setCubeComputer(String number) {
        this.cubeComputer = number;
    }
    
    public String getCubeComputer() {
        return this.cubeComputer;
    }
    
    public void setFinished(boolean b) {
        this.isFinished = b;
    }
    
    public boolean getFinished() {
        return this.isFinished;
    }
    
    public void setLeader(String leader) {
        this.leader = leader;
    }
    
    public String getLeader() {
        return this.leader;
    }
}

