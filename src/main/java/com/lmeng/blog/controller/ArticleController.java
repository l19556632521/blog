package com.lmeng.blog.controller;

import com.lmeng.blog.common.ResultUtil;
import com.lmeng.blog.model.dto.ArticleDto;
import com.lmeng.blog.model.request.PageRequest;
import com.lmeng.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;
    //ResultUtil是统一结果返回

    @PostMapping
    public ResultUtil articles(@RequestBody PageRequest pageRequest) {
        //ArticleVo 页面接收的数据
        List<ArticleDto> articles = articleService.listArticlesPage(pageRequest);

        return ResultUtil.success(articles);
    }

}
