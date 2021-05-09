package Dependencies;

import javax.persistence.EntityManagerFactory;

public interface IMysqlConnection {
    EntityManagerFactory createEntityManagerFactory();
}
