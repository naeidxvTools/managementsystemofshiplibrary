package net.imwork.zhanlong.msosl.user.action;

import com.opensymphony.xwork2.ActionSupport;
import net.imwork.zhanlong.verifyCode.utils.VerifyCode;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @author Administrator
 */
public class VerifyCodeAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public String execute() throws Exception
    {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        VerifyCode.output(image, response.getOutputStream());
        request.getSession().setAttribute("verifyCode", vc.getText());

        return super.execute();
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
