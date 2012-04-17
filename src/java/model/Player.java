package model;

/*
 * Die Klasse Player verwaltet die Spieler. Dabei hat
 * jeder Spieler zusätzlich zu seinen Bildinformationen,
 * einen Würfel und eine Sammlung von Start- und Zielfeldern.
 */
public class Player {
    // ID des Spielers
    private String id = "";
    
    // Name des Spielers
    private String name = "";
    
    // Pfad zum Bild
    private String src = "";
    
    // Titel des Spielers
    private String title = "";
    
    // Hinweis zum Spieler
    private String alt = "";
    
    // Aktuelle Position
    private int position = 0;
    
    // Relative Positon
    private int relativePos = 1;
    
    // Würfel des Spielers
    private Cube cube = null;
    
    // Startfelder
    private FieldMap homeMap = null;
    
    // Zielfelder
    private FieldMap goalMap = null;
    
    private int start = 0;
    private int stop = 0;
    
    // zeigt an ob der Spieler im Spiel ist
    private boolean isRunning = false;
    
    public Player() {
        
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setSrc(String src) {
        this.src = src;
    }
    
    public String getSrc() {
        return this.src;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setAlt(String alt) {
        this.alt = alt;
    }
    
    public String getAlt() {
        return this.alt;
    }
    
    public void setActPosition(int pos) {
        this.position = pos;
    }
    
    public int getActPosition() {
        return this.position;
    }
    
    public void setRelativePosition(int pos) {
        this.relativePos = pos;
    }
    
    public int getRelativePosition() {
        return this.relativePos;
    }
    
    public void setCube(Cube cube) {
        this.cube = cube;
    }
    
    public Cube getCube() {
        return this.cube;
    }
    
    /*public void setFieldList(FieldMap lst) {
        this.fieldList = lst;
    }
    
    public FieldMap getFieldList() {
        return this.fieldList;
    }*/
    
    public void setHomeMap(FieldMap homeMap) {
        this.homeMap = homeMap;
    }
    
    public FieldMap getHomeMap() {
        return this.homeMap;
    }
    
    public void setGoalMap(FieldMap goalMap) {
        this.goalMap = goalMap;
    }
    
    public FieldMap getGoalMap() {
        return this.goalMap;
    }
    
    /*public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public int getOffset() {
        return this.offset;
    }*/
    
    public void setStart(int st) {
        this.start = st;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public void setStop(int end) {
        this.stop = end;
    }
    
    public int getStop() {
        return this.stop;
    }
    
    public void setRunning(boolean run) {
        this.isRunning = run;
    }
    
    public boolean getRunning() {
        return this.isRunning;
    }
}
