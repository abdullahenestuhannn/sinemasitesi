

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity. Vizyona_Gelecekler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onur
 */
public class Vizyona_GeleceklerDAO  extends DAO{
     public  Vizyona_Gelecekler find(int id){
         Vizyona_Gelecekler vg=null;
         String query = ("select * from vizyona_gelecekler where vizyona_gelecekler_id="+id);
         try {
            PreparedStatement pst = getConn().prepareStatement(query);
             ResultSet rs = pst.executeQuery();
             rs.next();
             
             vg=new  Vizyona_Gelecekler();
             vg.setVizyona_girecekler_id(rs.getLong("vizyona_gelecekler_id"));
             vg.setFilm_adı(rs.getString("film_adı"));
            vg.setVizyon_tarihi(rs.getString("vizyon_tarihi"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vg;
        
    }
    public List< Vizyona_Gelecekler> hepsiniOku(int page,int pageSize) {
        List< Vizyona_Gelecekler> vglist = new ArrayList<>();
        int start=(page-1)*pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from vizyona_gelecekler order by vizyona_gelecekler_id asc limit "+start+" , "+pageSize);
            ResultSet rs = pst.executeQuery();

           while (rs.next()) {
                Vizyona_Gelecekler tmp = new Vizyona_Gelecekler();
                tmp.setVizyona_girecekler_id(rs.getLong("vizyona_gelecekler_id"));
                tmp.setFilm_adı(rs.getString("film_adı"));
                tmp.setVizyon_tarihi(rs.getString("vizyon_tarihi"));
                vglist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vglist;
    }
    public int  count() {
        int count=0; 
        

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(vizyona_gelecekler_id) as vizyona_count from vizyona_gelecekler");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("vizyona_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void ekle( Vizyona_Gelecekler vizyonagelecekler) {
        String query = "insert into vizyona_gelecekler values(default,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, vizyonagelecekler.getFilm_adı());
            pst.setString(2, vizyonagelecekler.getVizyon_tarihi());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil( Vizyona_Gelecekler vizyonagelecekler) {
        String query = "delete from vizyona_gelecekler where vizyona_gelecekler_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1,vizyonagelecekler.getVizyona_girecekler_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle( Vizyona_Gelecekler vizyonagelecekler) {
        String query = "update vizyona_gelecekler set film_adı=?,vizyon_tarihi=? where vizyona_gelecekler_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, vizyonagelecekler.getFilm_adı());
            pst.setString(2, vizyonagelecekler.getVizyon_tarihi());
            pst.setLong(3, vizyonagelecekler.getVizyona_girecekler_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

