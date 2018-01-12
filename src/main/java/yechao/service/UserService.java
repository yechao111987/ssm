package yechao.service;

import scala.UserScala;
import yechao.basic.Response;

public interface UserService {
//    public Response<Boolean> loginByNameAndPassword(String name,String password);

    public Response<UserScala> getUserInfoById(Integer id);
}
