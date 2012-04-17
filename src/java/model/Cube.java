package model;

/**
 *
 * Klasse Cube steht für den Würfel im Spiel.
 * 
 */
public class Cube {
    // Titel des Würfels
    private String title = "";
    
    // Pfad zum Bild des Würfels
    private String src = "";
    
    // Hinweis zum Würfel
    private String alt = "";
    
    // Aktuelle Augenzahl des Würfels
    private int number = 0;
    
    public Cube() {
        
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }
    
    public String getSrc() {
        return this.src;
    }
    
    public void setAlt(String alt) {
        this.alt = alt;
    }
    
    public String getAlt() {
        return this.alt;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return this.number;
    }
}
