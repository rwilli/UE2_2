package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Die Klasse FieldMap beinhaltet eine Sammlung
 * an Spielfeldern (Field) 
 */
public class FieldMap {
    // Sammlung der Spielfelder (Fields)
    private HashMap<Integer, Field> fields = new HashMap<Integer, Field>();
    
    public FieldMap() {
        
    }
    
    public HashMap getFieldMap() {
        return this.fields;
    }
    
    public List<Field> getFieldList() {
        return new ArrayList<Field>(fields.values());
    }
}
