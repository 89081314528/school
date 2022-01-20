package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import java.util.*;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long facultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(facultyId);
        facultyMap.put(facultyId, faculty);
        facultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long facultyId) {
        return facultyMap.get(facultyId);
    }

    public Faculty updateFaculty(Long facultyId, Faculty faculty) {
        facultyMap.put(facultyId, faculty);
        return faculty;
    }

    public Faculty deleteFaculty (Long facultyId) {
        return facultyMap.remove(facultyId);
    }

    public List<Faculty> getByColour(String colour) {
        Collection<Faculty> allFaculties = facultyMap.values();
        List<Faculty> facultiesByColour = new ArrayList<>();
        for (Faculty faculty : allFaculties) {
            if (faculty.getColor().equals(colour)) {
                facultiesByColour.add(faculty);
            }
        }
        return facultiesByColour;
    }
}
