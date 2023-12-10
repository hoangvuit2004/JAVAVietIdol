import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class CuocThi {
    public ArrayList<Chi_Dep> dsChiDep;
    public ArrayList<VongThi> VongThi;
    public String tenCuocThi;
    public int namToChuc;

    public CuocThi(ArrayList<Chi_Dep> dsChiDep, ArrayList<VongThi> vongThi, String tenCuocThi, int namToChuc) {
        this.dsChiDep = dsChiDep;
        VongThi = vongThi;
        this.tenCuocThi = tenCuocThi;
        this.namToChuc = namToChuc;
    }



    public void themVongThi(VongThi v){
        VongThi.add(v);
    }
    public void themChiDep(VongThi v, Chi_Dep a){
        if(VongThi.contains(v)){
            dsChiDep.add(a);
        }
    }
    public HashMap thongKeChiDepBiLoai(){
        HashMap<Chi_Dep, String> chiDepBiLoai = new HashMap<>();

        for (Chi_Dep chiDep : dsChiDep) {
            if (chiDep.isBiLoai()) {
                chiDepBiLoai.put(chiDep, chiDep.getTenVongBiLoai());
            }
        }

        return chiDepBiLoai;
    }
    public TreeSet<Chi_Dep> getSetChiDepVongThi(VongThi v) {
        TreeSet<Chi_Dep> setChiDep = new TreeSet<>(new Comparator<Chi_Dep>() {
            @Override
            public int compare(Chi_Dep chiDep1, Chi_Dep chiDep2) {

                int diem1 = layDiemVongThi(chiDep1, v);

                int diem2 = layDiemVongThi(chiDep2, v);


                return Integer.compare(diem2, diem1);
            }
        });

        setChiDep.addAll(dsChiDep);

        return setChiDep;
    }

    private int layDiemVongThi(Chi_Dep chiDep,VongThi vongThi) {

        return chiDep.getDiemVongThi();
    }
    public TreeSet<Chi_Dep> getSetTongDiemChiDep() {
        TreeSet<Chi_Dep> setChiDep = new TreeSet<>(Comparator.comparingInt(this::layTongDiem).reversed());

        setChiDep.addAll(dsChiDep);

        return setChiDep;
    }

    private int layTongDiem(Chi_Dep chiDep) {

        return chiDep.getDiemVongThi();
    }
    public HashMap thongKeCHiDep_danhSachDiemSo() {
        HashMap<Chi_Dep, Integer> chiDepDiemSo = new HashMap<>();

        for (Chi_Dep chiDep : dsChiDep) {
            // Thêm logic tính tổng điểm của chiDep và thêm vào chiDepDiemSo
            // ...

            // Ví dụ: Sử dụng điểm quá trình làm nghề
            int tongDiem = 0;
            if (chiDep.getDiemQuaTrinh() != null) {
                for (int diem : chiDep.getDiemQuaTrinh()) {
                    tongDiem += diem;
                }
            }
            chiDepDiemSo.put(chiDep, tongDiem);
        }

        return chiDepDiemSo;
    }
}
