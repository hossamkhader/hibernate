package tables;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column (name = "ID")
    private String ID;
    
    @Column(name = "name")
    private String name;
    
    public Person() {
        
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}
