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
 * 帖子表
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@TableName("post")
@Schema(description = "帖子表")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "使用雪花算法生成的ID作为帖子ID")
    @TableId(value = "post_id", type = IdType.ASSIGN_ID)
    private Long postId;

    @Schema(description = "帖子的标题")
    @TableField("title")
    private String title;

    @Schema(description = "帖子的内容")
    @TableField("content")
    private String content;

    @Schema(description = "帖子的点赞数")
    @TableField("likes")
    private Integer likes;

    @Schema(description = "帖子的作者ID，引用用户表的user_id")
    @TableField("author_id")
    private Long authorId;

    @Schema(description = "帖子的创建时间，默认为当前时间戳")
    @TableField("created_at")
    private Timestamp createdAt;

    @Schema(description = "帖子的更新时间，默认为当前时间戳，自动更新")
    @TableField("updated_at")
    private Timestamp updatedAt;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
        return "Post{" +
                "postId = " + postId +
                ", title = " + title +
                ", content = " + content +
                ", likes = " + likes +
                ", authorId = " + authorId +
                ", createdAt = " + createdAt +
                ", updatedAt = " + updatedAt +
                "}";
    }
}
