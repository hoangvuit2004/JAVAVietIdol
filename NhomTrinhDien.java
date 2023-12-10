import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class NhomTrinhDien   {
    private String loaiNhom;
    private String tenBaiHat;
    private String tenBienDao;
    private int diemNhom;
    private Chi_Dep nhomTruong;
    private LinkedList<Chi_Dep> dsThanhVien;
    private HashMap<Chi_Dep,Integer> phieuBauThanhVien;
    private String trangThaiNhom;

    public NhomTrinhDien(String loaiNhom, String tenBaiHat, String tenBienDao) {
        this.loaiNhom = loaiNhom;
        this.tenBaiHat = tenBaiHat;
        this.tenBienDao = tenBienDao;
        this.diemNhom = 0;
        this.nhomTruong = null;
        this.dsThanhVien = new LinkedList<>();
        this.phieuBauThanhVien = new HashMap<>();
        this.trangThaiNhom = "Chưa tổ chức";
    }
    public void setNhomTruong(Chi_Dep nhomTruong) {
        this.nhomTruong = nhomTruong;
        themThanhVien(nhomTruong);
    }

    public void themThanhVien(Chi_Dep thanhVien) {
        dsThanhVien.add(thanhVien);
    }

    public void setPhieuBauThanhVien(Chi_Dep chiDep, int soLuongPhieu) {
        phieuBauThanhVien.put(chiDep, soLuongPhieu);
    }
    public void capNhatDiemNhom() {
        for (Integer soLuongPhieu : phieuBauThanhVien.values()) {
            diemNhom += soLuongPhieu;
        }
    }

    public LinkedList<Chi_Dep> getDsThanhVien() {
        return dsThanhVien;
    }

    public void setDsThanhVien(LinkedList<Chi_Dep> dsThanhVien) {
        this.dsThanhVien = dsThanhVien;
    }

    public int getDiemNhom() {
        return diemNhom;
    }

    public void setDiemNhom(int diemNhom) {
        this.diemNhom = diemNhom;
    }

    public HashMap<Chi_Dep, Integer> getPhieuBauThanhVien() {
        return phieuBauThanhVien;
    }

    public static void main(String[] args) {
        NhomTrinhDien nhomTrinhDien = new NhomTrinhDien("Nhóm Trình Diễn", "Bài Hát A", "Biên Đạo A");

        Chi_Dep nhomTruong = new Chi_Dep("001", "Vu Anh Viet", new TreeSet<>(), new LinkedList<>(), false, "");
        nhomTrinhDien.setNhomTruong(nhomTruong);
        Chi_Dep thanhVien1 = new Chi_Dep("002", "Nguyen Bui Hoang Vu", new TreeSet<>(), new LinkedList<>(), false, "");
        nhomTrinhDien.themThanhVien(thanhVien1);
        nhomTrinhDien.setPhieuBauThanhVien(thanhVien1, 501);

        nhomTrinhDien.setPhieuBauThanhVien(nhomTruong, 51);

        System.out.println("Thông tin Nhóm Trình Diễn:");
        System.out.println("Loại Nhóm: " + nhomTrinhDien.loaiNhom);
        System.out.println("Tên Bài Hát: " + nhomTrinhDien.tenBaiHat);
        System.out.println("Tên Biên Đạo: " + nhomTrinhDien.tenBienDao);
        System.out.println("Điểm Nhóm: " + nhomTrinhDien.diemNhom);
        System.out.println("Đội Trưởng: " + nhomTrinhDien.nhomTruong.getHoTen());
        // Test Danh Sach Sinh Vien
        System.out.println("Danh Sách Thành Viên:");
        for (Chi_Dep thanhVien : nhomTrinhDien.dsThanhVien) {
            System.out.println("- " + thanhVien.getHoTen());
        }
        // Test Phieu Bau
        System.out.println("Danh Sách Phiếu Bầu Thành Viên:");
        for (Chi_Dep thanhVien : nhomTrinhDien.phieuBauThanhVien.keySet())
            System.out.println("- "  + thanhVien.getHoTen() +  ": " + nhomTrinhDien.phieuBauThanhVien.get(thanhVien));
        // Test Diem Nhom
        nhomTrinhDien.capNhatDiemNhom();
        System.out.println(nhomTrinhDien.diemNhom);
    }

    }

