package model;

/*
 * Klasse Field steht für ein einzelnes
 * rundes Spielfeld
 */
public class Field {
    // ID des Spielfelds
    private String id = "";
    
    // Pfad zum Bild des Spielfelds
    private String src = "";
    
    // Hinweis zum Spielfeld
    private String alt = "";
    
    // Titel des Spielfelds
    private String title = "";
    
    public Field() {
    
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
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
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    } 
}