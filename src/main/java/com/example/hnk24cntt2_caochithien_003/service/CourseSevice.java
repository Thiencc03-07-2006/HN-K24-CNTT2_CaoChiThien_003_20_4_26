package com.example.hnk24cntt2_caochithien_003.service;

import com.example.hnk24cntt2_caochithien_003.model.Course;
import com.example.hnk24cntt2_caochithien_003.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSevice {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> search(String keyword) {
        return courseRepository.findAll().stream().filter(course -> keyword == null || keyword.isEmpty() || course.getCourseName().toLowerCase().contains(keyword.toLowerCase()) || course.getInstructor().toLowerCase().contains(keyword.toLowerCase())).toList();
    }

    public boolean saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public boolean deleteCourse(Long id) {
        return courseRepository.delete(id);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id);
    }
}
