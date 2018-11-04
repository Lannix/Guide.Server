package Guide.Server.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "popular_sights")
@Getter
@Setter
@ToString
public class PopularSight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "popular_sight_id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "sight_id")
    private Sight popularSight;
}