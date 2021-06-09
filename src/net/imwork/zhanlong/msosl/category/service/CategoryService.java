package net.imwork.zhanlong.msosl.category.service;

import net.imwork.zhanlong.msosl.category.model.Category;

import java.util.List;

/**
 * @author Administrator
 */
@SuppressWarnings("all")
public interface CategoryService
{
    List<Category> findAll();
}
