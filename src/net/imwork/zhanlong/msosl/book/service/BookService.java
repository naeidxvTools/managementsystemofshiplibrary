package net.imwork.zhanlong.msosl.book.service;

import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.pager.PageBean;

import java.sql.SQLException;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public interface BookService
{
    PageBean<Book> findByCategory(String cid, int pc) throws SQLException;

    Book load(String bid);

    PageBean<Book> findByAuthor(String author, int pc);

    PageBean<Book> findByPress(String press, int pc);
}
