package git.green.common.model;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 5:55 PM
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String userName;
    private String password;
    private String phone;
    @Column(unique = true)
    private String email;
    private Integer status;
    private String photo;
    private String location;
    private String career;
    private LocalDateTime registeredAt;
    private String userMode;
    private String expertise;
    private Integer verification;
    private String generatedKey;
    private LocalDateTime startAt;
    private LocalDateTime expireAt;
    private Integer paid;
}
