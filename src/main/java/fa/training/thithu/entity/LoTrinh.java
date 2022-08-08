package fa.training.thithu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder.LambdaInstrumentationStrategy;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOTRINH")
public class LoTrinh {
    @Id
    @Column(name = "MaLT")
    private String maLT;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "GiaVe")
    private int giaVe;

    @OneToMany(mappedBy = "loTrinh", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DangKyVe> dangKyVes = new ArrayList<>();

    public LoTrinh(String maLT, String moTa, int giaVe) {
        this.maLT = maLT;
        this.moTa = moTa;
        this.giaVe = giaVe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LoTrinh)) {
            return false;
        }
        LoTrinh loTrinh = (LoTrinh) o;
        return Objects.equals(maLT, loTrinh.maLT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLT);
    }
}
