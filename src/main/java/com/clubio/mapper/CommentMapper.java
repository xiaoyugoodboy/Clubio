package com.clubio.mapper;

import com.clubio.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
