package za.ac.cput.repository;

/* OnlineTutoring.java
Subject model class
Author: Siphosenkosi Mbala (221140700)
Date: 23 March 2025
*/


import za.ac.cput.domain.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubjectRepository implements IRepository<Subject, String> {
    private final Map<String, Subject> subjectDB;

    // Constructor
    public SubjectRepository() {
        this.subjectDB = new HashMap<>();
    }

    @Override
    public Subject create(Subject subject) {
        if (subject == null || subject.getSubjectId() == null) {
            throw new IllegalArgumentException("Subject or Subject ID cannot be null");
        }
        subjectDB.put(subject.getSubjectId(), subject);
        return subject;
    }

    @Override
    public Subject read(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return subjectDB.get(id);
    }

    @Override
    public Subject update(Subject subject) {
        if (subject == null || subject.getSubjectId() == null) {
            throw new IllegalArgumentException("Subject or Subject ID cannot be null");
        }
        if (!subjectDB.containsKey(subject.getSubjectId())) {
            return null; // or consider throwing an exception
        }
        subjectDB.put(subject.getSubjectId(), subject);
        return subject;
    }

    @Override
    public boolean delete(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return subjectDB.remove(id) != null;
    }

    @Override
    public List<Subject> getAll() {
        return new ArrayList<>(subjectDB.values());
    }
}