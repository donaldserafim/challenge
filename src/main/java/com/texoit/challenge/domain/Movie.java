package com.texoit.challenge.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="year_movie")
    private Integer year;

    private String title;

    @Column(name="studio")
    @ElementCollection(targetClass=String.class)
    private List<String> studios;

    @Column(name="producer")
    @ElementCollection(targetClass=String.class)
    private List<String> producers;

    private Boolean winner;
}
