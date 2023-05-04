/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/25/2023 8:48 AM
 */
package io.nerd.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

    private String phone;

    @Column(name = "dob")
    private Date dateOfBirth;

    @Column(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private Boolean enabled;

    @JsonIgnore
    private Long verification;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles_injunction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> authorities;

    public ApplicationUser() {
        this.authorities= new HashSet<>();
        this.enabled=false;
    }
}
