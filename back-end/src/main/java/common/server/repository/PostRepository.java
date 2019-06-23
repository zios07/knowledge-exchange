package common.server.repository;

import common.server.domain.Post;
import common.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserAccountUsername(String username);
}
