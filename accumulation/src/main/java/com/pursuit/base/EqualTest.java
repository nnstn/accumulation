package com.pursuit.base;

import java.util.HashSet;
import java.util.Set;

public class EqualTest {  
    private int i;  
  
    public int getI() {  
        return i;  
    }  
  
    public void setI(int i) {  
        this.i = i;  
    }  
  
    public boolean equals(Object object) {  
        if (object == null) {  
            return false;  
        }  
        if (object == this) {  
            return true;  
        }  
        if (!(object instanceof EqualTest)) {  
            return false;  
        }  
        EqualTest other = (EqualTest) object;  
        if (other.getI() == this.getI()) {  
            return true;  
        }  
        return false;  
    }
  
    public int hashCode() {  
        return i % 10;  
    }  
  
    public final static void main(String[] args) {  
    	EqualTest a = new EqualTest();  
    	EqualTest b = new EqualTest();  
        a.setI(1);  
        b.setI(1);  
        Set<EqualTest> set = new HashSet<EqualTest>();  
        set.add(a);  
        set.add(b);  
        System.out.println(a.hashCode() == b.hashCode());  
        System.out.println(a.equals(b));  
        System.out.println(set);  
    }  
}  