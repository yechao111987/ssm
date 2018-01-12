package yechao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.UserScala;
import yechao.basic.Response;
import yechao.dao.UserDao;
import yechao.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;


//    @Override
//    public Response<Boolean> loginByNameAndPassword(String name, String password) {
//        return null;
//    }

    @Override
    public Response<UserScala> getUserInfoById(Integer id) {
        Response<UserScala> response  = new Response<UserScala>();
        UserScala user;
        user=this.userDao.selectByPrimaryKey(id);
        if (null==user){
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
