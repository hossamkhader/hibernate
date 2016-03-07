package tables;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @Column (name = "dept_name")
    private String dept_name;
    
    @OneToOne (fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "dept_head")
    private Instructor dept_head;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="student_department",joinColumns={@JoinColumn(name="department_name")},inverseJoinColumns={@JoinColumn(name="student_ID")})
    private Set<Student> students;
    
    
    public Department () {
        this.students = new HashSet<>();
    }

    
    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Instructor getDept_head() {
        return dept_head;
    }

    public void setDept_head(Instructor dept_head) {
        this.dept_head = dept_head;
    }
    
    
    
    
}
