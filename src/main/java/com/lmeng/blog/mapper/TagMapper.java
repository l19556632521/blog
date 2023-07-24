package com.lmeng.blog.mapper;

import com.lmeng.blog.model.domain.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 26816
* @description 针对表【ms_tag】的数据库操作Mapper
* @createDate 2023-07-24 10:29:24
* @Entity com.lmeng.blog.model.domain.MsTag
*/
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long id);
}




