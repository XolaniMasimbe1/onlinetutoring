package za.ac.cput.repository;

import za.ac.cput.domain.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TutorRepository implements IRepository<Tutor, String> {
    private final List<Tutor> tutorList = new ArrayList<>();
    private static TutorRepository repository = null;

    private TutorRepository() {}

    public static synchronized TutorRepository getRepository() {
        if (repository == null) {
            repository = new TutorRepository();
        }
        return repository;
    }

    public static void resetRepository() {
        repository = null;
    }

    @Override
    public Tutor create(Tutor tutor) {
        Objects.requireNonNull(tutor, "Tutor cannot be null");
        if (read(tutor.getIdentityNumber()) != null) {
            return null;
        }
        tutorList.add(tutor);
        return tutor;
    }

    @Override
    public Tutor read(String identityNumber) {
        Objects.requireNonNull(identityNumber, "ID cannot be null");
        return tutorList.stream()
                .filter(t -> t.getIdentityNumber().equals(identityNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Tutor update(Tutor tutor) {
        Objects.requireNonNull(tutor, "Tutor cannot be null");
        Tutor existing = read(tutor.getIdentityNumber());
        if (existing != null) {
            tutorList.remove(existing);
            tutorList.add(tutor);
            return tutor;
        }
        return null;
    }

    @Override
    public boolean delete(String identityNumber) {
        Objects.requireNonNull(identityNumber, "ID cannot be null");
        Tutor tutor = read(identityNumber);
        if (tutor != null) {
            return tutorList.remove(tutor);
        }
        return false;
    }

    @Override
    public List<Tutor> getAll() {
        return new ArrayList<>(tutorList);
    }
}