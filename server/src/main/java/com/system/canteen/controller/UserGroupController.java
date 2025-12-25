package com.system.canteen.controller;

import com.system.canteen.entity.UserGroup;
import com.system.canteen.service.UserGroupService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 用户组：用于用户前端身份和鉴权(UserGroup)表控制层
 *
 */
@RestController
@RequestMapping("user_group")
public class UserGroupController extends BaseController<UserGroup, UserGroupService> {
    /**
     * 服务对象
     */
    @Autowired
    public UserGroupController(UserGroupService service) {
        setService(service);
    }

}


