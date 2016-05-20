package util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        Locale.setDefault(Locale.ENGLISH);
        try {
            sessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}
