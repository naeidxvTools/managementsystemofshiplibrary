package net.imwork.zhanlong.msosl.user.model;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public class User
{
    //对应t_user数据库表
    private String uid;//主键
    private String loginname;//用户名
    private String loginpass;//登录密码
    private String email;//邮箱
    private int status;//状态
    private String activationCode;//激活码

    //注册表单
    private String reloginpass;//确认密码
    private String verifyCode;//验证码

    //修改密码表单
    private String newpass;//新密码

    public User()
    {
    }

    public User(String uid, String loginname, String loginpass, String email, int status, String activationCode, String reloginpass, String verifyCode, String newpass)
    {
        this.uid = uid;
        this.loginname = loginname;
        this.loginpass = loginpass;
        this.email = email;
        this.status = status;
        this.activationCode = activationCode;
        this.reloginpass = reloginpass;
        this.verifyCode = verifyCode;
        this.newpass = newpass;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "uid='" + uid + '\'' +
                ", loginname='" + loginname + '\'' +
                ", loginpass='" + loginpass + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                ", reloginpass='" + reloginpass + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", newpass='" + newpass + '\'' +
                '}';
    }

    public String getUid()
    {
        return uid;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public String getLoginname()
    {
        return loginname;
    }

    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }

    public String getLoginpass()
    {
        return loginpass;
    }

    public void setLoginpass(String loginpass)
    {
        this.loginpass = loginpass;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getActivationCode()
    {
        return activationCode;
    }

    public void setActivationCode(String activationCode)
    {
        this.activationCode = activationCode;
    }

    public String getReloginpass()
    {
        return reloginpass;
    }

    public void setReloginpass(String reloginpass)
    {
        this.reloginpass = reloginpass;
    }

    public String getVerifyCode()
    {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode)
    {
        this.verifyCode = verifyCode;
    }

    public String getNewpass()
    {
        return newpass;
    }

    public void setNewpass(String newpass)
    {
        this.newpass = newpass;
    }
}
