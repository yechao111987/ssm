package yechao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import yechao.UserService;
import yechao.UserServiceImpl;
import yechao.model.User;

public class Index {

	
    @RequestMapping(value = "/show2?userId",method = {RequestMethod.GET})
    public JSON showUser2(@RequestParam("userId")String userId,Model model){
    	UserService userService=new UserServiceImpl();
    	User user = userService.getUser(userId);
//        model.addAttribute(user);
//        return "showUser";
        JSON json=(JSON) JSON.toJSON(user);
        return json;
        
    }

}
