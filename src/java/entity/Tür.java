/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Ozan
 */
public class Tür {
    private Long tür_id;
    private String türadı;

    public Tür(Long tür_id, String türadı) {
        this.tür_id = tür_id;
        this.türadı = türadı;
    }

    public Tür() {
    }

    public Long getTür_id() {
        return tür_id;
    }

    public void setTür_id(Long tür_id) {
        this.tür_id = tür_id;
    }

    

    public String getTüradı() {
        return türadı;
    }

    public void setTüradı(String türadı) {
        this.türadı = türadı;
    }

    @Override
    public String toString() {
        return türadı ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.tür_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tür other = (Tür) obj;
        if (!Objects.equals(this.tür_id, other.tür_id)) {
            return false;
        }
        return true;
    }
    
    
}
