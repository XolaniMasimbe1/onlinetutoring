package za.ac.cput.repository;

import za.ac.cput.domain.Review;

import java.util.List;
import java.util.Set;

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    List<T> getAll();
}

/* IRepository.java
Author: Xolani Masimbe (222410817)
Date: 23 March 2025
*/