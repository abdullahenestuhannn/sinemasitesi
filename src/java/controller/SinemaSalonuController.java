    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package controller;

    import dao.SinemaSalonuDAO;
    import entity.SinemaSalonu;
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
    public class SinemaSalonuController implements Serializable{

     private List<SinemaSalonu>slist;
     private SinemaSalonuDAO sdao;
     private SinemaSalonu sinemasalonu;
    
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
        this.pageCount=(int)Math.ceil(this.getSsdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
        public SinemaSalonuController() {
        }

        public SinemaSalonuController(List<SinemaSalonu> slist, SinemaSalonuDAO sdao) {
            this.slist = slist;
            this.sdao = sdao;        
        }
        public void guncelleForm(SinemaSalonu sinema) {
            this.sinemasalonu=sinema;
        }
        public void silBilgi(SinemaSalonu sinema){
           this.sinemasalonu=sinema;
        }

        public void clearForm() {
            this.sinemasalonu = new SinemaSalonu();

        }

        public void guncelle() {
            this.getSsdao().guncelle(this.sinemasalonu);
             this.sinemasalonu = new SinemaSalonu();
        }

        public void sil() {
            this.getSsdao().sil(this.sinemasalonu);
            this.sinemasalonu=new SinemaSalonu();

        }

        public void create() {
            this.getSsdao().ekle(this.sinemasalonu);
             this.sinemasalonu = new SinemaSalonu();
        }

        public List<SinemaSalonu> getSlist() {
            this.slist = getSsdao().hepsiniOku(page,pageSize);
            return slist;
        }

        public void setSlist(List<SinemaSalonu> slist) {
            this.slist = slist;
        }

        public SinemaSalonuDAO getSsdao() {
            if (this.sdao == null){ 
                this.sdao = new SinemaSalonuDAO();
        }
            return sdao;}

        public void setSsdao(SinemaSalonuDAO sdao) {
            this.sdao = sdao;
        }

        public SinemaSalonu getSinemaSalonu() {
            if (this.sinemasalonu == null) {
            this.sinemasalonu = new SinemaSalonu();
        }
            return sinemasalonu;
        }

        public void setSinemaSalonu(SinemaSalonu sinemasalonu) {
            this.sinemasalonu = sinemasalonu;
        }
        
    }
