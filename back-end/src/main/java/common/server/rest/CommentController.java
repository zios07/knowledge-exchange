package common.server.rest;

import common.server.domain.Comment;
import common.server.exception.ServiceException;
import common.server.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping(value = "{id}")
    public Comment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
    }

    @GetMapping
    public List<Comment> findCommentByUserAndPost(@RequestParam(required = false) String username, @RequestParam(required = false) Long postId) throws ServiceException {
        if (username != null && postId != null) {
            return service.findCommentByUsernameAndPost(username, postId);
        } else if (username != null) {
            return service.findCommentByUsername(username);
        } else if (postId != null) {
            return service.findCommentByPost(postId);
        } else {
            return service.findAll();
        }
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return service.createComment(comment);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment) {
        return service.updateComment(comment);
    }
}
