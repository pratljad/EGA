package at.ega.appointmenthelper.Interfaces;

import java.io.IOException;

public interface IDataAccess<T> {

    Iterable<T> Get() throws IOException;

    T Get(int id) throws IOException;

    void Delete(int id);

    T Insert(T o);

    T Update(T o);
}
