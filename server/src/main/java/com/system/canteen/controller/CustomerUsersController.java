package com.system.canteen.controller;

import com.system.canteen.entity.CustomerUsers;
import com.system.canteen.service.CustomerUsersService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 顾客用户：(CustomerUsers)表控制层
 *
 */
@RestController
@RequestMapping("/customer_users")
public class CustomerUsersController extends BaseController<CustomerUsers, CustomerUsersService> {

    /**
     * 顾客用户对象
     */
    @Autowired
    public CustomerUsersController(CustomerUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
