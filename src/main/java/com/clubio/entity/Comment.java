package com.clubio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>
 * 评论表
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@TableName("comment")
@Schema( description = "评论表")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description="使用雪花算法生成的ID作为评论ID")
    @TableId(value = "comment_id", type = IdType.ASSIGN_ID)
    private Long commentId;

    @Schema(description="评论所属的帖子ID，引用帖子表的post_id")
    @TableField("post_id")
    private Long postId;

    @Schema(description="评论的内容")
    @TableField("content")
    private String content;

    @Schema(description="评论的点赞数")
    @TableField("likes")
    private Integer likes;

    @Schema(description="评论者ID，引用用户表的user_id")
    @TableField("commenter_id")
    private Long commenterId;

    @Schema(description="评论的创建时间，默认为当前时间戳")
    @TableField("created_at")
    private Timestamp createdAt;

    @Schema(description="评论的更新时间，默认为当前时间戳，自动更新")
    @TableField("updated_at")
    private Timestamp updatedAt;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Long commenterId) {
        this.commenterId = commenterId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
        "commentId = " + commentId +
        ", postId = " + postId +
        ", content = " + content +
        ", likes = " + likes +
        ", commenterId = " + commenterId +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
