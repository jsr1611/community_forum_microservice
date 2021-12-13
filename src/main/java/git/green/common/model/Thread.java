package git.green.common.model;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:07 PM
 */


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "thread")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private String content;
    private List<ThreadResponse> responses;
    private Long userId;
    private LocalDateTime createdAt;

}
