package za.ac.cput.repository;

import za.ac.cput.domain.Session;
import za.ac.cput.repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class SessionRepositoryImpl implements IRepository<Session, String> {
    private static SessionRepositoryImpl repository = null;
    private final List<Session> sessionList;

    private SessionRepositoryImpl() {
        sessionList = new ArrayList<>();
    }

    public static SessionRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new SessionRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Session create(Session session) {
        if (session == null || session.getSessionId() == null) {
            throw new IllegalArgumentException("Session ID cannot be null");
        }
        boolean success = sessionList.add(session);
        return success ? session : null;
    }

    @Override
    public Session read(String id) {
        if (id == null) {
            throw new IllegalArgumentException(" SessionID cannot be null");
        }
        for (Session s : sessionList) {
            if (s.getSessionId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Session update(Session session) {
        if (session == null || session.getSessionId() == null) {
            throw new IllegalArgumentException("Session and Session ID cannot be null");
        }
        Session existingSession = read(session.getSessionId());
        if (existingSession != null) {
            sessionList.remove(existingSession);
            sessionList.add(session);
            return session;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Session sessionToDelete = read(id);
        return sessionToDelete != null && sessionList.remove(sessionToDelete);
    }

    @Override
    public List<Session> getAll() {
        return new ArrayList<>(sessionList);
    }

}
/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 22 March 2025
modified 27 March 2025
*/