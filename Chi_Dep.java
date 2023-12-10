import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Chi_Dep  {
    private String id;
    private String hoTen;
    private TreeSet<QuaTrinhLamNghe> ngheNgiepList;
    private LinkedList<Integer> diemQuaTrinh;
    private boolean biLoai;
    private String tenVongBiLoai;

    public Chi_Dep(String id, String hoTen, TreeSet<QuaTrinhLamNghe> ngheNgiepList, LinkedList<Integer> diemQuaTrinh, boolean biLoai, String tenVongBiLoai) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngheNgiepList = ngheNgiepList;
        this.diemQuaTrinh = diemQuaTrinh;
        this.biLoai = biLoai;
        this.tenVongBiLoai = tenVongBiLoai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public TreeSet<QuaTrinhLamNghe> getNgheNgiepList() {
        return ngheNgiepList;
    }

    public void setNgheNgiepList(TreeSet<QuaTrinhLamNghe> ngheNgiepList) {
        this.ngheNgiepList = ngheNgiepList;
    }

    public LinkedList<Integer> getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(LinkedList<Integer> diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public boolean isBiLoai() {
        return biLoai;
    }

    public void setBiLoai(boolean biLoai) {
        this.biLoai = biLoai;
    }

    public String getTenVongBiLoai() {
        return tenVongBiLoai;
    }

    public void setTenVongBiLoai(String tenVongBiLoai) {
        this.tenVongBiLoai = tenVongBiLoai;
    }

    public void themDiemQT(int diem){
        if (diemQuaTrinh == null) {
            diemQuaTrinh = new LinkedList<>();
        }
        diemQuaTrinh.add(diem);
    }
    public int getDiemVongThi(){
        int sum = 0;
        for (int a:
             diemQuaTrinh) {
            sum+=a;
        }
        return sum;
    }
    public void setBiLoai(){

    }
    public void printChiDepInfo() {
        System.out.println("ID: " + id);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Danh sách quá trình làm nghề:");
        for (QuaTrinhLamNghe quaTrinh : ngheNgiepList) {
            quaTrinh.printQuaTrinhLamNghe();
        }
    }
    public static void main(String[] args) {
        QuaTrinhLamNghe quaTrinh1 = new QuaTrinhLamNghe("100", "Nghe 1", 2010);
        QuaTrinhLamNghe quaTrinh2 = new QuaTrinhLamNghe("101", "Nghe 2", 2011);

        Chi_Dep chiDep = new Chi_Dep("001", "Vu Anh Viet", new TreeSet<>(), new LinkedList<>(), false, "");
        Chi_Dep chiDep1 = new Chi_Dep("002", "Nguyen Bui Hoang Vu", new TreeSet<>(), new LinkedList<>(), false, "");

        chiDep.getNgheNgiepList().add(quaTrinh1);
        chiDep.getNgheNgiepList().add(quaTrinh2);




        chiDep.themDiemQT(90);
        chiDep.themDiemQT(91);
        chiDep.printChiDepInfo();
        System.out.println(chiDep.getDiemQuaTrinh());
    }
}
