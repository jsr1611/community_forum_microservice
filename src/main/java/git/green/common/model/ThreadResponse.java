package git.green.common.model;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:14 PM
 */


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "thread_response")
public class ThreadResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String text;
    @ManyToOne()
    @JoinColumn(name = "thread_id", nullable = false)
    private Thread thread;
    private Long userId;
    private LocalDateTime createdAt;
}
