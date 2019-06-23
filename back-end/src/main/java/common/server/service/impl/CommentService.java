package common.server.service.impl;

import common.server.domain.Comment;
import common.server.exception.ServiceException;
import common.server.repository.CommentRepository;
import common.server.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comment> findCommentByUsername(String username) throws ServiceException {
        return repository.findByUserAccountUsername(username);
    }

    @Override
    public List<Comment> findCommentByUsernameAndPost(String username, long postId) throws ServiceException {
        return repository.findByUserAccountUsernameAndPostId(username, postId);
    }

    @Override
    public Comment findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment createComment(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Comment> findCommentByPost(Long postId) {
        return repository.findByPostId(postId);
    }
}
