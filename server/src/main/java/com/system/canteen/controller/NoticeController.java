package com.system.canteen.controller;

import com.system.canteen.entity.Notice;
import com.system.canteen.service.NoticeService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 公告：(Notice)表控制层
 *
 */
@RestController
@RequestMapping("notice")
public class NoticeController extends BaseController<Notice, NoticeService> {
    /**
     * 服务对象
     */
    @Autowired
    public NoticeController(NoticeService service) {
        setService(service);
    }

}


