package net.imwork.zhanlong.msosl.book.dao.impl;

import net.imwork.zhanlong.msosl.book.dao.BookDao;
import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.category.model.Category;
import net.imwork.zhanlong.msosl.pager.PageBean;
import net.imwork.zhanlong.msosl.pager.PageConstants;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public class BookDaoImpl extends HibernateDaoSupport implements BookDao
{
    /**
     * 删除图书
     * @param bid
     */
    @Override
    public void delete(String bid)
    {
        Book book = new Book();
        book.setBid(bid);
        this.getHibernateTemplate().delete(book);
    }


    /**
     * 修改图书
     * @param book
     */
    @Override
    public void edit(Book book)
    {
        this.getHibernateTemplate().saveOrUpdate(book);
    }


    /**
     * 按bid查询
     * @param bid
     * @return
     * @throws SQLException
     */
    @Override
    public Book findByBid(String bid)
    {
        DetachedCriteria criteria=DetachedCriteria.forClass(Book.class);
        criteria.add(Restrictions.eq("bid",bid));

        List<Book> beanList = (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);

        return beanList.get(0);
    }



    /**
     * 查询指定分类下图书的个数
     * @param cid
     * @return
     * @throws SQLException
     */

    public int findBookCountByCategory(String cid)
    {
//        String sql = "select count(*) from t_book where cid=?";
//        Number number = (Number) queryRunner.query(sql, new ScalarHandler(), cid);
//        return number == null ? 0 : number.intValue();
        return 0;
    }

    /**
     * 按分类查询
     * @param cid
     * @param pc
     * @return
     */
    @Override
    public PageBean<Book> findByCategory(String cid, int pc)
    {
        Book book = new Book();
        Category category = new Category();
        category.setCid(cid);
        book.setCategory(category);

        return findByCriteria(book, pc);
    }

    public static void main(String[] args)
    {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring-config.xml");
        BookDao bookDao = (BookDao) factory.getBean("bookDao");

        PageBean<Book> pageBean = bookDao.findByCategory("D45D96DA359A4FEAB3AB4DCF2157FC06", 1);
        System.out.println(pageBean);
    }

    /**
     * 按书名模糊查询
     * @param bname
     * @param pc
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Book> findByBname(String bname, int pc)
    {
        Book book = new Book();
        book.setBname(bname);

        return findByCriteria(book, pc);
    }

    /**
     * 按作者模糊查询
     * @param author
     * @param pc
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Book> findByAuthor(String author, int pc)
    {
        Book book = new Book();
        book.setAuthor(author);

        return findByCriteria(book, pc);
    }

    /**
     * 按出版社查询
     * @param press
     * @param pc
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Book> findByPress(String press, int pc)
    {
        Book book = new Book();
        book.setPress(press);

        return findByCriteria(book, pc);
    }

    /**
     * 多条件组合查询
     * @param book
     * @param pc
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Book> findByCombination(Book book, int pc)
    {
        PageBean<Book> pageBean = findByCriteria(book, pc);

        return pageBean;
    }

    /**
     * 通用的查询方法
     *
     * @param expressionList
     * @param pc
     * @return
     */
    private PageBean<Book> findByCriteria(Book book, int pc)
    {
        // 1.得到ps
        int ps = PageConstants.BOOK_PAGE_SIZE;

        // 2.得到tr
        String hql = "select count(*) from Book";
        int tr = ((Long) this.getHibernateTemplate().find(hql).listIterator().next()).intValue();

        // 3.得到beanList
        String name = book.getBname() == null ? "" : book.getBname();
        String author = book.getAuthor() == null ? "" : book.getAuthor();
        String press = book.getPress() == null ? "" : book.getPress();
        String cid = book.getCategory().getCid() == null ? "" : book.getCategory().getCid();

        DetachedCriteria criteria=DetachedCriteria.forClass(Book.class);
        criteria.add(Restrictions.like("bname","%"+ name + "%")).
                add(Restrictions.like("author","%"+ author + "%")).
                add(Restrictions.like("press","%"+ press + "%"));
//                add(Restrictions.like("cid","%"+ cid + "%"));

        List<Book> beanList = (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);

        // 4.创建PageBean，返回
        PageBean<Book> pageBean = new PageBean<>();
        pageBean.setPc(pc);
        pageBean.setPs(ps);
        pageBean.setBeanList(beanList);
        pageBean.setTr(tr);

        return pageBean;
    }

    /**
     * 添加图书
     * @param book
     */
    @Override
    public void add(Book book)
    {
        this.getHibernateTemplate().save(book);
    }

    /**
     * 查询图书是否被借阅
     * @param no
     * @return
     * @throws SQLException
     */
    public String queryBorrow(String no)
    {
//        String sql = "select bid from t_orderitem where bid = ?";
//        String sql2 = "select bid from t_cartitem where bid = ?";
//        String number = (String) queryRunner.query(sql, new ScalarHandler(), no);
//        String number2 = (String) queryRunner.query(sql2, new ScalarHandler(), no);
//        return number == null ? number2 : number;
        return null;
    }
}
