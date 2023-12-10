import java.util.*;

public class VongThi {
    private String idTV;
    private String tenVong;
    private ArrayList<NhomTrinhDien> dsNhomTrinhDien;
    private CachTinhDiem cachTinhDiemChiDep;

    public VongThi(String idTV, String tenVong, ArrayList<NhomTrinhDien> dsNhomTrinhDien, CachTinhDiem cachTinhDiemChiDep) {
        this.idTV = idTV;
        this.tenVong = tenVong;
        this.dsNhomTrinhDien = dsNhomTrinhDien;
        this.cachTinhDiemChiDep = cachTinhDiemChiDep;
    }
    public void loaiCHiDep(int slgNhom, int slgTvNhom){
        if (dsNhomTrinhDien.size() >= slgNhom) {
            Iterator<NhomTrinhDien> iterator = dsNhomTrinhDien.iterator();
            while (iterator.hasNext() && slgNhom > 0) {
                iterator.next();
                iterator.remove();
                slgNhom--;
            }
        }

        for (NhomTrinhDien nhom : dsNhomTrinhDien) {
            if (nhom.getDsThanhVien().size() >= slgTvNhom) {
                Iterator<Chi_Dep> iterator = nhom.getDsThanhVien().iterator();
                while (iterator.hasNext() && slgTvNhom > 0) {
                    iterator.next();
                    iterator.remove();
                    slgTvNhom--;
                }
            }
        }
    }
    public void themNhomTrinhDien(NhomTrinhDien nhomTrinhDien){
        dsNhomTrinhDien.add(nhomTrinhDien);
    }

    public void setNhomTruong(Chi_Dep cd, NhomTrinhDien n){
        if (dsNhomTrinhDien.contains(n)) {

            n.setNhomTruong(cd);

            n.themThanhVien(cd);
        } else {
            System.out.println("Nhóm không tồn tại trong danh sách.");
        }
    }

public void setThanhVien(Chi_Dep cd, NhomTrinhDien n){

}

    public ArrayList<NhomTrinhDien> getDsNhomTrinhDien() {
        return dsNhomTrinhDien;
    }

    public void setCachTinhDiem(CachTinhDiem cachTinhDiemChiDep) {
        this.cachTinhDiemChiDep = cachTinhDiemChiDep;
    }

    public CachTinhDiem getCachTinhDiemChiDep() {
        return cachTinhDiemChiDep;
    }

    public HashMap<Chi_Dep, Integer>  getDiemTVNhom(NhomTrinhDien n){
    HashMap<Chi_Dep, Integer> diemTVNhom = new HashMap<>();

    for (Chi_Dep chiDep : n.getDsThanhVien()) {
        int diemNhom = n.getDiemNhom();

        int diemBGK = (int) (diemNhom * cachTinhDiemChiDep.getPhamTramDiemBGK() / 100);
        int diemPhieuBau = (int) (diemNhom * cachTinhDiemChiDep.getPhanTramDiemPB() / 100);


        int tongDiem = diemBGK + diemPhieuBau;


        diemTVNhom.put(chiDep, tongDiem);
    }

    return diemTVNhom;

}
    public TreeSet sortNhomDiemSo(){
        return null;
    }

    public static void main(String[] args) {
        VongThi vongThi = new VongThi("001", "Vòng Thi A", new ArrayList<>(), new CachTinhDiem());


        NhomTrinhDien nhomTrinhDien = new NhomTrinhDien("Nhóm Trình Diễn", "Bài Hát A", "Biên Đạo A");


        Chi_Dep nhomTruong = new Chi_Dep("002", "Nguyen Bui Hoang Vu", new TreeSet<>(), new LinkedList<>(), false, "");

        nhomTrinhDien.setNhomTruong(nhomTruong);
        nhomTrinhDien.themThanhVien(nhomTruong);
  nhomTrinhDien.setPhieuBauThanhVien(nhomTruong,500);

        vongThi.getDsNhomTrinhDien().add(nhomTrinhDien);


        vongThi.setCachTinhDiem(new CachTinhDiem());


        HashMap<Chi_Dep, Integer> diemTVNhom = vongThi.getDiemTVNhom(nhomTrinhDien);


        int expectedDiem = 0;
        for (int diem : nhomTrinhDien.getPhieuBauThanhVien().values()) {
            expectedDiem += diem;
        }
        System.out.println(expectedDiem);

    }
}
