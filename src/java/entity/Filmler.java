/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author ABDULLAH
 */
public class Filmler {
    private Long film_id;
    private String ad;
    private String sure;
    private int imdb;
    private int yönetmen_id;
    private int kategori_id;
    private int dil_id;
    private int yapım_id;
    private String aciklama;
    private int sinemasalonu_id;
    private String vizyon_tarihi;

    public Filmler(Long film_id, String ad, String sure, int imdb, int yönetmen_id, int kategori_id, int dil_id, int yapım_id, String aciklama, int sinemasalonu_id, String vizyon_tarihi, Yonetmen yonetmen, SinemaSalonu sinemaSalonu, Yapım yapım, Dil dil, List<Oyuncu> oynar, List<Tür> filmTür) {
        this.film_id = film_id;
        this.ad = ad;
        this.sure = sure;
        this.imdb = imdb;
        this.yönetmen_id = yönetmen_id;
        this.kategori_id = kategori_id;
        this.dil_id = dil_id;
        this.yapım_id = yapım_id;
        this.aciklama = aciklama;
        this.sinemasalonu_id = sinemasalonu_id;
        this.vizyon_tarihi = vizyon_tarihi;
        this.yonetmen = yonetmen;
        this.sinemaSalonu = sinemaSalonu;
        this.yapım = yapım;
        this.dil = dil;
        this.oynar = oynar;
        this.filmTür = filmTür;
    }

    

    private Yonetmen yonetmen;
    private SinemaSalonu sinemaSalonu;
    private Yapım yapım;
    private Dil dil;
    private List<Oyuncu> oynar;
    private List<Tür> filmTür;

    public Dil getDil() {
        return dil;
    }

    public void setDil(Dil dil) {
        this.dil = dil;
    }

 
    public String getVizyon_tarihi() {
        return vizyon_tarihi;
    }

    public void setVizyon_tarihi(String vizyon_tarihi) {
        this.vizyon_tarihi = vizyon_tarihi;
    }
            
 

    public Filmler() {
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }

    public int getImdb() {
        return imdb;
    }

    public void setImdb(int imdb) {
        this.imdb = imdb;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }


    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public int getDil_id() {
        return dil_id;
    }

    public void setDil_id(int dil_id) {
        this.dil_id = dil_id;
    }

    @Override
    public String toString() {
        return  ad ;
    }

    public Yonetmen getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;
    }

    public SinemaSalonu getSinemaSalonu() {
        return sinemaSalonu;
    }

    public void setSinemaSalonu(SinemaSalonu sinemaSalonu) {
        this.sinemaSalonu = sinemaSalonu;
    }

    public Yapım getYapım() {
        return yapım;
    }

    public void setYapım(Yapım yapım) {
        this.yapım = yapım;
    }

    public List<Tür> getFilmTür() {
        return filmTür;
    }

    public void setFilmTür(List<Tür> filmTür) {
        this.filmTür = filmTür;
    }

  public int getYönetmen_id() {
        return yönetmen_id;
    }

    public void setYönetmen_id(int yönetmen_id) {
        this.yönetmen_id = yönetmen_id;
    }

    public int getYapım_id() {
        return yapım_id;
    }

    public void setYapım_id(int yapım_id) {
        this.yapım_id = yapım_id;
    }

    public int getSinemasalonu_id() {
        return sinemasalonu_id;
    }

    public void setSinemasalonu_id(int sinemasalonu_id) {
        this.sinemasalonu_id = sinemasalonu_id;
    }

    public List<Oyuncu> getOynar() {
        return oynar;
    }

    public void setOynar(List<Oyuncu> oynar) {
        this.oynar = oynar;
    }
    
}
    
