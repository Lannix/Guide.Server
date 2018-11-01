package Guide.Server.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 15)
    private String username;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "language", length = 20)
    private String language;

    @Column(name = "avatar_image_path")
    private String avatarImagePath;

    @Column(name = "create_time", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createTime;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "watches",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sight_id")
    )
    private Collection<Sight> historyOfWatches;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "favourites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sight_id")
    )
    private Collection<Sight> favouriteSights;

    @OneToMany(mappedBy = "ratingUser", fetch = FetchType.LAZY)
    private Collection<Rating> ratings;

    @OneToMany(mappedBy = "commentUser", fetch = FetchType.LAZY)
    private Collection<Comment> comments;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAvatarImagePath() {
        return avatarImagePath;
    }

    public void setAvatarImagePath(String avatarImagePath) {
        this.avatarImagePath = avatarImagePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Collection<Sight> getHistoryOfWatches() {
        return historyOfWatches;
    }

    public void setHistoryOfWatches(Collection<Sight> historyOfWatches) {
        this.historyOfWatches = historyOfWatches;
    }

    public Collection<Sight> getFavouriteSights() {
        return favouriteSights;
    }

    public void setFavouriteSights(Collection<Sight> favouriteSights) {
        this.favouriteSights = favouriteSights;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
