/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Dil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ozan
 */
public class DilDAO extends DAO {
       public List<Dil> hepsiniOku(int page,int pageSize) {
        List<Dil> dList = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from dil order by dil_id asc OFFSET "+start+" LIMIT "+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Dil tmp = new Dil();
                tmp.setDil_id(rs.getLong("dil_id"));
                tmp.setDiladı(rs.getString("diladı"));
                 dList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;


    }
        public int  count() {
        int count=0; 


        try {
            PreparedStatement pst = getConn().prepareStatement("select count(dil_id) as dil_count from dil");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("dil_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
     public Dil find(Long id){
        Dil ya=null;
         String query = ("select * from dil where dil_id=" + id);
         try {
            PreparedStatement pst = getConn().prepareStatement(query);
             ResultSet rs = pst.executeQuery();
             rs.next();

             ya=new Dil();
             ya.setDil_id(rs.getLong("dil_id"));            
            ya.setDiladı(rs.getString("diladı"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ya;

    }


    public void ekle(Dil dil) {
        String query = "insert into dil (dil_id,diladı) values(default,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, dil.getDiladı());            
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Dil dil) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from dil where dil_id=?");
            pst.setLong(1, dil.getDil_id());
            pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Dil dil) {
        String query = "update dil set diladı=? where dil_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, dil.getDiladı());           
            pst.setLong(2, dil.getDil_id());
            ResultSet rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Dil> hepsiniOku() {
     List<Dil> dList = new ArrayList<>();

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from dil order by dil_id asc");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Dil tmp = new Dil();
                tmp.setDil_id(rs.getLong("dil_id"));
                tmp.setDiladı(rs.getString("diladı"));
                 dList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;    }

}