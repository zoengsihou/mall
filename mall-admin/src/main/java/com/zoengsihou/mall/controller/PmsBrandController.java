package com.zoengsihou.mall.controller;

import com.zoengsihou.mall.common.api.Result;
import com.zoengsihou.mall.common.api.ResultPage;
import com.zoengsihou.mall.dto.PmsBrandParam;
import com.zoengsihou.mall.model.PmsBrand;
import com.zoengsihou.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 * @author zoengsihou
 */

@Api(value = "品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation(value = "获取品牌列表")
    @GetMapping("/listAll")
    public Result<List<PmsBrand>> getList() {
        return Result.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping("/create")
    public Result create(@Validated @RequestBody PmsBrandParam pmsBrandParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return Result.failed(defaultMessage);
        } else {
            int count = pmsBrandService.createBrand(pmsBrandParam);
            if (count == 1) {
                return Result.success(count);
            } else {
                return Result.failed();
            }
        }
    }

    @ApiOperation(value = "更新品牌")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable Long id,
                         @Validated @RequestBody PmsBrandParam pmsBrandParam,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return Result.failed(defaultMessage);
        } else {
            int count = pmsBrandService.updateBrand(id, pmsBrandParam);
            if (count == 1) {
                return Result.success(count);
            } else {
                return Result.failed();
            }
        }
    }

    @ApiOperation(value = "删除品牌")
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            return Result.success(null);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation(value = "批量删除品牌")
    @PostMapping("/delete/batch")
    public Result deleteBatch(@RequestParam List<Long> ids) {
        int count = pmsBrandService.deleteBrand(ids);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation(value = "关键字搜索品牌名称并分页")
    @GetMapping("/list")
    public Result<ResultPage<PmsBrand>> getList(@RequestParam(required = false) String keyword,
                                                @RequestParam(defaultValue = "1") Integer pageNum,
                                                @RequestParam(defaultValue = "5") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.listBrand(keyword, pageNum, pageSize);
        return Result.success(ResultPage.createPage(brandList));
    }

    @ApiOperation(value = "根据id获取品牌信息")
    @GetMapping("/{id}")
    public Result<PmsBrand> getItem(@PathVariable Long id) {
        return Result.success(pmsBrandService.getBrand(id));
    }

    @ApiOperation(value = "批量更新显示状态")
    @PostMapping("/update/showStatus")
    public Result updateShowStatus(@RequestParam List<Long> ids,
                                   @RequestParam Integer showStatus) {
        int count = pmsBrandService.updateShowStatus(ids, showStatus);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @PostMapping("/update/factoryStatus")
    public Result updateFactoryStatus(@RequestParam List<Long> ids,
                                      @RequestParam Integer factoryStatus) {
        int count = pmsBrandService.updateFactoryStatus(ids, factoryStatus);
        if (count > 0) {
            return Result.success(count);
        } else {
            return Result.failed();
        }
    }
}
