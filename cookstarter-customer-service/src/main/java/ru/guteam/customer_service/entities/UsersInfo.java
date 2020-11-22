package ru.guteam.customer_service.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "users_info")
public class  UsersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(mappedBy = "usersInfo")
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

}

