package net.imwork.zhanlong.msosl.user.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.msosl.user.model.User;
import net.imwork.zhanlong.msosl.user.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * @author 展龙
 */
public class LoginAction extends ActionSupport
{
    private UserService userService;

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        //1.封装表单数据到User
        User user = new User();
        String loginname = request.getParameter("loginname");
        String loginpass = request.getParameter("loginpass");

        user.setLoginname(loginname);
        user.setLoginpass(loginpass);

        //2.校验表单数据
///        Map<String, String> errors = validateLogin(user, request);
//        if (!errors.isEmpty())
//        {
//            request.setAttribute("errors", errors);
//            return "f:/jsps/user/login.jsp";
//        }


        // 3.使用service查询得到User
        User userByFind = userService.findByLoginnameAndLoginpass(user.getLoginname(),user.getLoginpass());

        System.out.println(userByFind);
 /**/
        //4.查看用户是否存在
        if (userByFind == null)
        {
            request.setAttribute("msg","用户名或密码错误!");
            request.setAttribute("user", user);
            return INPUT;
        }else
        {
            if (userByFind.getStatus() == 0)
            {
                request.setAttribute("msg", "用户还没有激活!");
                request.setAttribute("user", user);
                return INPUT;
            } else
            {
                request.getSession().setAttribute("sessionUser", userByFind);
                String loginname2 = userByFind.getLoginname();
                loginname2 = URLEncoder.encode(loginname2, "utf-8");
                Cookie cookie = new Cookie("loginname", loginname2);
                cookie.setMaxAge(60 * 60 * 24 * 10);
                response.addCookie(cookie);
                return SUCCESS;
            }
        }
    }
}
