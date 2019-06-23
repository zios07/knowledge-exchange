package common.server.service;

import common.server.domain.Comment;
import common.server.exception.ServiceException;

import java.util.List;

public interface ICommentService {

    List<Comment> findCommentByUsername(String username) throws ServiceException;

    List<Comment> findCommentByUsernameAndPost(String username, long postId) throws ServiceException;

    Comment findById(Long id);

    List<Comment> findAll();

    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(long id);

    List<Comment> findCommentByPost(Long postId);
}
