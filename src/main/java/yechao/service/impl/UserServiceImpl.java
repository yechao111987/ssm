package yechao.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.UserScala;
import yechao.basic.Response;
import yechao.dao.UserDao;
import yechao.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    final static Logger log = Logger.getLogger(UserServiceImpl.class);


    @Override
    public Boolean loginByNameAndPassword(String name, String password) {
        UserScala userForm = new UserScala();
        userForm.setName(name);
        userForm.setPassword(password);
        if (null != userDao.selectByNameAndPassword(userForm) && userDao.selectByNameAndPassword(userForm).getUid() != null) {
            log.info("uid is " + userDao.selectByNameAndPassword(userForm).getUid());
            return true;
        }
        return false;
    }

    @Override
    public Response<UserScala> getUserInfoById(Integer id) {
        Response<UserScala> response = new Response<UserScala>();
        UserScala user;
        user = this.userDao.selectByPrimaryKey(id);
        if (null == user) {
            response.setCode("1");
            response.setMessage("用户信息为空");
            return response;

        }
        response.setCode("0");
        response.setMessage("用户信息查询成功");
        response.setDataResult(user);
        return response;
    }

    @Override
    public Boolean register(UserScala userScala) {
        if (userDao.insert(userScala) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public UserScala getUserInfoByName(String name) {
        return userDao.selectByUserName(name);
    }
}
