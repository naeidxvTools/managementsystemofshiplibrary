package net.imwork.zhanlong.msosl.category.dao;

import net.imwork.zhanlong.msosl.category.model.Category;

import java.util.List;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public interface CategoryDao
{
    List<Category> findAll();
    List<Category> findByParent(String pid);
    void add(Category category);

}
