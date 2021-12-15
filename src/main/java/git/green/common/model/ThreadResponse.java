package git.green.common.model;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:14 PM
 */


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "thread_response")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class ThreadResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    //reference: https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=rorean&logNo=221593255071
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String createdAt;

}
