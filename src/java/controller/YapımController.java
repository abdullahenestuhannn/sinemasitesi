/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.YapımDAO;
import entity.Filmler;
import entity.Yapım;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author POLAT
 */
@Named
@SessionScoped
public class YapımController implements Serializable{
 
 private List<Yapım> yylist;
 private YapımDAO ydao;
 private Yapım yapım;
 
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
        this.pageCount=(int)Math.ceil(this.getYdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public YapımController() {
    }

    public YapımController(List<Yapım> yylist, YapımDAO ydao) {
        this.yylist = yylist;
        this.ydao = ydao;        
    }
    public void guncelleForm(Yapım oyun) {
        this.yapım=oyun;
    }
    public void silBilgi(Yapım oyun){
       this.yapım=oyun;
    }

    public void clearForm() {
        this.yapım = new Yapım();

    }

    public void guncelle() {
        this.getYdao().guncelle(this.yapım);
         this.yapım = new Yapım();
    }

    public void sil() {
        this.getYdao().sil(this.yapım);
        this.yapım=new Yapım();

    }

    public void create() {
        this.getYdao().ekle(this.yapım);
         this.yapım = new Yapım();
    }

    public List<Yapım> getYylist() {
        this.yylist = getYdao().hepsiniOku(page,pageSize);
        return yylist;
    }

    public void setYylist(List<Yapım> yylist) {
        this.yylist = yylist;
    }

    public YapımDAO getYdao() {
        if (this.ydao == null){ 
            this.ydao = new YapımDAO();
    }
        return ydao;}

    public void setYdao(YapımDAO ydao) {
        this.ydao = ydao;
    }

    public Yapım getYapım() {
        if (this.yapım == null) {
            this.yapım = new Yapım();
        }
        return yapım;
    }

    public void setYapım(Yapım yapım) {
        this.yapım = yapım;
    }
}
