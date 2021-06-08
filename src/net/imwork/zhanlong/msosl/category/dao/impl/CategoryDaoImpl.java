package net.imwork.zhanlong.msosl.category.dao.impl;

import net.imwork.zhanlong.commons.CommonUtils;
import net.imwork.zhanlong.msosl.category.dao.CategoryDao;
import net.imwork.zhanlong.msosl.category.model.Category;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 展龙
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao
{

    /**
     * 把一个map的数据映射到Category中
     * @param map
     * @return
     */
    private Category toCategory(Map<String, Object> map)
    {
        Category category = CommonUtils.mapToBean(map, Category.class);

        String pid = (String) map.get("pid");

        if (pid != null)
        {
            Category parent = new Category();
            parent.setCid(pid);
            category.setParent(parent);
        }

        return category;
    }

    /**
     * 把多个map映射成多个Category
     * @param mapList
     * @return
     */
    private List<Category> toCategoryList(List<Map<String,Object>> mapList)
    {
        List<Category> categoryList = new ArrayList<>();

        for (Map<String, Object> map : mapList)
        {
            Category category = toCategory(map);
            categoryList.add(category);
        }

        return categoryList;
    }

    /**
     * 返回所有分类
     * @return
     */
    @Override
    public List<Category> findAll()
    {
        List<Category> categories = this.getHibernateTemplate().loadAll(Category.class);

///        List<Category> new_categories = new ArrayList<>();
//
//        Category parent;
//
//        for (int i = 0; i< categories.size(); i++)
//        {
//            Category category = categories.get(i);
//            if (category.getParent() == null)
//            {
//                parent = category;
//                List<Category> children = this.findByParent(parent.getCid());
//                parent.setChildren(children);
//                new_categories.add(parent);
//            }
//        }
//        System.out.println(categories);

        return categories;
    }

    /**
     * 通过父分类查询子分类
     * @param pid
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("all")
    @Override
    public List<Category> findByParent(String pid)
    {
//        String sql = "select * from t_category where pid=? order by orderBy";
//        List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler(), pid);
//        return toCategoryList(mapList);
        List<Category> categories = (List<Category>) this.getHibernateTemplate().find("from Category c where c.parent.cid=?0", pid);

        return categories;
    }



    /**
     * 添加分类
     * @param category
     */
    @Override
    public void add(Category category)
    {
///        String sql = "insert into t_category (cid, cname, pid, `desc`) values (?,?,?,?)";
//        //因为一级分类没有parent，而二级分类有parent
//        //我们这个方法，要兼容两种分类，所有需要判断
//        String pid = null; //一级分类
//        if (category.getParent() != null)
//        {
//            pid = category.getParent().getCid();
//        }
//        Object[] params = {category.getCid(), category.getCname(), pid, category.getDesc()};
//        queryRunner.update(sql, params);

        this.getHibernateTemplate().save(category);

    }


    public static void main(String[] args)
    {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring-config.xml");
        CategoryDao dao = (CategoryDao) factory.getBean("categoryDao");

        Category category = new Category();
        category.setCname("zhanlong");
        category.setDesc("ddd");

        dao.add(category);
    }


    /**
     * 获取父分类，但不带子分类的！
     * @return
     * @throws SQLException
     */
    public List<Category> findParents() throws SQLException
    {
//        String sql = "select * from t_category where pid is null order by orderBy";
//        List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler());
//
//        return toCategoryList(mapList);
        return null;
    }

    /**
     * 加载分类
     * 既可加载一级分类，也可加载二级分类
     * @param cid
     * @return
     */
    public Category load(String cid) throws SQLException
    {
//        String sql = "select * from t_category where cid=?";
//        return toCategory(queryRunner.query(sql, new MapHandler(), cid));
        return null;
    }

    /**
     * 修改分类
     * @param category
     */
    public void edit(Category category) throws SQLException
    {
//        String sql = "update t_category set cname=?, pid=?,`desc`=? where cid=?";
//        String pid = null;
//        if (category.getParent() != null)
//        {
//            pid = category.getParent().getCid();
//        }
//        Object[] params = {category.getCname(),pid,category.getDesc(),category.getCid()};
//        queryRunner.update(sql,params);
    }

    /**
     * 查询指定父分类下子分类的个数
     * @param pid
     * @return
     */
    public int findChildCountByParent(String pid) throws SQLException
    {
//        String sql = "select count(*) from t_category where pid=?";
//        Number number = (Number) queryRunner.query(sql, new ScalarHandler(), pid);
//        return number == null ? 0 : number.intValue();
        return 1;
    }

    /**
     * 删除分类
     * @param cid
     */
    public void delete(String cid) throws SQLException
    {
//        String sql = "delete from t_category where cid=?";
//        queryRunner.update(sql, cid);
    }
}
