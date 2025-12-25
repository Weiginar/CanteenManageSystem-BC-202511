package com.system.canteen.controller;

import com.system.canteen.entity.OfflineOrders;
import com.system.canteen.service.OfflineOrdersService;
import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


/**
 * 线下订单：(OfflineOrders)表控制层
 *
 */
@RestController
@RequestMapping("/offline_orders")
public class OfflineOrdersController extends BaseController<OfflineOrders, OfflineOrdersService> {

    /**
     * 线下订单对象
     */
    @Autowired
    public OfflineOrdersController(OfflineOrdersService service) {
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
