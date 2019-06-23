package common.server.service.impl;

import common.server.domain.Post;
import common.server.domain.User;
import common.server.exception.ServiceException;
import common.server.repository.PostRepository;
import common.server.service.IPostService;
import common.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private IUserService userService;

    @Override
    public List<Post> findPostByUsername(String username) throws ServiceException {
        return repository.findByUserAccountUsername(username);
    }

    @Override
    public Post findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(username);
        post.setDate(new Date());
        post.setUser(user);
        return repository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return repository.save(post);
    }

    @Override
    public void deletePost(long id) {
        repository.deleteById(id);
    }
}
