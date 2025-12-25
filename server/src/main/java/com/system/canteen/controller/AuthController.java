package com.system.canteen.controller;

import com.system.canteen.entity.Auth;
import com.system.canteen.service.AuthService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 定制授权(Auth)表控制层
 */
@RestController
@RequestMapping("auth")
public class AuthController extends BaseController<Auth, AuthService> {
    /**
     * 服务对象
     */
    @Autowired
    public AuthController(AuthService service) {
        setService(service);
    }

}


