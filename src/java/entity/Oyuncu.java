/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author ABDULLAH
 */
public class Oyuncu {
    private Long oyuncu_id;
    private String ad;
    private String soyad;
    private Oyuncu oyuncu;
    public Oyuncu() {
    }

    public Oyuncu(Long oyuncu_id, String ad, String soyad) {
        this.oyuncu_id = oyuncu_id;
        this.ad = ad;
        this.soyad = soyad;
    }

    public Long getOyuncu_id() {
      
        return oyuncu_id;
    }

    public void setOyuncu_id(Long oyuncu_id) {
        this.oyuncu_id = oyuncu_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public String toString() {
        return "id=" + oyuncu_id + ", ad=" + ad + ", soyad=" + soyad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.oyuncu_id);
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
        final Oyuncu other = (Oyuncu) obj;
        if (!Objects.equals(this.oyuncu_id, other.oyuncu_id)) {
            return false;
        }
        return true;
    }
    
    
}
