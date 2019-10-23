package com.zoengsihou.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 品牌参数传递对象
 * @author zoengsihou
 */

@ApiModel(value = "品牌")
public class PmsBrandParam {
    @ApiModelProperty(value = "品牌名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @ApiModelProperty(value = "是否进行显示")
    private Integer showStatus;

    @ApiModelProperty(value = "品牌logo")
    @NotBlank(message = "品牌logo不能为空")
    private String logo;

    @ApiModelProperty(value = "专区大图")
    private String bigPic;

    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}