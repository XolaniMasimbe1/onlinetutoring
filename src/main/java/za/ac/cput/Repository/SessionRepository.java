package za.ac.cput.Repository;


import za.ac.cput.domain.Session;


import java.util.Set;

public interface SessionRepository extends IRepository<Session, String> {
    za.ac.cput.domain.Session create(za.ac.cput.domain.Session session);

    Set<Session> getAll();
}



/* OnlineTutoring.java
Tutor model class
Author: Basetsana Masisi (222309385)
Date: 23 March 2025
*/