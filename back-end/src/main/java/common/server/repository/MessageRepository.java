package common.server.repository;

import common.server.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

  List<Message> findByReceiverId(Long id);

  List<Message> findBySenderId(Long id);

}
