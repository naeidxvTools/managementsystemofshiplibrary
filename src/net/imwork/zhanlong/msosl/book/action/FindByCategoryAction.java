package net.imwork.zhanlong.msosl.book.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.msosl.book.model.Book;
import net.imwork.zhanlong.msosl.book.service.BookService;
import net.imwork.zhanlong.msosl.pager.PageBean;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 展龙
 */
public class FindByCategoryAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private BookService bookService;

    public void setBookService(BookService bookService)
    {
        this.bookService = bookService;
    }

    /**
     * 获取pc
     * @param request
     * @return
     */
    private int getPc(HttpServletRequest request)
    {
        int pc = 1;
        String param = request.getParameter("pc");
        if (param != null && !param.trim().isEmpty())
        {
            try
            {
                pc = Integer.parseInt(param);
            } catch (RuntimeException e) {}
        }
        return pc;
    }

    /**
     * 获取Url,页面中的分页导航中需要使用它作为超链接的目标
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request)
    {
        String url = request.getRequestURI() + "?" + request.getQueryString();
        int index = url.lastIndexOf("&pc=");
        if (index != -1)
        {
            url = url.substring(0, index);
        }
        return url;
    }

    /**
     * 按分类查询
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public void findByCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        //1.得到pc
        int pc = getPc(request);
        //2.得到url
        String url = getUrl(request);
        //3.获取查询条件 cid
        String cid = request.getParameter("cid");
        //4.使用pc和cid调用service的findByCategory方法
        PageBean<Book> pageBean = bookService.findByCategory(cid, pc);
        //5.给PageBean设置url，保存PageBean，转发到jsps/book/list.jsp
        pageBean.setUrl(url);
        request.setAttribute("pb",pageBean);

        //return "f:/jsps/book/list.jsp";
    }

    @Override
    public String execute() throws Exception
    {
        findByCategory(request,response);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }
}
