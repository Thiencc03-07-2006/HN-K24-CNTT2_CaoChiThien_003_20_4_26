package com.example.hnk24cntt2_caochithien_003.model;

import jakarta.validation.constraints.*;

public class Course {
    Long id;
    @NotBlank
    @Size(min = 5, max = 100)
    String courseName;
    @NotBlank
    @Size(min = 5, max = 100)
    String instructor;
    @Max(500)
    @Min(1)
    @NotNull
    Integer duration;
    String thumbnail;

    public Course(Long id, String courseName, String instructor, Integer duration, String thumbnail) {
        this.id = id;
        this.courseName = courseName;
        this.instructor = instructor;
        this.duration = duration;
        this.thumbnail = thumbnail;
    }

    public Course() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
