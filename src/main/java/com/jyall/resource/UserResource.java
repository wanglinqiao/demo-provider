package com.jyall.resource;

import com.jyall.pojo.User;
import com.jyall.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by wang.linqiao on 2016/10/21.
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/user")
@Api(value = "/user",description = "用户相关接口",produces = MediaType.APPLICATION_JSON)
public class UserResource {
    private Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @GET
    @ApiOperation(value = "根据id获取用户信息",notes = "根据id获取用户信息",httpMethod = "GET",response = User.class)
    @Path("/{id}")
    public User getUserById(@PathParam("id") @ApiParam(value = "用户ID") String id){
        User user = new User();
        user.setId(id);
        user.setName("小小");
        return user;
    }

    @RequestMapping("/userList")
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表",httpMethod = "GET",response = List.class)
    @ResponseBody
    public List<User> userList(){
        try {
            return userService.userList();
        }catch (Exception e){
            logger.error("获取用户列表信息失败！",e);
            return null;
        }
    }

}
