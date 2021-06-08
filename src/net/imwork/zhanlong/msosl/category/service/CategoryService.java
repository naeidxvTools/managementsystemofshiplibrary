package net.imwork.zhanlong.msosl.category.service;

import net.imwork.zhanlong.msosl.category.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService
{
    List<Category> findAll() throws SQLException;
}
