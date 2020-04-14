/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OyuncuDAO;
import entity.Filmler;
import entity.Oyuncu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author ABDULLAH
 */
@Named
@SessionScoped
public class OyuncuController implements Serializable{
 
 private List<Oyuncu> olist;
 private OyuncuDAO odao;
 private Oyuncu oyuncu;
  
    private int page=1;
    private int pageSize=6;
    private int pageCount;

    public void ileri(){
        if (this.page ==this.getPageCount()) 
            this.page=1;
        else
        this.page++;
        this.clearForm();
    }
    public void geri(){
        if (this.page==1) 
            this.page=this.getPageCount();
        else
        this.page--;
        this.clearForm();
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int)Math.ceil(this.getOdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public OyuncuController() {
    }

    public OyuncuController(List<Oyuncu> olist, OyuncuDAO odao) {
        this.olist = olist;
        this.odao = odao;        
    }
    public void guncelleForm(Oyuncu oyun) {
        this.oyuncu=oyun;
    }
    public void silBilgi(Oyuncu oyun){
       this.oyuncu=oyun;
    }

    public void clearForm() {
        this.oyuncu = new Oyuncu();

    }

    public void guncelle() {
        this.getOdao().guncelle(this.oyuncu);
         this.oyuncu = new Oyuncu();
    }

    public void sil() {
        this.getOdao().sil(this.oyuncu);
        this.oyuncu=new Oyuncu();

    }

    public void create() {
        this.getOdao().ekle(this.oyuncu);
         this.oyuncu = new Oyuncu();
    }

    public List<Oyuncu> getOlist() {
        this.olist = this.getOdao().hepsiniOku(page,pageSize);
        return olist;
    }
    public List<Oyuncu> getOylist() {
        this.olist = this.getOdao().hepsiniOku();
        return olist;
    }

    public void setOlist(List<Oyuncu> olist) {
        this.olist = olist;
    }

    public OyuncuDAO getOdao() {
        if (this.odao == null){ 
            this.odao = new OyuncuDAO();
    }
        return odao;}

    public void setOdao(OyuncuDAO odao) {
        this.odao = odao;
    }

    public Oyuncu getOyuncu() {
        if (this.oyuncu == null) {
            this.oyuncu = new Oyuncu();
        }
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }
}
