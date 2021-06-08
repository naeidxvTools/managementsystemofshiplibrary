package net.imwork.zhanlong.msosl.book.dao;

import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.pager.PageBean;


/**
 * @author 展龙
 */
@SuppressWarnings("all")
public interface BookDao
{
    void delete(String bid);

    void edit(Book book);

    Book findByBid(String bid);

    PageBean<Book> findByCategory(String cid, int pc);
    void add(Book book);
    PageBean<Book> findByCombination(Book criteria, int pc);

    PageBean<Book> findByBname(String bname, int pc);

    PageBean<Book> findByAuthor(String author, int pc);

    PageBean<Book> findByPress(String press, int pc);

}
