package za.ac.cput.repository;

import za.ac.cput.domain.Tutor;
import java.util.ArrayList;
import java.util.List;

public class TutorRepository implements IRepository<Tutor, String> {

    private static TutorRepository repository = null;
    private List<Tutor> tutorList;

    private TutorRepository() {
        tutorList = new ArrayList<>();
    }

    public static TutorRepository getRepository() {
        if (repository == null) {
            repository = new TutorRepository();
        }
        return repository;
    }

    @Override
    public Tutor create(Tutor tutor) {
        boolean success = tutorList.add(tutor);
        if (success) {
            return tutor;
        }
        return null;
    }

    @Override
    public Tutor read(String identityNumber) {
        for (Tutor t : tutorList) {
            if (t.getIdentityNumber().equals(identityNumber)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Tutor update(Tutor tutor) {
        Tutor existingTutor = read(tutor.getIdentityNumber());
        if (existingTutor != null) {
            tutorList.remove(existingTutor);
            tutorList.add(tutor);
            return tutor;
        }
        return null;
    }

    @Override
    public boolean delete(String identityNumber) {
        Tutor tutorToDelete = read(identityNumber);
        if (tutorToDelete == null) {
            return false;
        }
        return tutorList.remove(tutorToDelete);
    }

    @Override
    public List<Tutor> getAll() {
        return tutorList;
    }
}
/* OnlineTutoring.java
Tutor repository class
Author: Xolani Masimbe (222410817)
Date: 28 March 2025

*/