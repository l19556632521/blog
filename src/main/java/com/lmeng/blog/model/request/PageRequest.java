package com.lmeng.blog.model.request;

import lombok.Data;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
@Data
public class PageRequest {

    private int page = 1;

    private int pageSize = 10;
}
