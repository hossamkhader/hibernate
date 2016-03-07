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
public class InstructorBean {
    
    private static Configuration configuration;
    
    public InstructorBean() {
        configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Student.class);
    }
    
    public Instructor readData(String ID)
    {
        SessionFactory sessionFactory;
        ServiceRegistry serviceRegistry;
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Instructor i = (Instructor) session.get(Instructor.class, ID);
        //session.saveOrUpdate(i);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
        return i;
    }
    
}
