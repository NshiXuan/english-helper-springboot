package com.en.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.en.utils.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.function.Function;

@Validated
public abstract class BaseController<Po, ReqVo> {
  // IService泛型与po挂钩，与数据库挂钩，不能乱改
  protected abstract IService<Po> getService();

  // reqVo转成Po
  protected abstract Function<ReqVo, Po> getFunction();

  @PostMapping("/remove")
  public R remove(@NotBlank(message = "id不能为空")
                       @Min(0) // RequestParam让返回id为query类型
                       @RequestParam String id) {
    String[] idStrs = id.split(",");
    if (getService().removeByIds(Arrays.asList(idStrs))) {
      return R.ok("删除成功");
    } else {
      return R.error("删除失败");
    }
  }

  @PostMapping("/save")
  public R save(@Valid @RequestBody ReqVo reqVo) {
    // 把reqVo转成po
    Po po = getFunction().apply(reqVo);
    if (getService().saveOrUpdate(po)) {
      return R.ok("保存成功");
    } else {
      return R.error("保存失败");
      // return JsonVos.error("保存失败");
    }
  }
}
