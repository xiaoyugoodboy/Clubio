package com.clubio.service.impl;

import com.clubio.entity.Post;
import com.clubio.mapper.PostMapper;
import com.clubio.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
