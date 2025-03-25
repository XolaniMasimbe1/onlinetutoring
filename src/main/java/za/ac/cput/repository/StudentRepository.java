package za.ac.cput.repository;

import za.ac.cput.domain.Student;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class StudentRepository implements IRepository<Student, String> {
    private final ConcurrentMap<String, Student> studentMap;
    private static volatile StudentRepository instance;

    private StudentRepository() {
        studentMap = new ConcurrentHashMap<>();
    }

    // Thread-safe singleton implementation
    public static StudentRepository getRepository() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }

    @Override
    public Student create(Student student) {
        if (student == null || student.getStudentID() == null) {
            throw new IllegalArgumentException("Student and student ID cannot be null");
        }
        return studentMap.putIfAbsent(student.getStudentID(), student);
    }

    @Override
    public Student read(String studentID) {
        if (studentID == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        return studentMap.get(studentID);
    }

    @Override
    public Student update(Student student) {
        if (student == null || student.getStudentID() == null) {
            throw new IllegalArgumentException("Student and student ID cannot be null");
        }

        // Since Student is immutable, we can only replace the entire object
        return studentMap.replace(student.getStudentID(), student);
    }

    @Override
    public boolean delete(String studentID) {
        if (studentID == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        return studentMap.remove(studentID) != null;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    // Additional helper methods if needed
    public boolean exists(String studentID) {
        return studentID != null && studentMap.containsKey(studentID);
    }

    public int count() {
        return studentMap.size();
    }

    public void clear() {
        studentMap.clear();
    }
}