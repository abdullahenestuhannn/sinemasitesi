package controller;

import dao.DilDAO;
import dao.FilmlerDAO;
import dao.OyuncuDAO;
import dao.SinemaSalonuDAO;
import dao.YapımDAO;
import dao.YonetmenDAO;
import entity.Filmler;
import entity.Oyuncu;
import entity.SinemaSalonu;
import entity.Tür;
import entity.Yapım;
import entity.Dil;
import entity.Yonetmen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FilmlerController implements Serializable {

    @Inject
    private TürController türController;
    @Inject
    private OyuncuController oyuncuController;
    
    private List<Oyuncu> olist;    
    private List<Filmler> flist;
    private List<Yonetmen> yönetmenList;
    private List<Yapım> yapımList;
    private List<Dil> dList;
    private List<SinemaSalonu> sinemaSalonuList;
    private FilmlerDAO fdao;
    
    private OyuncuDAO oyuncuDAO;
    private YonetmenDAO yonetmenDAO;
    private YapımDAO yapımDAO;
    private DilDAO dilDAO;
    private SinemaSalonuDAO sinemaSalonuDAO;
    private Filmler filmler;
    private List<Tür> türList;
    
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
        this.pageCount=(int)Math.ceil(this.getFdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public FilmlerController(TürController türController, OyuncuController oyuncuController, List<Oyuncu> olist, List<Filmler> flist, List<Yonetmen> yönetmenList, List<Yapım> yapımList, List<Dil> dList, List<SinemaSalonu> sinemaSalonuList, FilmlerDAO fdao, OyuncuDAO oyuncuDAO, YonetmenDAO yonetmenDAO, YapımDAO yapımDAO, DilDAO dilDAO, SinemaSalonuDAO sinemaSalonuDAO, Filmler filmler, List<Tür> türList, int pageCount) {
        this.türController = türController;
        this.oyuncuController = oyuncuController;
        this.olist = olist;
        this.flist = flist;
        this.yönetmenList = yönetmenList;
        this.yapımList = yapımList;
        this.dList = dList;
        this.sinemaSalonuList = sinemaSalonuList;
        this.fdao = fdao;
        this.oyuncuDAO = oyuncuDAO;
        this.yonetmenDAO = yonetmenDAO;
        this.yapımDAO = yapımDAO;
        this.dilDAO = dilDAO;
        this.sinemaSalonuDAO = sinemaSalonuDAO;
        this.filmler = filmler;
        this.türList = türList;
        this.pageCount = pageCount;
    }

    
   
    public FilmlerController() {
    }

    public void guncelleForm(Filmler film) {
        this.filmler = film;

    }

    public void silBilgi(Filmler film) {
        this.filmler = film;
    }

    public void clearForm() {
        this.filmler = new Filmler();

    }

    public void guncelle() {
        this.getFdao().guncelle(this.filmler);
        this.clearForm();
    }

    public void sil() {
        this.getFdao().sil(this.filmler);
        this.filmler = new Filmler();

    }

    public void create() {
        this.getFdao().ekle(this.filmler);
        this.filmler = new Filmler();

    }

    public Filmler getFilmler() {
        if (this.filmler == null) {
            this.filmler = new Filmler();
        }

        return filmler;
    }

    public void setFilmler(Filmler filmler) {
        this.filmler = filmler;
    }

    public FilmlerController(List<Filmler> flist, FilmlerDAO fdao) {
        this.flist = flist;
        this.fdao = fdao;
    }

    public List<Filmler> getFlist() {
        this.flist = this.getFdao().hepsiniOku(page,pageSize);
        return flist;
    }

    public void setFlist(List<Filmler> flist) {
        this.flist = flist;
    }

    public FilmlerDAO getFdao() {
        if (this.fdao == null) {
            this.fdao = new FilmlerDAO();
        }

        return fdao;
    }

    public void setFdao(FilmlerDAO fdao) {
        this.fdao = fdao;
    }

 

    public YonetmenDAO getYonetmenDAO() {
        if (this.yonetmenDAO == null) {
            this.yonetmenDAO = new YonetmenDAO();
        }
        return yonetmenDAO;
    }

    public List<Tür> getTürList() {
        return türList;
    }

    public void setTürList(List<Tür> türList) {
        this.türList = türList;
    }

    public List<Yonetmen> getYönetmenList() {       
        this.yönetmenList=this.getYonetmenDAO().findall();
        return yönetmenList;
    }

    public void setYönetmenList(List<Yonetmen> yönetmenList) {
        this.yönetmenList = yönetmenList;
    }



    public TürController getTürController() {
        return türController;
    }

    public void setTürController(TürController türController) {
        this.türController = türController;
    }

    public OyuncuController getOyuncuController() {
        return oyuncuController;
    }

    public void setOyuncuController(OyuncuController oyuncuController) {
        this.oyuncuController = oyuncuController;
    }
    

    public List<Yapım> getYapımList() {
        this.yapımList=this.getYapımDAO().hepsiniOku();
        return yapımList;
    }

    public void setYapımList(List<Yapım> yapımList) {
        this.yapımList = yapımList;
    }

    public YapımDAO getYapımDAO() {
        if (this.yapımDAO == null) {
            this.yapımDAO = new YapımDAO();
        }
        return yapımDAO;
    }
      public List<Dil> getDilList() {
        this.dList=this.getDilDAO().hepsiniOku();
        return dList;
    }

    public void setDilList(List<Dil> dList) {
        this.dList = dList;
    }

    public DilDAO getDilDAO() {
        if (this.dilDAO == null) {
            this.dilDAO = new DilDAO();
        }
        return dilDAO;
    }

    public List<SinemaSalonu> getSinemaSalonuList() {
        this.sinemaSalonuList=this.getSinemaSalonuDAO().hepsiniOku();
        return sinemaSalonuList;
    }

    public void setSinemaSalonuList(List<SinemaSalonu> sinemaSalonuList) {
        this.sinemaSalonuList = sinemaSalonuList;
    }

    public SinemaSalonuDAO getSinemaSalonuDAO() {
         if (this.sinemaSalonuDAO == null) {
            this.sinemaSalonuDAO = new SinemaSalonuDAO();
        }
        return sinemaSalonuDAO;
    }

    public List<Oyuncu> getOlist() {
        return olist;
    }

    public void setOlist(List<Oyuncu> olist) {
        this.olist = olist;
    }

    

    public OyuncuDAO getOyuncuDAO() {
        if (this.oyuncuDAO == null) {
            this.oyuncuDAO = new OyuncuDAO();
        
    }
        return oyuncuDAO;

}
}
