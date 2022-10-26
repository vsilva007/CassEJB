package ad.cass.entity;

import javax.persistence.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

/*import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;*/
import java.io.Serializable;

/**
 * Admin entity.
 * Hold admin data...
 */
@Entity(name = "Test")
@Table(name = "test")
@NamedQueries({ @NamedQuery(
        name = "allTest",
        query = "FROM Test test " + "ORDER BY test.test_id")
})
@XmlRootElement(name = "test")
@XmlAccessorType(XmlAccessType.FIELD)
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableGenerator(name = "TestIdGenerator", // generator name
            table = "sequences", // table who holds the sequences
            pkColumnName = "seq_id", // column for id
            valueColumnName = "seq_nextnum", // column for sequence value
            pkColumnValue = "test_id", // column name for this object
            allocationSize = 1) // allocationSize must be 1

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TestIdGenerator")
    @Column(name = "test_id", nullable = false)
    @XmlAttribute
    private long id;
    @Column(name = "test_name")
    private String name;

    /**
     * Constructor without parameters
     */
    public Test() {
        // Default constructor
    }

    /**
     * Construct an admin instance with parameters
     * @param name
     * @param surname
     * @param mail
     * @param pwd
     */
    public Test(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
