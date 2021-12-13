package git.green.common.model;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:07 PM
 */


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "thread")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private String content;

    @OneToMany(mappedBy = "thread", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ThreadResponse> responses;
    private Long userId;
    private LocalDateTime createdAt;

}
