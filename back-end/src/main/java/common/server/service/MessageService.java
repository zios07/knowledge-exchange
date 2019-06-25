package common.server.service;


import common.server.domain.Message;

import java.util.List;

public interface MessageService {

  Message save(Message message);

  List<Message> findAll();

  Message findById(Long id);

  void delete(Long id);

  List<Message> findForReceiver(Long id);

  List<Message> loadSentMessages(Long id);
}
