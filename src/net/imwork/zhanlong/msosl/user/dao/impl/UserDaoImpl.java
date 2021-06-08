package net.imwork.zhanlong.msosl.user.dao.impl;

import net.imwork.zhanlong.msosl.user.dao.UserDao;
import net.imwork.zhanlong.msosl.user.model.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 展龙
 */
@SuppressWarnings("all")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao
{
    /**
     * 按用户名和密码查询
     *
     * @param loginname
     * @param loginpass
     * @return
     */
    @Override
    public User findByLoginnameAndLoginpass(String loginname, String loginpass)
    {
        List<User> list = (List<User>) this.getHibernateTemplate().find(
                "from User u where u.loginname=?0 and loginpass=?1", loginname, loginpass);
        return list.get(0);
    }

    /**
     * 按uid和密码查询
     *
     * @param uid
     * @param password
     * @return
     */
    public boolean findByUidAndPassword(String uid, String password)
    {
        User user = this.getHibernateTemplate().get(User.class, uid);
        String mysql_password = user.getLoginpass();
        return mysql_password.equalsIgnoreCase(password);
    }

    /**
     * 修改密码
     *
     * @param uid
     * @param newloginpass
     * @throws SQLException
     */
    public void updatePassword(String uid, String newloginpass)
    {
        User user = this.getHibernateTemplate().get(User.class, uid);
        user.setLoginpass(newloginpass);
        this.getHibernateTemplate().update(user);
    }


    /**
     * 通过激活码查找
     *
     * @param activationCode
     * @return
     * @throws SQLException
     */
    public User findByActivationCode(String activationCode)
    {
        List<User> list = (List<User>) this.getHibernateTemplate().find(
                "from User u where u.activationCode=?0", activationCode);
        return list.get(0);
    }

    /**
     * 更新状态
     *
     * @param uid
     * @param status
     * @throws SQLException
     */
    public void updateStatus(String uid, int status)
    {
        User user = getHibernateTemplate().get(User.class, uid);
        user.setStatus(status);
    }


    /**
     * 校验用户名是否注册
     *
     * @param loginname
     * @return
     */
    public boolean ajaxValidateLoginname(String loginname)
    {
        List<?> objects = this.getHibernateTemplate().find("from User u where u.loginname=?0", loginname);
        return objects.size() == 0;
    }


    /**
     * 校验Email是否注册
     *
     * @param email
     * @return
     */
    public boolean ajaxValidateEmail(String email)
    {
        List<?> objects = this.getHibernateTemplate().find("from User u where u.email=?0", email);
        return objects.size() == 0;
    }

    /**
     * 添加用户
     *
     * @param user
     * @throws SQLException
     */
    public void add(User user)
    {
        this.getHibernateTemplate().save(user);
    }
}
