package nl.opinity.timbastiaans.interviewskilltest.datasource.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
        Optional<T> get(long id);

        List<T> getAll();

        void add(T t);

        void update(T t, Object[] params);

        void delete(T t);
}
