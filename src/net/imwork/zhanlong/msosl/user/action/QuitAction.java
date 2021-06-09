package net.imwork.zhanlong.msosl.user.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 展龙
 */
public class QuitAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
    private HttpServletRequest request;
    private HttpServletResponse response;


    @Override
    public String execute() throws Exception
    {
        request.getSession().invalidate();

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
