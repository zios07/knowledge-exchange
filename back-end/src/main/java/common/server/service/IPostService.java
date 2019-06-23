package common.server.service;

import common.server.domain.Post;
import common.server.exception.ServiceException;

import java.util.List;

public interface IPostService {

    List<Post> findPostByUsername(String username) throws ServiceException;

    Post findById(Long id);

    List<Post> findAll();

    Post createPost(Post post);

    Post updatePost(Post post);

    void deletePost(long id);

}
