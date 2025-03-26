package za.ac.cput.repository;

import za.ac.cput.domain.Student;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StudentRepository implements IRepository<Student, String> {
    private final Map<String, Student> studentMap;
    private static StudentRepository instance;

    private StudentRepository() {
        studentMap = new ConcurrentHashMap<>();
    }

    public static synchronized void resetRepository() {
        instance = null;
    }

    public static synchronized StudentRepository getRepository() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    @Override
    public Student create(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
        Objects.requireNonNull(student.getStudentId(), "Student ID cannot be null");

        // Prevent duplicates - return null if student ID already exists
        if (studentMap.containsKey(student.getStudentId())) {
            return null;
        }

        studentMap.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public Student read(String studentId) {
        Objects.requireNonNull(studentId, "Student ID cannot be null");
        return studentMap.get(studentId);
    }

    @Override
    public Student update(Student student) {
        Objects.requireNonNull(student, "Student cannot be null");
        Objects.requireNonNull(student.getStudentId(), "Student ID cannot be null");

        if (!studentMap.containsKey(student.getStudentId())) {
            return null;
        }

        studentMap.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public boolean delete(String studentId) {
        Objects.requireNonNull(studentId, "Student ID cannot be null");
        return studentMap.remove(studentId) != null;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }
}