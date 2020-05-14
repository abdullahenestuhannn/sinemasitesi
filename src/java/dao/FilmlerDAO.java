/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Filmler;
import entity.Oyuncu;
import entity.Tür;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABDULLAH
 */
public class FilmlerDAO extends DAO {

    private SinemaSalonuDAO sinemaSalonuDAO;

    private YapımDAO yapımDAO;
    private TürDAO türDAO;
    private OyuncuDAO oyuncuDAO;
    private DilDAO dilDAO;
    private YonetmenDAO yonetmenDAO;

    public List<Filmler> hepsiniOku(int page,int pageSize) {
        List<Filmler> flist = new ArrayList<>();
        int start=(page-1)*pageSize;


        try {
            PreparedStatement pst = getConn().prepareStatement("select * from filmler order by film_id asc limit "+start+" , "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Filmler tmp = new Filmler();
                tmp.setFilm_id(rs.getLong("film_id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSure(rs.getString("süre"));
                tmp.setImdb(rs.getInt("imdb"));
                tmp.setYonetmen(this.getYonetmenDAO().find(rs.getLong("yönetmen_id")));
                tmp.setYapım(this.getYapımDAO().find(rs.getLong("yapım_id")));
                tmp.setDil(this.getDilDAO().find(rs.getLong("dil_id")));
                tmp.setAciklama(rs.getString("acıklama"));
                tmp.setSinemaSalonu(this.getSinemaSalonuDAO().find(rs.getLong("sinemasalonu_id")));
                tmp.setVizyon_tarihi(rs.getString("vizyon_tarihi"));
                tmp.setFilmTür(this.getTürDAO().getFilmTür(tmp.getFilm_id()));
                tmp.setOynar(this.getOyuncuDAO().getOynar(tmp.getFilm_id()));
                flist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flist;
    }
     public int count() {
         int count=0; 
        

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(film_id) as film_count from filmler  ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("film_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void ekle(Filmler filmler) {
        try {
            PreparedStatement pst = getConn().prepareStatement("insert into filmler(film_id,ad,süre,imdb,yönetmen_id,dil_id,yapım_id,acıklama,sinemasalonu_id,vizyon_tarihi) values(default,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, filmler.getAd());
            pst.setString(2, filmler.getSure());
            pst.setInt(3, filmler.getImdb());
            pst.setLong(4, filmler.getYonetmen().getYonetmen_id());
            pst.setLong(5, filmler.getDil().getDil_id());
            pst.setLong(6, filmler.getYapım().getYapım_id());
            pst.setString(7, filmler.getAciklama());
            pst.setLong(8, filmler.getSinemaSalonu().getSinemasalonu_id());
            pst.setString(9, filmler.getVizyon_tarihi());

            pst.executeUpdate();

            ResultSet gk = pst.getGeneratedKeys();
            Long film_id = null;
            if (gk.next()) {
                film_id = gk.getLong(1);
            }

            for (Tür t : filmler.getFilmTür()) {
                pst = this.getConn().prepareStatement("insert into film_tür(film_tür_id,film_id,tür_id) values(default,?,?)");
                pst.setLong(1, film_id);
                pst.setLong(2, t.getTür_id());
                pst.executeUpdate();
            }
             for (Oyuncu o : filmler.getOynar()) {
                pst = this.getConn().prepareStatement("insert into oynar(oynar_id,film_id,oyuncu_id) values(default,?,?)");
                pst.setLong(1, film_id);
                pst.setLong(2, o.getOyuncu_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        
    }

    public void sil(Filmler film) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from film_tür where film_id=?");
            pst.setLong(1, film.getFilm_id());
            pst.executeUpdate();
            pst=this.getConn().prepareStatement("delete from oynar where film_id=?");
            pst.setLong(1, film.getFilm_id());
            pst.executeUpdate();
            pst = this.getConn().prepareStatement("delete from filmler where film_id=?");
            pst.setLong(1, film.getFilm_id());
            
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   

    public void guncelle(Filmler filmler) {
        try {
            PreparedStatement pst = getConn().prepareStatement("update filmler set ad=?,süre=?,imdb=?,yönetmen_id=?,dil_id=?,yapım_id=?,acıklama=?,sinemasalonu_id=?,vizyon_tarihi=? where film_id=?");
            pst.setString(1, filmler.getAd());
            pst.setString(2, filmler.getSure());
            pst.setInt(3, filmler.getImdb());
            pst.setLong(4, filmler.getYonetmen().getYonetmen_id());
            pst.setLong(5, filmler.getDil().getDil_id());
            pst.setLong(6, filmler.getYapım().getYapım_id());
            pst.setString(7, filmler.getAciklama());
            pst.setLong(8, filmler.getSinemaSalonu().getSinemasalonu_id());
            pst.setString(9, filmler.getVizyon_tarihi());
            pst.setLong(10, filmler.getFilm_id());
            pst.executeUpdate();

            pst = this.getConn().prepareStatement("delete from film_tür where film_id=?");
            pst.setLong(1, filmler.getFilm_id());
            pst.executeUpdate();
            
            for (Tür t : filmler.getFilmTür()) {
                pst = this.getConn().prepareStatement("insert into film_tür(film_id,tür_id) values(?,?)");
                pst.setLong(1, filmler.getFilm_id());
                pst.setLong(2, t.getTür_id());
                pst.executeUpdate();
            }
            
            pst = this.getConn().prepareStatement("delete from oynar where film_id=?");
            pst.setLong(1, filmler.getFilm_id());
            pst.executeUpdate();
            
              for (Oyuncu o : filmler.getOynar()) {
                pst = this.getConn().prepareStatement("insert into oynar(oynar_id,film_id,oyuncu_id) values(default,?,?)");
                pst.setLong(1, filmler.getFilm_id());
                pst.setLong(2, o.getOyuncu_id());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public YonetmenDAO getYonetmenDAO() {
        if (this.yonetmenDAO == null) {
            this.yonetmenDAO = new YonetmenDAO();
        }
        return yonetmenDAO;
    }

    public SinemaSalonuDAO getSinemaSalonuDAO() {
        if (this.sinemaSalonuDAO == null) {
            this.sinemaSalonuDAO = new SinemaSalonuDAO();
        }

        return sinemaSalonuDAO;
    }

    public YapımDAO getYapımDAO() {
        if (this.yapımDAO == null) {
            this.yapımDAO = new YapımDAO();
        }

        return yapımDAO;
    }

    public TürDAO getTürDAO() {
        if (this.türDAO == null) {
            this.türDAO = new TürDAO();
        }

        return türDAO;
    }

    public void setSinemaSalonuDAO(SinemaSalonuDAO sinemaSalonuDAO) {
        this.sinemaSalonuDAO = sinemaSalonuDAO;
    }

    public void setYapımDAO(YapımDAO yapımDAO) {
        this.yapımDAO = yapımDAO;
    }

    public void setTürDAO(TürDAO türDAO) {
        this.türDAO = türDAO;
    }

    public void setYonetmenDAO(YonetmenDAO yonetmenDAO) {
        this.yonetmenDAO = yonetmenDAO;
    }

    public OyuncuDAO getOyuncuDAO() {
         if (this.oyuncuDAO == null) {
            this.oyuncuDAO = new OyuncuDAO();
        }
        return oyuncuDAO;
    }

    public void setOyuncuDAO(OyuncuDAO oyuncuDAO) {
        this.oyuncuDAO = oyuncuDAO;
    }

    public DilDAO getDilDAO() {
        if (this.dilDAO == null) {
            this.dilDAO = new DilDAO();
        }return dilDAO;
    }

    public void setDilDAO(DilDAO dilDAO) {
        this.dilDAO = dilDAO;
    }

}
