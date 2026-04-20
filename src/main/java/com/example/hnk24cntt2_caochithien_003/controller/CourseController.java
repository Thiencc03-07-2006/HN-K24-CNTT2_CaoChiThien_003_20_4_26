package com.example.hnk24cntt2_caochithien_003.controller;

import com.example.hnk24cntt2_caochithien_003.model.Course;
import com.example.hnk24cntt2_caochithien_003.service.CourseSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseSevice courseSevice;

    @GetMapping
    public String showList(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("list", courseSevice.search(keyword));
        return "list";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "form";
    }

    @PostMapping("/save")
    public String saveCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("course", course);
            return "form";
        }
        courseSevice.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course",courseSevice.getCourse(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id) {
        courseSevice.deleteCourse(id);
        return "redirect:/courses";
    }
}
