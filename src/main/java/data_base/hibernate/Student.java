package data_base.hibernate;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@Getter @Setter
public class Student implements Serializable {

    @Id
    @GenericGenerator(name = "uuid_generator", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_generator")
    @Column(length = 36)
    private String id;

    @Column(nullable = false)
    private String name;

    private String mark;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
