/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tür;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ozan
 */
public class TürDAO extends DAO {

       public List<Tür> hepsiniOku(int page,int pageSize) {
        List<Tür> Tlist = new ArrayList<>();
        int start=(page-1)*pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from tür order by tür_id asc limit "+start+" , "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tür tmp = new Tür();
                tmp.setTür_id(rs.getLong("tür_id"));
                tmp.setTüradı(rs.getString("türadı"));                
                Tlist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Tlist;
    }
        public int  count() {
        int count=0; 
        

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(tür_id) as tür_count from tür");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("tür_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void ekle(Tür Tür) {
        String query = "insert into tür(tür_id,türadı) values(default,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, Tür.getTüradı());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Tür Tür) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from tür where tür_id=?");
            pst.setLong(1, Tür.getTür_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Tür Tür) {
        String query = "update tür set türadı=? where tür_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, Tür.getTüradı());
            pst.setLong(2, Tür.getTür_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Tür> getFilmTür(Long film_id) {
         List<Tür> filmTür = new ArrayList<>();
      
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from film_tür where film_id=?");
            pst.setLong(1, film_id);
             ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                filmTür.add(this.find(rs.getLong("tür_id")));
            }         
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         return filmTür;
    }
    public Tür find(Long id){
        Tür t=null;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from tür where tür_id="+id);
             ResultSet rs = pst.executeQuery();
            rs.next();
            
            t=new Tür();
            t.setTür_id(rs.getLong("tür_id"));
            t.setTüradı(rs.getString("türadı"));            
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    public List<Tür> hepsiniOku() {
    List<Tür> Tülist = new ArrayList<>();
       

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from tür ");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tür tmp = new Tür();
                tmp.setTür_id(rs.getLong("tür_id"));
                tmp.setTüradı(rs.getString("türadı"));                
                Tülist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Tülist;
    }    }


