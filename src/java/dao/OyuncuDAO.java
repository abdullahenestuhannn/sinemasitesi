/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Oyuncu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABDULLAH
 */
public class OyuncuDAO extends DAO {

    public List<Oyuncu> hepsiniOku(int page,int pageSize) {
        List<Oyuncu> olist = new ArrayList<>();
        int start=(page-1)*pageSize;
       

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from oyuncu order by oyuncu_id asc limit "+start+" , "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Oyuncu tmp = new Oyuncu();
                tmp.setOyuncu_id(rs.getLong("oyuncu_id"));
                tmp.setAd(rs.getString("adı"));
                tmp.setSoyad(rs.getString("soyad"));
                olist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return olist;
    }

    public void ekle(Oyuncu oyuncu) {
        String query = "insert into oyuncu values(default,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, oyuncu.getAd());
            pst.setString(2, oyuncu.getSoyad());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Oyuncu oyuncu) {
        String query = "delete from oyuncu where oyuncu_id=?";
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, oyuncu.getOyuncu_id());
            pst.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Oyuncu oyuncu) {
        String query = "update oyuncu set adı=?,soyad=? where oyuncu_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, oyuncu.getAd());
            pst.setString(2, oyuncu.getSoyad());
            pst.setLong(3, oyuncu.getOyuncu_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int  count() {
        int count=0; 
        

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(oyuncu_id) as oyuncu_count from oyuncu");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("oyuncu_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
    public List<Oyuncu> getOynar(Long film_id) {
         List<Oyuncu> oynar = new ArrayList<>();
      
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from oynar where film_id=?");
            pst.setLong(1, film_id);
             ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                oynar.add(this.find(rs.getLong("oyuncu_id")));
            }         
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         return oynar;
    }

    public Oyuncu find(Long id) {
            Oyuncu o =null;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from oyuncu where oyuncu_id="+id);
             ResultSet rs = pst.executeQuery();
            rs.next();
            
            o=new Oyuncu();
            o.setOyuncu_id(rs.getLong("oyuncu_id"));
            o.setAd(rs.getString("adı"));
            o.setSoyad(rs.getString("soyad"));           
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return o;    }

    public List<Oyuncu> hepsiniOku() {
  List<Oyuncu> oylist = new ArrayList<>();
      
       

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from oyuncu ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Oyuncu tmp = new Oyuncu();
                tmp.setOyuncu_id(rs.getLong("oyuncu_id"));
                tmp.setAd(rs.getString("adı"));
                tmp.setSoyad(rs.getString("soyad"));
                oylist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return oylist;    }
}
