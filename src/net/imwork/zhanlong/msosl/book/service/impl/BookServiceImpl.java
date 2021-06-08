package net.imwork.zhanlong.msosl.book.service.impl;

import net.imwork.zhanlong.msosl.book.dao.BookDao;
import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.book.service.BookService;
import net.imwork.zhanlong.msosl.pager.PageBean;


/**
 * @author 展龙
 */
@SuppressWarnings("unused")
public class BookServiceImpl implements BookService
{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    @Override
    public PageBean<Book> findByCategory(String cid, int pc)
    {
        return bookDao.findByCategory(cid, pc);
    }

    @Override
    public Book load(String bid)
    {
        return bookDao.findByBid(bid);
    }

    @Override
    public PageBean<Book> findByAuthor(String author, int pc)
    {
        return this.bookDao.findByAuthor(author, pc);
    }

    @Override
    public PageBean<Book> findByPress(String press, int pc)
    {
        return bookDao.findByPress(press, pc);
    }
}
