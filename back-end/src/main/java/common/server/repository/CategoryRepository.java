package common.server.repository;

import common.server.domain.Category;
import common.server.domain.Post;
import common.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByCode(String code);
}
