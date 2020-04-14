/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author POLAT
 */
public class Yapım {
     private Long yapım_id;
    private String ülkesi;

    public Yapım(Long yapım_id, String ülkesi) {
        this.yapım_id = yapım_id;
        this.ülkesi = ülkesi;
    }

    public Long getYapım_id() {
        return yapım_id;
    }

    public void setYapım_id(Long yapım_id) {
        this.yapım_id = yapım_id;
    }

    public String getÜlkesi() {
        return ülkesi;
    }

    public void setÜlkesi(String ülkesi) {
        this.ülkesi = ülkesi;
    }

    public Yapım() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.yapım_id);
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
        final Yapım other = (Yapım) obj;
        if (!Objects.equals(this.yapım_id, other.yapım_id)) {
            return false;
        }
        return true;
    }

}
