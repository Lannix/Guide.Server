package Guide.Server.Model;

import Guide.Server.Model.Enum.PriceCategory;
import Guide.Server.Model.Enum.SightCategory;
import Guide.Server.Model.Enum.TypeOfSight;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "sights")
@Getter
@Setter
@ToString
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sight_id", updatable = false, nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "historyOfWatches")
    private Collection<User> watches;

    @ManyToMany(mappedBy = "favouriteSights")
    private Collection<User> likes;

    @OneToMany(mappedBy = "commentSight", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "ratingSight", fetch = FetchType.LAZY)
    private Collection<Comment> rating;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "coordinates", nullable = false)
    @ElementCollection
    private ArrayList<Double> coordinates;

    @Column(name = "type_of_sight")
    @Enumerated(EnumType.STRING)
    private TypeOfSight typeOfSight;

    @Column(name = "images_paths")
    @ElementCollection
    private ArrayList<String> imagesPaths;

    @Column(name = "map_image_path")
    private String mapImagePath;

    @Column(name = "price_category")
    @Enumerated(EnumType.STRING)
    private PriceCategory priceCategory;

    @Column(name = "price")
    private String price;

    @Column(name = "sight_category")
    @Enumerated(EnumType.STRING)
    private SightCategory sightCategory;

    @Column(name = "city", nullable = false)
    private String city;
}
