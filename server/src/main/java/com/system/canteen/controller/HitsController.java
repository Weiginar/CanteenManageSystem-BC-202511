package com.system.canteen.controller;

import com.system.canteen.controller.base.BaseController;
import com.system.canteen.entity.Hits;
import com.system.canteen.service.HitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 点赞：(Hits)表控制层
 */
@RestController
@RequestMapping("hits")
public class HitsController extends BaseController<Hits, HitsService> {
    /**
     * 服务对象
     */
    @Autowired
    public HitsController(HitsService service) {
        setService(service);
    }

}


