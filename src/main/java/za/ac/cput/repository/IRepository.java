package za.ac.cput.repository;
/* IRepository.java
Author: Xolani Masimbe (222410817)
Date: 23 March 2025
*/
import java.util.List;

public interface IRepository<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

    List<T> getAll();
}