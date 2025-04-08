package business.airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;
    @Column(name = "is_active", nullable = false)
    private boolean active;
    @Column(name ="city", nullable = false)
    private String city;
    @Column(name ="codename", nullable = false)
    private String codename;
    @Column(name ="name", nullable = false)
    private String name;
    @Column(name ="country_id", nullable = false)
    private Long countryId;
    @Version
    @Column(name = "version")
    private int version;
}
