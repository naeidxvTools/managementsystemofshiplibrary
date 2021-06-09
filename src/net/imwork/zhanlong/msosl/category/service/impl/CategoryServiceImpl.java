package net.imwork.zhanlong.msosl.category.service.impl;

import net.imwork.zhanlong.msosl.category.dao.CategoryDao;
import net.imwork.zhanlong.msosl.category.model.Category;
import net.imwork.zhanlong.msosl.category.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService
{
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }
}
