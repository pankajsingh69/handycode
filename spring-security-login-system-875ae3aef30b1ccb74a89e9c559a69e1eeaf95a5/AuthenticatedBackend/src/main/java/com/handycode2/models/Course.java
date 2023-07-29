package com.handycode2.models;

import com.handycode2.enums.CourseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String duration;
    private String description;
    private double rating;

    @Enumerated(EnumType.STRING)
    private CourseType type; // Using the CourseType enum here

    private String format;
    private String imageUrl;

    // Constructors, getters, and setters (omitted for brevity)
}
