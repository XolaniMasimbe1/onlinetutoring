package za.ac.cput.repository;
/* TutorRepository.java
Author: Xolani Masimbe (222410817)
Date: 23 March 2025
*/
import za.ac.cput.domain.Review;
import za.ac.cput.domain.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TutorRepository implements IRepository<Tutor, String> {
    private List<Tutor> tutorList = new ArrayList<>();


    private static TutorRepository repository = null;

    private TutorRepository() {}

    public static TutorRepository getRepository() {
        if (repository == null) {
            repository = new TutorRepository();
        }
        return repository;
    }

    @Override
    public Tutor create(Tutor tutor) {
        tutorList.add(tutor);
        return tutor;
    }

    @Override
    public Tutor read(String identityNumber) {
        for (Tutor tutor : tutorList) {
            if (tutor.getIdentityNumber().equals(identityNumber)) {
                return tutor;
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
        Tutor tutor = read(identityNumber);
        if (tutor != null) {
            tutorList.remove(tutor);
            return true;
        }
        return false;
    }

    @Override
    public Set<Review> getAll() {
        return new ArrayList<>(tutorList);
    }
}