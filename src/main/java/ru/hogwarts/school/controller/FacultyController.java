package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getFacultyById(@PathVariable(name = "id") Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if (faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updateFaculty);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFaculty(@PathVariable(name = "id") Long facultyId) {
        Faculty deletedFaculty = facultyService.deleteFaculty(facultyId);
        return ResponseEntity.ok(deletedFaculty);
    }

    @GetMapping("/getByColor/{color}")
    public List<Faculty> getByColour(@PathVariable String color) {
        return facultyService.getByColour(color);
    }
}
