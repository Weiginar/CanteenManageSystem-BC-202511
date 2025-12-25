package com.system.canteen.controller;

import com.system.canteen.entity.Comment;
import com.system.canteen.service.CommentService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 评论：(Comment)表控制层
 *
 */
@RestController
@RequestMapping("comment")
public class CommentController extends BaseController<Comment, CommentService> {
    /**
     * 服务对象
     */
    @Autowired
    public CommentController(CommentService service) {
        setService(service);
    }

}


