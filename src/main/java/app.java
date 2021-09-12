import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class app {

    public static void main(String[] args) {

        //Set the object
        Person person = new Person();
        person.setName("jóska");
        person.setAge(25);

        //Declaration sessionfactory (input is just the type of the class)
        SessionFactory sessionFactory = buildSessionFactory(Person.class);
        Session session = sessionFactory.openSession();

        //Save object into DB
        session.save(person);

        //Read from DB by id, and initialive into an obj
        Person readedObj = session.get(Person.class, 1);

        //Print result
        System.out.println("\t--" + readedObj.toString() + "--");

        //Close
        session.close();
        sessionFactory.close();
    }


    //load into Hybernate
    private static SessionFactory buildSessionFactory(Class object) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(object)
                .buildSessionFactory();
    }
}
