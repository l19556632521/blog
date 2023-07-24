package com.lmeng.blog.service;

import com.lmeng.blog.model.domain.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lmeng.blog.model.dto.ArticleDto;
import com.lmeng.blog.model.request.PageRequest;

import java.util.List;

/**
* @author 26816
* @description 针对表【ms_article】的数据库操作Service
* @createDate 2023-07-24 10:25:08
*/
public interface ArticleService extends IService<Article> {

    /**
     * 分页查询文章列表
     * @param pageRequest
     * @return
     */
    List<ArticleDto> listArticlesPage(PageRequest pageRequest);
}
