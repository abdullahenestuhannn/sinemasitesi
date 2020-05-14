/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Üye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABDULLAH
 */
public class ÜyeDAO extends DAO {

    public List<Üye> hepsiniOku(int page, int pageSize) {
        List<Üye> ülist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from üye order by üye_id asc limit " + start + " , " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Üye tmp = new Üye();
                tmp.setÜye_id(rs.getLong("üye_id"));
                tmp.setAdı(rs.getString("adı"));
                tmp.setSoyadı(rs.getString("soyad"));
                tmp.setEmail(rs.getString("email"));
                tmp.setSifre(rs.getString("sifre"));
               
                ülist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ülist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(üye_id) as üye_count from üye");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("üye_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void ekle(Üye Üye) {
        String query = "insert into üye(üye_id,adı,soyad,email,sifre,admin) values(default,?,?,?,?,0)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, Üye.getAdı());
            pst.setString(2, Üye.getSoyadı());
            pst.setString(3, Üye.getEmail());
            pst.setString(4, Üye.getSifre());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Üye Üye) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from üye where üye_id=?");
            pst.setLong(1, Üye.getÜye_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Üye Üye) {
        String query = "update üye set adı=?,soyad=?,email=?,sifre=? where üye_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, Üye.getAdı());
            pst.setString(2, Üye.getSoyadı());
            pst.setString(3, Üye.getEmail());
            pst.setString(4, Üye.getSifre());
            pst.setLong(5, Üye.getÜye_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Üye girisYap(String email,String sifre) {
        Üye tmp = null;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from üye where email = ? and sifre = ?");
            pst.setString(1, email);
            pst.setString(2, sifre);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                tmp = new Üye();
                tmp.setÜye_id(rs.getLong("üye_id"));
                tmp.setAdı(rs.getString("adı"));
                tmp.setSoyadı(rs.getString("soyad"));
                tmp.setEmail(rs.getString("email"));
                tmp.setSifre(rs.getString("sifre"));
                tmp.setAdmin(rs.getBoolean("admin"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

}
