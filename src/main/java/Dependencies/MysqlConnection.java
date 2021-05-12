package Dependencies;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MysqlConnection implements IMysqlConnection {
    @Override
    public EntityManagerFactory createEntityManagerFactory() {
        EntityManagerFactory emf;
        try {
            emf = Persistence.createEntityManagerFactory("pu", null);
        } catch (javax.persistence.PersistenceException ex) {
            System.out.println("##########################################################");
            System.out.println("######      Error creating a persistence Unit       ######");
            System.out.println("##########################################################");
            throw ex;
        }
        return emf;
    }
}
