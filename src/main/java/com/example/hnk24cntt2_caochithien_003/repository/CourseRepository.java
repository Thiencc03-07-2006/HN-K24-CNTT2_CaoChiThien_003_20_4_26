package com.example.hnk24cntt2_caochithien_003.repository;

import com.example.hnk24cntt2_caochithien_003.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses=new ArrayList<>();
    private Long countId=1L;

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public boolean save(Course course) {
        if (course.getId() == null) {
            course.setId(countId++);
            courses.add(course);
            return true;
        }else {
            for (int i = 0; i < courses.size(); i++) {
                if (course.getId().equals(courses.get(i).getId())) {
                    courses.set(i, course);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(Long id) {
        return courses.removeIf(course -> course.getId().equals(id));
    }
}
