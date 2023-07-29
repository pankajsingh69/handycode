package com.handycode2.controllers;

import com.handycode2.enums.CourseType;
import com.handycode2.models.Course;
import com.handycode2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses/getall")
public class CourseController {
    @Autowired
    private  CourseRepository courseRepository;

//    public CourseController(CourseRepository courseRepository) {
//        this.courseRepository = courseRepository;
//    }

    // API to fetch all courses
    @GetMapping
    public List<Course> getAllCourses() {
        List<Course> list = courseRepository.findAll();
        return list;
    }

    // API to fetch a specific course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // API to fetch courses by their type
    @GetMapping("/type/{type}")
    public List<Course> getCoursesByType(@PathVariable CourseType type) {
        return courseRepository.findByType(type);
    }
}
