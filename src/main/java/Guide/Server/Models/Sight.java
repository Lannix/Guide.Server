package Guide.Server.Models;

import Guide.Server.Models.enums.PriceCategory;
import Guide.Server.Models.enums.SightCategory;
import Guide.Server.Models.enums.TypeOfSight;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "sights")
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sight_id", updatable = false, nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "historyOfWatches")
    private Collection<User> watches;

    @ManyToMany(mappedBy = "favouriteSights")
    private Collection<User> likes;

    @OneToMany(mappedBy = "sight", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

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

    public Sight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<User> getWatches() {
        return watches;
    }

    public void setWatches(Collection<User> watches) {
        this.watches = watches;
    }

    public Collection<User> getLikes() {
        return likes;
    }

    public void setLikes(Collection<User> likes) {
        this.likes = likes;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<String> getImagesPaths() {
        return imagesPaths;
    }

    public void setImagesPaths(ArrayList<String> imagesPaths) {
        this.imagesPaths = imagesPaths;
    }

    public String getMapImagePath() {
        return mapImagePath;
    }

    public void setMapImagePath(String mapImagePath) {
        this.mapImagePath = mapImagePath;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public TypeOfSight getTypeOfSight() {
        return typeOfSight;
    }

    public void setTypeOfSight(TypeOfSight typeOfSight) {
        this.typeOfSight = typeOfSight;
    }

    public SightCategory getSightCategory() {
        return sightCategory;
    }

    public void setSightCategory(SightCategory sightCategory) {
        this.sightCategory = sightCategory;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
