/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Onur
 */
public class SinemaSalonu {
    private Long sinemasalonu_id;
    private String salon_adı;
    private String şehir;

    public Long getSinemasalonu_id() {
        return sinemasalonu_id;
    }

    public void setSinemasalonu_id(Long sinemasalonu_id) {
        this.sinemasalonu_id = sinemasalonu_id;
    }

    public SinemaSalonu(Long sinemasalonu_id, String salon_adı, String şehir) {
        this.sinemasalonu_id = sinemasalonu_id;
        this.salon_adı = salon_adı;
        this.şehir = şehir;
    }

  

    public String getSalon_adı() {
        return salon_adı;
    }

    public void setSalon_adı(String salon_adı) {
        this.salon_adı = salon_adı;
    }

    public String getŞehir() {
        return şehir;
    }

    public void setŞehir(String şehir) {
        this.şehir = şehir;
    }

    public SinemaSalonu() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sinemasalonu_id);
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
        final SinemaSalonu other = (SinemaSalonu) obj;
        if (!Objects.equals(this.sinemasalonu_id, other.sinemasalonu_id)) {
            return false;
        }
        return true;
    }

}
