package za.ac.cput.Repository;

import za.ac.cput.domain.Session;

import java.util.HashSet;
import java.util.Set;

public class SessionRepositoryImpl implements SessionRepository {
    private Set<Session> sessionDB;
    public static SessionRepositoryImpl repository = null;

    private SessionRepositoryImpl() {
        this.sessionDB = new HashSet<>();
    }

    public static SessionRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new SessionRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Session create(Session session) {
        this.sessionDB.add(session);
        return session;
    }

    @Override
    public Session read(String sessionId) {
        return this.sessionDB.stream()
                .filter(session -> session.toString().contains(sessionId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Session update(Session session) {
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
        Session session = read(sessionId);
        if (session != null) {
            this.sessionDB.remove(session);
            return true;
        }
        return false;
    }

    @Override
    public Set<Session> getAll() {
        return sessionDB;
    }
}

