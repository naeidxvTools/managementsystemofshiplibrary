package net.imwork.zhanlong.msosl.user.service.impl;

import net.imwork.zhanlong.msosl.user.dao.UserDao;
import net.imwork.zhanlong.msosl.user.model.User;
import net.imwork.zhanlong.msosl.user.service.UserService;

/**
 * @author 展龙
 */
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public User findByLoginnameAndLoginpass(String loginname, String loginpass)
    {
        return userDao.findByLoginnameAndLoginpass(loginname,loginpass);
    }


}
