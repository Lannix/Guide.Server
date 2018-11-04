package Guide.Server.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
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
}
