package com.zoengsihou.mall.service;

import com.zoengsihou.mall.dto.PmsBrandParam;
import com.zoengsihou.mall.model.PmsBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌管理Service
 * @author zoengsihou
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrandParam pmsBrandParam);

    @Transactional
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);

    int deleteBrand(Long id);

    int deleteBrand(List<Long> ids);

    List<PmsBrand> listBrand(String keyword, Integer pageNum, Integer pageSize);

    PmsBrand getBrand(Long id);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    int updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
