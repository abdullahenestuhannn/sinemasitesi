/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Vizyona_GeleceklerDAO;
import entity.Vizyona_Gelecekler;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author Onur
 */
@Named
@SessionScoped
public class Vizyona_GeleceklerController implements Serializable{
 
 private List<Vizyona_Gelecekler>vglist;
 private Vizyona_GeleceklerDAO vgdao;
 private Vizyona_Gelecekler vizyonagelecekler;
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
        this.pageCount=(int)Math.ceil(this.getVgdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Vizyona_GeleceklerController() {
    }

    public Vizyona_GeleceklerController(List<Vizyona_Gelecekler> vglist, Vizyona_GeleceklerDAO vgdao) {
        this.vglist = vglist;
        this.vgdao = vgdao;        
    }
    public void guncelleForm(Vizyona_Gelecekler vizyonagelecekler) {
        this.vizyonagelecekler=vizyonagelecekler;
    }
    public void silBilgi(Vizyona_Gelecekler vizyonagelecekler){
       this.vizyonagelecekler=vizyonagelecekler;
    }

    public void clearForm() {
        this.vizyonagelecekler = new Vizyona_Gelecekler();

    }

    public void guncelle() {
        this.getVgdao().guncelle(this.vizyonagelecekler);
         this.vizyonagelecekler = new Vizyona_Gelecekler();
    }

    public void sil() {
        this.getVgdao().sil(this.vizyonagelecekler);
        this.vizyonagelecekler=new Vizyona_Gelecekler();

    }

    public void create() {
        this.getVgdao().ekle(this.vizyonagelecekler);
         this.vizyonagelecekler = new Vizyona_Gelecekler();
    }

    public List<Vizyona_Gelecekler> getVglist() {
        this.vglist = getVgdao().hepsiniOku(page,pageSize);
        return vglist;
    }

    public void setVglist(List<Vizyona_Gelecekler> vglist) {
        this.vglist = vglist;
    }

    public Vizyona_GeleceklerDAO getVgdao() {
        if (this.vgdao == null){ 
            this.vgdao = new Vizyona_GeleceklerDAO();
    }
        return vgdao;}

    public void setVgdao(Vizyona_GeleceklerDAO vgdao) {
        this.vgdao = vgdao;
    }

    public Vizyona_Gelecekler getVizyona_Gelecekler() {
        if (this.vizyonagelecekler == null) {
            this.vizyonagelecekler = new Vizyona_Gelecekler();
        }
        return vizyonagelecekler;
    }

    public void setVizyona_Gelecekler(Vizyona_Gelecekler vizyonagelecekler) {
        this.vizyonagelecekler = vizyonagelecekler;
    }
}
