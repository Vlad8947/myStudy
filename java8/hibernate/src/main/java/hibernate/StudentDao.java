package hibernate;

import org.hibernate.Session;

import java.util.List;

public class StudentDao {

    public static void save(Student student) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

    public static void delede(Student student) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public static void update (Student student) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }
    }

    public static Student findById (String id) {
        Student student;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            student = session.get(Student.class, id);
        }
        return student;
    }

    public static List<Student> getAll () {
        List<Student> students;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            students = (List<Student>) session.createQuery("select s from Student s").list();
        }
        return students;
    }

    public static void add1000() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            for (int i = 0; i < 1000; i++) {
                session.save(new Student("student_" + i));
            }
            session.getTransaction().commit();
        }
    }

}
