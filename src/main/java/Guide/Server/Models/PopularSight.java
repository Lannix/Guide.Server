package Guide.Server.Models;

import javax.persistence.*;

@Entity
@Table(name = "popular_sights")
public class PopularSight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "popular_sight_id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "sight_id")
    private Sight popularSight;

    public PopularSight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sight getPopularSight() {
        return popularSight;
    }

    public void setPopularSight(Sight popularSight) {
        this.popularSight = popularSight;
    }
}
