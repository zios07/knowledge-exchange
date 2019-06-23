package common.server.repository;

import common.server.domain.Comment;
import common.server.domain.Post;
import common.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserAccountUsername(String username);

	List<Comment> findByUserAccountUsernameAndPostId(String username, long postId);

    List<Comment> findByPostId(Long postId);
}
