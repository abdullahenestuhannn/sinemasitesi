/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.YonetmenDAO;
import entity.Filmler;
import entity.Yonetmen;
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
public class YonetmenController implements Serializable{
 
 private List<Yonetmen> ylist;
 private YonetmenDAO ydao;
 private Yonetmen yonetmen;
 
private int page=1;
    private int pageSize=5;
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
    
    public YonetmenController() {
    }

    public YonetmenController(List<Yonetmen> ylist, YonetmenDAO ydao) {
        this.ylist = ylist;
        this.ydao = ydao;        
    }
    public void guncelleForm(Yonetmen yonet) {
        this.yonetmen=yonet;
    }
    public void silBilgi(Yonetmen yonet){
       this.yonetmen=yonet;
    }

    public void clearForm() {
        this.yonetmen = new Yonetmen();

    }

    public void guncelle() {
        this.getYdao().guncelle(this.yonetmen);
         this.yonetmen = new Yonetmen();
    }

    public void sil() {
        this.getYdao().sil(this.yonetmen);
        this.yonetmen=new Yonetmen();

    }

    public void create() {
        this.getYdao().ekle(this.yonetmen);
         this.yonetmen = new Yonetmen();
    }

    public List<Yonetmen> getYlist() {
        this.ylist = getYdao().findall(page,pageSize);
        return ylist;
    }

    public void setYlist(List<Yonetmen> ylist) {
        this.ylist = ylist;
    }

    public YonetmenDAO getYdao() {
        if (this.ydao == null){ 
            this.ydao = new YonetmenDAO();
    }
        return ydao;}

    public void setOdao(YonetmenDAO ydao) {
        this.ydao = ydao;
    }

    public Yonetmen getYonetmen() {
        if (this.yonetmen == null) {
            this.yonetmen = new Yonetmen();
        }
        return yonetmen;
    }

    public void setYonetmen(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;
    }
    
}
