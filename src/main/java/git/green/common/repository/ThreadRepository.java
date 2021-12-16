package git.green.common.repository;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:26 PM
 */


import git.green.common.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {

    List<Thread> findByCategory(String category);

    List<Thread> findByContentContaining(String keyword);
}
