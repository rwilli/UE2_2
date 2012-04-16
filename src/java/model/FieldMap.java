/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rainer
 */
public class FieldList {
    private List<Field> fieldList = new ArrayList<Field>();
    
    public FieldList() {
        
    }
    
    public void setFieldList(List lst) {
        this.fieldList = new ArrayList<Field>(lst);
    }
    
    public List<Field> getFieldList() {
        return this.fieldList;
    }
}
