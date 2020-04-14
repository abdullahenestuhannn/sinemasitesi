/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TürDAO;
import entity.Filmler;
import entity.Tür;
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
public class TürController implements Serializable{
 
 private List<Tür> tlist;
 private TürDAO tdao;
 private Tür tür;
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
        this.pageCount=(int)Math.ceil(this.getTdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public TürController() {
    }

    public TürController(List<Tür> tlist, TürDAO tdao) {
        this.tlist = tlist;
        this.tdao = tdao;        
    }
    public void guncelleForm(Tür tür) {
        this.tür=tür;
    }
    public void silBilgi(Tür tür){
       this.tür=tür;
    }

    public void clearForm() {
        this.tür = new Tür();

    }

    public void guncelle() {
        this.getTdao().guncelle(this.tür);
         this.tür = new Tür();
    }

    public void sil() {
        this.getTdao().sil(this.tür);
        this.tür=new Tür();

    }

    public void create() {
        this.getTdao().ekle(this.tür);
         this.tür = new Tür();
    }

    public List<Tür> getTlist() {
        this.tlist = getTdao().hepsiniOku(page,pageSize);
        return tlist;
    }
    public List<Tür> getTülist() {
        this.tlist = getTdao().hepsiniOku();
        return tlist;
    }

    public void setTlist(List<Tür> tlist) {
        this.tlist = tlist;
    }

    public TürDAO getTdao() {
        if (this.tdao == null){ 
            this.tdao = new TürDAO();
    }
        return tdao;}

    public void setTdao(TürDAO tdao) {
        this.tdao = tdao;
    }

    public Tür getTür() {
        if (this.tür == null) {
            this.tür = new Tür();
        }
        return tür;
    }

    public void setTür(Tür tür) {
        this.tür = tür;
    }
}
