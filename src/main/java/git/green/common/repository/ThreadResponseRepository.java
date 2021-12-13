package git.green.common.repository;

import git.green.common.model.ThreadResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadResponseRepository extends JpaRepository<ThreadResponse, Long> {
}
