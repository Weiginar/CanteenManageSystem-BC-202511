package com.project.demo.controller;

import com.project.demo.entity.OfflineOrders;
import com.project.demo.service.OfflineOrdersService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
