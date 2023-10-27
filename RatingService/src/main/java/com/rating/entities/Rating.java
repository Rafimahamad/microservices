package com.rating.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity

@Table(name = "Rating")
public class Rating {
    @Id
    @Column
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
