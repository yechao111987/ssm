package yechao.service;

import scala.UserScala;
import yechao.basic.Response;

public interface UserService {
    public Boolean loginByNameAndPassword(String name, String password);

    public Response<UserScala> getUserInfoById(Integer id);

    public Boolean register(UserScala userScala);

    public UserScala getUserInfoByName(String name);


}
