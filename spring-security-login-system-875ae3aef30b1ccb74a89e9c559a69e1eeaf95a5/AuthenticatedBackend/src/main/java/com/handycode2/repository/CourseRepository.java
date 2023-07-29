package com.handycode2.repository;

import com.handycode2.enums.CourseType;
import com.handycode2.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom query methods, if needed

    // Example of a custom query to fetch courses by their type
    List<Course> findByType(CourseType type);

}
