/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SinemaSalonu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onur
 */
public class SinemaSalonuDAO extends DAO {

    public List<SinemaSalonu> hepsiniOku(int page, int pageSize) {
        List<SinemaSalonu> yList = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from sinemasalonları order by sinemasalonu_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SinemaSalonu tmp = new SinemaSalonu();
                tmp.setSinemasalonu_id(rs.getLong("sinemasalonu_id"));
                tmp.setSalon_adı(rs.getString("salon_adı"));
                tmp.setŞehir(rs.getString("şehir"));
                yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(sinemasalonu_id) as sinemasalonu_count from sinemasalonları");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("sinemasalonu_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public SinemaSalonu find(Long id) {
        SinemaSalonu ss = null;
        String query = ("select * from sinemasalonları where sinemasalonu_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            ss = new SinemaSalonu();
            ss.setSinemasalonu_id(rs.getLong("sinemasalonu_id"));
            ss.setSalon_adı(rs.getString("salon_adı"));
            ss.setŞehir(rs.getString("şehir"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ss;

    }

    public void ekle(SinemaSalonu sinemasalonu) {
        String query = "insert into sinemasalonları(sinemasalonu_id,salon_adı,şehir) values(default,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sinemasalonu.getSalon_adı());
            pst.setString(2, sinemasalonu.getŞehir());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(SinemaSalonu sinemasalonu) {
        String query = "delete from sinemasalonları where sinemasalonu_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setLong(1, sinemasalonu.getSinemasalonu_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(SinemaSalonu sinemasalonu) {
        String query = "update sinemasalonları set salon_adı=?,şehir=? where sinemasalonu_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, sinemasalonu.getSalon_adı());
            pst.setString(2, sinemasalonu.getŞehir());
            pst.setLong(3, sinemasalonu.getSinemasalonu_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<SinemaSalonu> hepsiniOku() {
        List<SinemaSalonu> yList = new ArrayList<>();
        

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from sinemasalonları order by sinemasalonu_id asc ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                SinemaSalonu tmp = new SinemaSalonu();
                tmp.setSinemasalonu_id(rs.getLong("sinemasalonu_id"));
                tmp.setSalon_adı(rs.getString("salon_adı"));
                tmp.setŞehir(rs.getString("şehir"));
                yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;
    }
}
