/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yapım;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author POLAT
 */
public class YapımDAO extends DAO {
       public List<Yapım> hepsiniOku(int page,int pageSize) {
        List<Yapım> yList = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from yapım order by yapım_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yapım tmp = new Yapım();
                tmp.setYapım_id(rs.getLong("yapım_id"));
                tmp.setÜlkesi(rs.getString("ülkesi"));
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
            PreparedStatement pst = getConn().prepareStatement("select count(yapım_id) as yapım_count from yapım");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("yapım_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
     public Yapım find(Long id){
        Yapım ya=null;
         String query = ("select * from yapım where yapım_id=" + id);
         try {
            PreparedStatement pst = getConn().prepareStatement(query);
             ResultSet rs = pst.executeQuery();
             rs.next();
             
             ya=new Yapım();
             ya.setYapım_id(rs.getLong("yapım_id"));            
            ya.setÜlkesi(rs.getString("ülkesi"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ya;
        
    }


    public void ekle(Yapım yapım) {
        String query = "insert into yapım (yapım_id,ülkesi) values(default,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yapım.getÜlkesi());            
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Yapım yapım) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from yapım where yapım_id=?");
            pst.setLong(1, yapım.getYapım_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Yapım yapım) {
        String query = "update yapım set ülkesi=? where yapım_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, yapım.getÜlkesi());           
            pst.setLong(2, yapım.getYapım_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Yapım> hepsiniOku() {
     List<Yapım> yList = new ArrayList<>();
        
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from yapım order by yapım_id asc");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Yapım tmp = new Yapım();
                tmp.setYapım_id(rs.getLong("yapım_id"));
                tmp.setÜlkesi(rs.getString("ülkesi"));
                 yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;    }

}
