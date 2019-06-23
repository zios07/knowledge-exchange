package common.server.service.impl;

import common.server.domain.Category;
import common.server.repository.CategoryRepository;
import common.server.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        repository.deleteById(id);
    }
}
