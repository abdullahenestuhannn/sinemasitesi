/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ÜyeDAO;
import entity.Üye;
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
public class ÜyeController implements Serializable{
 
 private List<Üye> ülist;
 private ÜyeDAO üdao;
 private Üye üye;
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
        this.pageCount=(int)Math.ceil(this.getÜdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ÜyeController() {
    }

    public ÜyeController(List<Üye> ülist, ÜyeDAO üdao) {
        this.ülist = ülist;
        this.üdao = üdao;        
    }
    public void guncelleForm(Üye üye) {
        this.üye=üye;
    }
    public void silBilgi(Üye üye){
       this.üye=üye;
    }

    public void clearForm() {
        this.üye = new Üye();

    }

    public void guncelle() {
        this.getÜdao().guncelle(this.üye);
         this.üye = new Üye();
    }

    public void sil() {
        this.getÜdao().sil(this.üye);
        this.üye=new Üye();

    }

    public void create() {
        this.getÜdao().ekle(this.üye);
         this.üye = new Üye();
    }

    public List<Üye> getÜlist() {
        this.ülist = getÜdao().hepsiniOku(page,pageSize);
        return ülist;
    }

    public void setÜlist(List<Üye> ülist) {
        this.ülist = ülist;
    }

    public ÜyeDAO getÜdao() {
        if (this.üdao == null){ 
            this.üdao = new ÜyeDAO();
    }
        return üdao;}

    public void setÜdao(ÜyeDAO üdao) {
        this.üdao = üdao;
    }

    public Üye getÜye() {
        if (this.üye == null) {
            this.üye = new Üye();
        }
        return üye;
    }

    public void setÜye(Üye üye) {
        this.üye = üye;
    }
}
