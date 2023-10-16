package com.clubio.service.impl;

import com.clubio.entity.Comment;
import com.clubio.mapper.CommentMapper;
import com.clubio.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
