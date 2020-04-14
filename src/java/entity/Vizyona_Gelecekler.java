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
public class Vizyona_Gelecekler {
    private Long vizyona_girecekler_id;
    private String film_adı;
    private String vizyon_tarihi;

    public Vizyona_Gelecekler(Long vizyona_girecekler_id, String film_adı, String vizyon_tarihi) {
        this.vizyona_girecekler_id = vizyona_girecekler_id;
        this.film_adı = film_adı;
        this.vizyon_tarihi = vizyon_tarihi;
    }

   

    public Vizyona_Gelecekler() {
    }

    public Long getVizyona_girecekler_id() {
        return vizyona_girecekler_id;
    }

    public void setVizyona_girecekler_id(Long vizyona_girecekler_id) {
        this.vizyona_girecekler_id = vizyona_girecekler_id;
    }

   

    public String getFilm_adı() {
        return film_adı;
    }

    public void setFilm_adı(String film_adı) {
        this.film_adı = film_adı;
    }

    public String getVizyon_tarihi() {
        return vizyon_tarihi;
    }

    public void setVizyon_tarihi(String vizyon_tarihi) {
        this.vizyon_tarihi = vizyon_tarihi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.vizyona_girecekler_id);
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
        final Vizyona_Gelecekler other = (Vizyona_Gelecekler) obj;
        if (!Objects.equals(this.vizyona_girecekler_id, other.vizyona_girecekler_id)) {
            return false;
        }
        return true;
    }

  
}
