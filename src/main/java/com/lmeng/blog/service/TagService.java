package com.lmeng.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmeng.blog.model.domain.Tag;
import com.lmeng.blog.model.dto.TagDto;

import java.util.List;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
public interface TagService extends IService<Tag> {

    List<TagDto> findTagsByArticleId(Long id);

}
