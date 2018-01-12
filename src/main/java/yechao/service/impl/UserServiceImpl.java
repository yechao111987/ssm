package yechao.service.impl;

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


    @Override
    public Response<Boolean> loginByNameAndPassword(String name, String password) {
        Response<Boolean> response = new Response<>();
        UserScala userForm = new UserScala();
        userForm.setName("yechao");
        userForm.setPassword("yechao");
        if (null != userDao.selectByNameAndPassword(userForm) && userDao.selectByNameAndPassword(userForm).getUid() != null) {
            response.setCode("0");
            response.setMessage("用户名和密码正确");
            response.setDataResult(true);
            return  response;
        }
        response.setCode("1");
        response.setMessage("用户和密码不正确");
        return response;
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
}
