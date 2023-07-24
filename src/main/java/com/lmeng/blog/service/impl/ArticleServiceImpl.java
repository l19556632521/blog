package com.lmeng.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmeng.blog.model.domain.Article;
import com.lmeng.blog.model.domain.User;
import com.lmeng.blog.model.dto.ArticleDto;
import com.lmeng.blog.model.dto.TagDto;
import com.lmeng.blog.model.request.PageRequest;
import com.lmeng.blog.service.ArticleService;
import com.lmeng.blog.mapper.ArticleMapper;
import com.lmeng.blog.service.TagService;
import com.lmeng.blog.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 26816
* @description 针对表【ms_article】的数据库操作Service实现
* @createDate 2023-07-24 10:25:08
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private UserService userService;

    @Resource
    private TagService tagService;

    public ArticleDto copy(Article article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleDto articleVo = new ArticleDto();
        BeanUtils.copyProperties(article, articleVo);
        //并不是所有接口都需要标签，作者信息
        if (isAuthor) {
            User user = userService.findUserById(article.getAuthorId());
            articleVo.setAuthor(user.getNickname());
        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTags){
            List<TagDto> tags = tagService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }

    private List<ArticleDto> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleDto> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleDto articleVo = copy(article,isAuthor,isBody,isTags);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }


    @Override
    public List<ArticleDto> listArticlesPage(PageRequest pageRequest) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageRequest.getPage(),pageRequest.getPageSize());
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<ArticleDto> articleVoList = copyList(articlePage.getRecords(),true,false,true);
        return articleVoList;
    }
}




