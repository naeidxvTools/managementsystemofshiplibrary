package net.imwork.zhanlong.msosl.book.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.book.service.BookService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 展龙
 */
public class LoadAction extends ActionSupport implements ServletRequestAware
{
    private HttpServletRequest request;
    private BookService bookService;

    public void setBookService(BookService bookService)
    {
        this.bookService = bookService;
    }

    @Override
    public String execute() throws Exception
    {
        String bid = request.getParameter("bid");

        Book book = bookService.load(bid);

        request.setAttribute("book",book);

        //return "f:/jsps/book/desc.jsp";

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }
}
