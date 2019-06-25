package common.server.service.impl;

import common.server.domain.Message;
import common.server.repository.MessageRepository;
import common.server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository repo;

    @Override
    public Message save(Message message) {
        if (message.getParentMessage() != null) {
            Message parent = message.getParentMessage();
            parent.setResponded(true);
            repo.save(parent);
        }
        return repo.save(message);
    }

    @Override
    public List<Message> findAll() {
        return repo.findAll();
    }

    @Override
    public Message findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Message> findForReceiver(Long id) {
        return repo.findByReceiverId(id);
    }

    @Override
    public List<Message> loadSentMessages(Long id) {
        return repo.findBySenderId(id);
    }

}
