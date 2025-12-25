package com.system.canteen.controller;

import com.system.canteen.entity.Article;
import com.system.canteen.service.ArticleService;

import com.system.canteen.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * 文章：用于内容管理系统的文章(Article)表控制层
 *
 */
@RestController
@RequestMapping("article")
public class ArticleController extends BaseController<Article, ArticleService> {
    /**
     * 服务对象
     */
    @Autowired
    public ArticleController(ArticleService service) {
        setService(service);
    }

}


