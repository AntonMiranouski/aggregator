package by.it.app.model;

import javax.persistence.*;

@Entity
@Table(name = "PREFERRED_WEBSITES", schema = "PUBLIC")
public class PreferredWebsites {

    @Id
    @Column(name="ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RANGE")
    private Integer range;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "WEBSITE_ID", nullable = false)
    private Website website;

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
