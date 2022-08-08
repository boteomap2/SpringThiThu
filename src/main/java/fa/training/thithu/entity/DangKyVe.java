package fa.training.thithu.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DANGKYVE")
public class DangKyVe {
    @Id
    @GenericGenerator(name = "maDKGen", strategy = "fa.training.thithu.util.maDkGen")
    @GeneratedValue(generator = "maDKGen")
    @Column(name = "MaDK")
    private String maDK;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "GioiTinhs")
    private String gioiTinh;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "NgaySinh", columnDefinition = "date")
    private LocalDate ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "NgayKH", columnDefinition = "date")
    private LocalDate ngayKH;

    @Column(name = "SoLuongVe")
    private int soLuongVe;

    @Column(name = "TongTien")
    private int tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLT")
    private LoTrinh loTrinh;

    public DangKyVe(String maDK, String hoTen, String gioiTinh, LocalDate ngaySinh, String diaChi,
                    String soDienThoai, LocalDate ngayKH, int soLuongVe, int tongTien) {
        this.maDK = maDK;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngayKH = ngayKH;
        this.soLuongVe = soLuongVe;
        this.tongTien = tongTien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DangKyVe)) {
            return false;
        }
        DangKyVe dangKyVe = (DangKyVe) o;
        return Objects.equals(maDK, dangKyVe.maDK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDK);
    }
}
