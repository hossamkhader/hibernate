package beans;

import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import tables.Department;
import tables.Instructor;
import tables.Student;

@ManagedBean
public class StudentBean {
    
    private static Configuration configuration;
    
    public StudentBean() {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Student.class);
    }
    
    public Student readData(String ID)
    {
        SessionFactory sessionFactory;
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, ID);
        //session.saveOrUpdate(s);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        return s;
    }
    
}
