package hibernate;

public class Main {

    public static void main(String[] args) {
        try {
            add1000Students();
        } finally {
            HibernateSessionFactoryUtil.getSessionFactory().close();
        }
    }

    private static void add1000Students() {
        for (int i = 0; i < 1000; i++) {
            StudentDao.save(new Student("student_" + i));
        }
    }
}
