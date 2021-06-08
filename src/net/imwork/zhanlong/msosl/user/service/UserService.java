package net.imwork.zhanlong.msosl.user.service;

import net.imwork.zhanlong.msosl.user.model.User;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public interface UserService
{
    User findByLoginnameAndLoginpass(String loginname, String loginpass);
}
