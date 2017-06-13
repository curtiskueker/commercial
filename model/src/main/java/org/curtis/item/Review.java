package org.curtis.item;

import org.curtis.database.DatedDatabaseItem;
import org.curtis.user.User;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review extends DatedDatabaseItem {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "description")
    private String description;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
