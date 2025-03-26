package za.ac.cput.repository;

import za.ac.cput.domain.Session;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SessionRepositoryImpl {
    private final ConcurrentHashMap<String, Session> sessionMap;
    private static SessionRepositoryImpl repository;

    private SessionRepositoryImpl() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public static synchronized SessionRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new SessionRepositoryImpl();
        }
        return repository;
    }

    public Session create(Session session) {
        Objects.requireNonNull(session, "Session cannot be null");
        Objects.requireNonNull(session.getSessionId(), "Session ID cannot be null");

        // Prevent duplicates
        if (sessionMap.containsKey(session.getSessionId())) {
            return sessionMap.get(session.getSessionId());
        }

        sessionMap.put(session.getSessionId(), session);
        return session;
    }

    public Session read(String sessionId) {
        Objects.requireNonNull(sessionId, "Session ID cannot be null");
        return sessionMap.get(sessionId);
    }

    public Session update(Session session) {
        Objects.requireNonNull(session, "Session cannot be null");
        Objects.requireNonNull(session.getSessionId(), "Session ID cannot be null");

        if (!sessionMap.containsKey(session.getSessionId())) {
            return null;
        }

        sessionMap.put(session.getSessionId(), session);
        return session;
    }

    public boolean delete(String sessionId) {
        Objects.requireNonNull(sessionId, "Session ID cannot be null");
        return sessionMap.remove(sessionId) != null;
    }

    public List<Session> getAll() {
        return new ArrayList<>(sessionMap.values());
    }

    public void clear() {
        sessionMap.clear();
    }
}

/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 22 March 2025
modified 25 March 2025
*/