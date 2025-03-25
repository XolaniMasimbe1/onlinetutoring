package za.ac.cput.repository;

import za.ac.cput.domain.Session;
import java.util.ArrayList;
import java.util.List;

public class SessionRepositoryImpl implements IRepository<Session, String> {
    private final List<Session> sessionDB;  // Final to ensure it is not reassigned
    private static SessionRepositoryImpl repository = null;

    private SessionRepositoryImpl() {
        this.sessionDB = new ArrayList<>();
    }

    // Singleton Pattern with Thread Safety
    public static SessionRepositoryImpl getRepository() {
        if (repository == null) {
            synchronized (SessionRepositoryImpl.class) {
                if (repository == null) {
                    repository = new SessionRepositoryImpl();
                }
            }
        }
        return repository;
    }

    @Override
    public Session create(Session session) {
        if (session == null) return null;  // Prevent adding null values
        this.sessionDB.add(session);
        return session;
    }

    @Override
    public Session read(String sessionId) {
        if (sessionId == null) return null; // Prevent NullPointerException
        return this.sessionDB.stream()
                .filter(session -> sessionId.equals(session.getSessionId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Session update(Session session) {
        if (session == null || session.getSessionId() == null) return null;

        Session oldSession = read(session.getSessionId());
        if (oldSession != null) {
            sessionDB.remove(oldSession);  // This works if `equals()` is properly implemented in `Session`
            sessionDB.add(session);
            return session;
        }
        return null;
    }

    @Override
    public boolean delete(String sessionId) {
        if (sessionId == null) return false;
        Session session = read(sessionId);
        if (session != null) {
            this.sessionDB.remove(session);
            return true;
        }
        return false;
    }

    @Override
    public List<Session> getAll() {
        return new ArrayList<>(sessionDB); // Returning a copy to prevent modification outside this class
    }
}
