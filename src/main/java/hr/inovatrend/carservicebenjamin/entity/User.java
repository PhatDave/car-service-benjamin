package hr.inovatrend.carservicebenjamin.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_sequence")
    @SequenceGenerator(name="user_sequence", allocationSize=10)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    private String name;
    private String surname;
    private int OIB;

    @Embedded
    private Address address;

}

