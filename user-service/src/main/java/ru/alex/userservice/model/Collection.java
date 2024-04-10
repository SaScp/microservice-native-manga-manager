package ru.alex.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "user_microservice", name = "t_collection")
public class Collection {

    @Id
    private String id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "manga_count")
    private Integer mangaCount;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
