/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Oyuncu;
import entity.Yonetmen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author POLAT
 */
public class YonetmenDAO extends DAO {

    public List<Yonetmen> findall(int page, int pageSize) {
        List<Yonetmen> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from yönetmen order by yönetmen_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yonetmen tmp = new Yonetmen();
                tmp.setYonetmen_id(rs.getLong("yönetmen_id"));
                tmp.setYonetmenadi(rs.getString("yönetmenadı"));
                tmp.setSoyad(rs.getString("soyad"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
     public int  count() {
        int count=0;
         
        try {
            PreparedStatement pst = getConn().prepareStatement("select count(yönetmen_id) as yönetmen_count from yönetmen");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("yönetmen_count");  
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

     }

    public Yonetmen find(Long id) {
        Yonetmen y = null;
        String query = ("select * from yönetmen where yönetmen_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            y = new Yonetmen();
            y.setYonetmen_id(rs.getLong("yönetmen_id"));
            y.setYonetmenadi(rs.getString("yönetmenadı"));
            y.setSoyad(rs.getString("soyad"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return y;

    }

 

    public void ekle(Yonetmen yonetmen) {
        String query = "insert into yönetmen values(default,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yonetmen.getYonetmenadi());
            pst.setString(2, yonetmen.getSoyad());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Yonetmen yonetmen) {
        String query = "delete from yönetmen where yönetmen_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, yonetmen.getYonetmen_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Yonetmen yonetmen) {
        String query = "update yönetmen set yönetmenadı=?,soyad=? where yönetmen_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yonetmen.getYonetmenadi());
            pst.setString(2, yonetmen.getSoyad());
            pst.setLong(3, yonetmen.getYonetmen_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Yonetmen> findall() {
         List<Yonetmen> yList = new ArrayList<>();
       try {
           
            PreparedStatement pst = getConn().prepareStatement("select * from yönetmen order by yönetmen_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yonetmen tmp = new Yonetmen();
                tmp.setYonetmen_id(rs.getLong("yönetmen_id"));
                tmp.setYonetmenadi(rs.getString("yönetmenadı"));
                tmp.setSoyad(rs.getString("soyad"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }
    }




