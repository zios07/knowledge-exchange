package common.server.rest;

import common.server.domain.Post;
import common.server.domain.Role;
import common.server.exception.ServiceException;
import common.server.service.IPostService;
import common.server.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

	@Autowired
	private IPostService service;

	@GetMapping(value = "{id}")
	public Post findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping(value = "{id}")
	public void deletePost(@PathVariable Long id) {
		service.deletePost(id);
	}

	@GetMapping
	public List<Post> findPostByUsername(@RequestParam(required = false) String username) throws ServiceException {
		if(username != null) {
			return service.findPostByUsername(username);
		} else {
			return service.findAll();
		}
	}

	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return service.createPost(post);
	}

	@PutMapping
	public Post updatePost(@RequestBody Post post) {
		return service.updatePost(post);
	}
}
