package tables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends Person {

	private static final long serialVersionUID = 1L;


	@Column(name = "tot_cred")
    private int tot_cred;
    
    
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="student_department",joinColumns={@JoinColumn(name="student_ID")},inverseJoinColumns={@JoinColumn(name="department_name")})
    private Set<Department> departments;
    
    
    public Student () {
        this.departments = new HashSet<>();
    }
    
    public String printDepartments () {
        Iterator <Department> i = this.departments.iterator();
        String tmp = new String();
        while (i.hasNext()) {
            tmp += i.next().getDept_name();
            if(i.hasNext())
                tmp += ",";
        }
        return tmp;
    }


    public int getTot_cred() {
        return tot_cred;
    }

    public void setTot_cred(int tot_cred) {
        this.tot_cred = tot_cred;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
    
}
