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
public class Dil {
     private Long dil_id;
    private String diladı;

    public Dil(Long dil_id, String diladı) {
        this.dil_id = dil_id;
        this.diladı = diladı;
    }

    public Long getDil_id() {
        return dil_id;
    }

    public void setDil_id(Long dil_id) {
        this.dil_id = dil_id;
    }

    public String getDiladı() {
        return diladı;
    }

    public void setDiladı(String diladı) {
        this.diladı = diladı;
    }

    public Dil() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.dil_id);
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
        final Dil other = (Dil) obj;
        if (!Objects.equals(this.dil_id, other.dil_id)) {
            return false;
        }
        return true;
    }

}
