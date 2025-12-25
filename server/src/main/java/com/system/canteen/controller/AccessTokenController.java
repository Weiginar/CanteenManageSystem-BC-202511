package com.system.canteen.controller;

import com.system.canteen.entity.AccessToken;
import com.system.canteen.service.AccessTokenService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 临时访问牌(AccessToken)表控制层
 *
 */
@RestController
@RequestMapping("access_token")
public class AccessTokenController extends BaseController<AccessToken, AccessTokenService> {
    /**
     * 服务对象
     */
    @Autowired
    public AccessTokenController(AccessTokenService service) {
        setService(service);
    }

}


