package com.example.demo5.web;

import com.example.demo5.domain.User;
import com.example.demo5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     * 处理“/users”的get请求，用来获取用户列表
     * 用过@R胸前Param传递参数，进一步实现条件查询歌者分页查询
     *
     * @param map
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
        map.addAttribute("userList", userService.findAll());
        return "userList";
    }

    /**
     * 显示创建用户表单
     *
     * @param map
     * @ret
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return "userForm";
    }

    /**
     * 创建用户
     * 处理"/users"的POST请求，用来获取用户列表
     * 通过@ModelAttribute绑定参数，也通过@RequestParam从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map, @ModelAttribute @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }
        userService.inserByUser(user);
        return "redirect:/users/";
    }

    /**
     * 显示需要更新用户表单
     * 处理“/users/{id}"的get请求，通过url中的id值获取user信息
     * url中的id,通过@PathVariable绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("user", userService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }

    /**
     * 处理"/users/{id}"的put请求，用来更新uuser信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(ModelMap map,
                          @ModelAttribute @Valid User user,
                          BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            map.addAttribute("action", "update");
            return "userForm";
        }
        userService.update(user);
        return "redirect:/users/";
    }

    /**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {

        userService.delete(id);
        return "redirect:/users/";
    }
}
