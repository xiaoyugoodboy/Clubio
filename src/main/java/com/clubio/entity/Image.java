package com.clubio.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@TableName("image")
@Schema(description = "图片表")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "使用雪花算法生成的ID作为图片ID")
    @TableId(value = "image_id", type = IdType.ASSIGN_ID)
    private Long imageId;

    @Schema(description = "图片的链接")
    @TableField("url")
    private String url;

    @Schema(description = "图片的描述")
    @TableField("description")
    private String description;

    @Schema(description = "图片所属的帖子ID，引用帖子表的post_id")
    @TableField("post_id")
    private Long postId;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "imageId = " + imageId +
                ", url = " + url +
                ", description = " + description +
                ", postId = " + postId +
                "}";
    }
}
