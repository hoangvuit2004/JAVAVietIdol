public class QuaTrinhLamNghe implements  Comparable<QuaTrinhLamNghe> {
    private String maNN;
    private String tenNN;
    private int namBD;

    public QuaTrinhLamNghe(String maNN, String tenNN, int namBD) {
        this.maNN = maNN;
        this.tenNN = tenNN;
        this.namBD = namBD;
    }

    public int getNamLamNghe() {
        return namBD;
    }
    public String getMaNN() {
        return maNN;
    }

    public void setMaNN(String maNN) {
        this.maNN = maNN;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public int getNamBD() {
        return namBD;
    }

    public void setNamBD(int namBD) {
        this.namBD = namBD;
    }
    public void printQuaTrinhLamNghe() {
        System.out.println("Mã nghề nghiệp: " + maNN);
        System.out.println("Tên nghề nghiệp: " + tenNN);
        System.out.println("Năm bắt đầu làm nghề: " + namBD);
    }

    @Override
    public int compareTo(QuaTrinhLamNghe o) {
        return Integer.compare(this.namBD, o.namBD);
    }
}
