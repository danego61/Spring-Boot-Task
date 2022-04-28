package yusuf.task.model.entity;

import lombok.*;
import yusuf.task.model.base.EntityBase;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Users")
public class User extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long userId;

    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR")
    private String name;

    @Column(name = "Surname", nullable = false, length = 50, columnDefinition = "NVARCHAR")
    private String surname;

    @Column(name = "Email", nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "Telephone", nullable = false, length = 11, unique = true, columnDefinition = "CHAR")
    private String telephone;

}
