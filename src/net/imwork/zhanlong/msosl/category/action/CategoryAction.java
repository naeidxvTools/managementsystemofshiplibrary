package net.imwork.zhanlong.msosl.category.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.msosl.category.model.Category;
import net.imwork.zhanlong.msosl.category.service.CategoryService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 */
public class CategoryAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest)
    {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse)
    {
        this.response = httpServletResponse;
    }

    private CategoryService categoryService;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public void setCategoryService(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @Override
    public String execute() throws Exception
    {
        findAll(request, response);
        return SUCCESS;
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //1.通过service得到所有的分类
        //2.保存request中，转发到left.jsp
        List<Category> parents = null;

        parents = categoryService.findAll();


        request.setAttribute("parents", parents);

        //return "f:/jsps/left.jsp";
    }
}
