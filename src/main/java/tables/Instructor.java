package tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor extends Person {

	private static final long serialVersionUID = 1L;


	@Column(name = "salary")
    private double salary;
    

    @ManyToOne (fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_name")
    private Department dept_name;
    
    public Instructor () {
        
    }

    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDept_name() {
        return dept_name;
    }

    public void setDept_name(Department dept_name) {
        this.dept_name = dept_name;
    }
    
}
