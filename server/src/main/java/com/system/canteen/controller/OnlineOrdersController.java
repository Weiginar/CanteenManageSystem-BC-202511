package com.system.canteen.controller;

import com.system.canteen.entity.OnlineOrders;
import com.system.canteen.service.OnlineOrdersService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 线上订单：(OnlineOrders)表控制层
 *
 */
@RestController
@RequestMapping("/online_orders")
public class OnlineOrdersController extends BaseController<OnlineOrders, OnlineOrdersService> {

    /**
     * 线上订单对象
     */
    @Autowired
    public OnlineOrdersController(OnlineOrdersService service) {
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
