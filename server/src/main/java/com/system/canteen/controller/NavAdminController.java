package com.system.canteen.controller;

import com.system.canteen.entity.NavAdmin;
import com.system.canteen.service.NavAdminService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * (NavAdmin)表控制层
 *
 */
@RestController
@RequestMapping("nav_admin")
public class NavAdminController extends BaseController<NavAdmin, NavAdminService> {
    /**
     * 服务对象
     */
    @Autowired
    public NavAdminController(NavAdminService service) {
        setService(service);
    }

}


