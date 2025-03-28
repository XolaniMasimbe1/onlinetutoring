package za.ac.cput.factory;

import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject createSubject(String subjectId, String name,
                                        String description, String gradeLevel) {
        // Validate required fields
        if (Helper.isNullOrEmpty(subjectId)) {
            throw new IllegalArgumentException("Subject ID cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(gradeLevel)) {
            throw new IllegalArgumentException("Grade level cannot be null or empty");
        }

        return new Subject.Builder()
                .setSubjectId(subjectId)
                .setName(name)
                .setDescription(description)
                .setGradeLevel(gradeLevel)
                .build();
    }
}
