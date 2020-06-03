package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        /** read all properties and mappings from hibernate.cfg.xml */
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory_2() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                /** add mapping */
                configuration.addAnnotatedClass(Student.class);
//                sessionFactory = configuration.buildSessionFactory();
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory_3() {
        if (sessionFactory != null) {
            return sessionFactory;
        }

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );

            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }

        return sessionFactory;
    }

}
