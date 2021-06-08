package net.imwork.zhanlong.msosl.user.dao;

import net.imwork.zhanlong.msosl.user.model.User;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public interface UserDao
{
    User findByLoginnameAndLoginpass(String loginname, String loginpass);
    boolean findByUidAndPassword(String uid, String password);
    void updatePassword(String uid, String newloginpass);
    User findByActivationCode(String activationCode);
    void updateStatus(String uid, int status);
    boolean ajaxValidateLoginname(String loginname);
    boolean ajaxValidateEmail(String email);
    void add(User user);
}
