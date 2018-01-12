package scala.controller

import java.lang.String
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, ResponseBody}
import yechao.basic.Response
import yechao.dao.UserDao
import yechao.service.UserService
import yechao.service.impl.UserServiceImpl
import yechao.yechaoUtil.StringUtil

import scala.UserScala

@Controller
@RequestMapping(Array {
  "/user"
})
class UserController {
  @Autowired
  private var request: HttpServletRequest = _

  @Autowired
  var userDao: UserDao = _ //

  @Autowired
  val userService: UserServiceImpl = new UserServiceImpl

  //  @RequestMapping("/login")
  //  @ResponseBody
  //  def toLogin(@RequestParam("name") name: String, @RequestParam("password") password: String): Nothing = {
  //    return null
  //  }


  @RequestMapping(Array {
    "/getInfo"
  })
  @ResponseBody
  def getinfo(@RequestParam("id") id: String): Response[UserScala] = {
    var response = new Response[UserScala]
    //
    var id: String = request.getParameter("id")
    if (id == null || StringUtil.isNumberic(id)) {
      response.setCode("1")
      response.setMessage("id不能为空或者id包含非数字字符")
      return response
    }
    var uid: Integer = Integer.parseInt(id)
    response = userService.getUserInfoById(uid)
    response
  }

  //  override def getUserInfoById(id: Integer): Response[UserScala] = {
  //    val response = new Response[UserScala]
  //    var user: UserScala = new UserScala
  //    user = userDao.selectByPrimaryKey(id)
  //    user = this.userDao.selectByPrimaryKey(id)
  //    if (null == user) {
  //      response.setCode("1")
  //      response.setMessage("用户信息为空")
  //      response
  //    }
  //    response.setCode("0")
  //    response.setMessage("用户信息查询成功")
  //    response.setDataResult(user)
  //    response
  //  }
}
