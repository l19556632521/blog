package com.lmeng.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmeng.blog.model.domain.Tag;
import com.lmeng.blog.model.dto.TagDto;
import com.lmeng.blog.service.TagService;
import com.lmeng.blog.mapper.TagMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author 26816
* @description 针对表【ms_tag】的数据库操作Service实现
* @createDate 2023-07-24 10:29:24
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

    @Autowired
    private TagMapper tagMapper;

    public TagDto copy(Tag tag){
        TagDto tagVo = new TagDto();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagDto> copyList(List<Tag> tagList){
        List<TagDto> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagDto> findTagsByArticleId(Long id) {
        //mybatis-plus无法进行多表查询
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

}




