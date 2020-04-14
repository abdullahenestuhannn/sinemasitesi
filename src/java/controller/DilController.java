/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DilDAO;
import entity.Filmler;
import entity.Dil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author Ozan
 */
@Named
@SessionScoped
public class DilController implements Serializable{

 private List<Dil> dlist;
 private DilDAO ddao;
 private Dil dil;

 private int page=1;
    private int pageSize=6;
    private int pageCount;

    public void ileri(){
        if (this.page ==this.getPageCount()) 
            this.page=1;
        else
        this.page++;
    }
    public void geri(){
        if (this.page==1) 
            this.page=this.getPageCount();
        else
        this.page--;
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
        this.pageCount=(int)Math.ceil(this.getYdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public DilController() {
    }

    public DilController(List<Dil> dlist, DilDAO ddao) {
        this.dlist = dlist;
        this.ddao = ddao;        
    }
    public void guncelleForm(Dil oyun) {
        this.dil=oyun;
    }
    public void silBilgi(Dil oyun){
       this.dil=oyun;
    }

    public void clearForm() {
        this.dil = new Dil();

    }

    public void guncelle() {
        this.getYdao().guncelle(this.dil);
         this.dil = new Dil();
    }

    public void sil() {
        this.getYdao().sil(this.dil);
        this.dil=new Dil();

    }

    public void create() {
        this.getYdao().ekle(this.dil);
         this.dil = new Dil();
    }

    public List<Dil> getYylist() {
        this.dlist = getYdao().hepsiniOku(page,pageSize);
        return dlist;
    }

    public void setYylist(List<Dil> dlist) {
        this.dlist = dlist;
    }

    public DilDAO getYdao() {
        if (this.ddao == null){ 
            this.ddao = new DilDAO();
    }
        return ddao;}

    public void setYdao(DilDAO ddao) {
        this.ddao = ddao;
    }

    public Dil getDil() {
        if (this.dil == null) {
            this.dil = new Dil();
        }
        return dil;
    }

    public void setDil(Dil dil) {
        this.dil = dil;
    }
}