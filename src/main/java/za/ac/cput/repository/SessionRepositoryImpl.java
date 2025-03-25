package za.ac.cput.repository;

import za.ac.cput.domain.Session;
import java.util.ArrayList;
import java.util.List;

public class SessionRepositoryImpl implements IRepository<Session, String> {
    private final List<Session> sessionDB;
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
        if (session == null) return null;
        this.sessionDB.add(session);
        return session;
    }

    @Override
    public Session read(String sessionId) {
        if (sessionId == null) return null;
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
            sessionDB.remove(oldSession);
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
        return new ArrayList<>(sessionDB); // Defensive copy of sessions
    }
}

/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 22 March 2025
modified 25 March 2025
*/