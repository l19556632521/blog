package com.lmeng.blog.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
@Data
public class ArticleDto {
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
