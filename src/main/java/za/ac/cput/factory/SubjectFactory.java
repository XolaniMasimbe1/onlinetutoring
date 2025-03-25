package za.ac.cput.factory;
import za.ac.cput.domain.Subject;

public class SubjectFactory {

    public static Subject createSubject(String subjectId, String name, String description, String gradeLevel)  {
        if (subjectId == null || subjectId.isEmpty()) {
            throw new IllegalArgumentException("Subject ID cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (gradeLevel == null || gradeLevel.isEmpty()) {
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

