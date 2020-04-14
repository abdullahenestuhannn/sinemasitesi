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
public class Yonetmen {
    private Long yonetmen_id;
    private String yonetmenadi;
    private String soyad;

    public Yonetmen(Long yonetmen_id, String yonetmenadi, String soyad) {
        this.yonetmen_id = yonetmen_id;
        this.yonetmenadi = yonetmenadi;
        this.soyad = soyad;
    }

    public Yonetmen() {
    }

    public Long getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(Long yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }

 

    public String getYonetmenadi() {
        return yonetmenadi;
    }

    public void setYonetmenadi(String yonetmenadi) {
        this.yonetmenadi = yonetmenadi;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public String toString() {
        return "Yonetmen{" + "yonetmen_id=" + yonetmen_id + ", yonetmenadi=" + yonetmenadi + ", soyad=" + soyad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.yonetmen_id);
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
        final Yonetmen other = (Yonetmen) obj;
        if (!Objects.equals(this.yonetmen_id, other.yonetmen_id)) {
            return false;
        }
        return true;
    }

    
    
    
}
