package com.nzhussup.javadatamanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Item {

    private int itemid;
    private int userid;
    private String title;
    private String description;
    private double score;

    public Item() {
        this(0, 0, "default", "default", 0);
    }

    public Item(int userid, String title, String description, double score) {
        this(0, userid, title, description, score);
    }

    @Override
    public String toString() {
        return "Item{" +
                "userid=" + userid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }
}
