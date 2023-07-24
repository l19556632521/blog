package com.lmeng.blog.model.request;

import com.lmeng.blog.model.dto.TagDto;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
@Data
public class ArticleRequest {

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

//    private ArticleBodyVo body;

    private List<TagDto> tags;

//    private List<CategoryVo> categorys;

}
