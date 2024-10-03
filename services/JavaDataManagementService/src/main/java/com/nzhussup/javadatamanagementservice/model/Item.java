package com.nzhussup.javadatamanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
