/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Field;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rainer
 */
public class FieldMap {
    private HashMap<Integer, Field> fields = new HashMap<Integer, Field>();
    
    public FieldMap() {
        
    }
    
    //public void setFieldList(List lst) {
    //    this.fieldList = new ArrayList<Field>(lst);
    //}
    
    public HashMap getFieldMap() {
        return this.fields;
    }
    
    public List<Field> getFieldList() {
        return new ArrayList<Field>(fields.values());
    }
}
