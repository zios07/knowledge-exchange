package common.server.service;

import common.server.domain.Category;
import common.server.exception.ServiceException;

import java.util.List;

public interface ICategoryService {

    Category findById(Long id);

    List<Category> findAll();

    Category createCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(long id);

}
