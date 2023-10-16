package com.clubio.service.impl;

import com.clubio.entity.Image;
import com.clubio.mapper.ImageMapper;
import com.clubio.service.ImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

}
