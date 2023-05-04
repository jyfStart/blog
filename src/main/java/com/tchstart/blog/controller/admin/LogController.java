package com.tchstart.blog.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.tchstart.blog.model.PageResult;
import com.tchstart.blog.model.R;
import com.tchstart.blog.model.entity.LogEntity;
import com.tchstart.blog.model.params.ListParam;
import com.tchstart.blog.model.params.LogSearchParam;
import com.tchstart.blog.model.vo.LogVO;
import com.tchstart.blog.service.LogService;
import com.tchstart.blog.utils.RUtils;

import javax.validation.Valid;

/**
 * Log Controller
 *
 * @author tchstart
 */
@Validated
@RestController("AdminLogController")
@RequestMapping("/api/admin/log")
@Api(value = "后台日志控制器", tags = {"后台日志接口"})
public class LogController {

	@Autowired
	private LogService logService;


	@PostMapping("/list")
	@ApiOperation("获取日志列表信息")
	public R listBlogs(@RequestBody @Valid LogSearchParam param) {
		IPage<LogEntity> page = logService.pageBy(param);
		PageResult<LogVO> pageResult = logService.covertToPageResult(page);
		return RUtils.success("日志列表信息", pageResult);
	}

	@DeleteMapping("/delete")
	@ApiOperation("批量删除评论")
	public R delete(@RequestBody @Validated ListParam<Integer> logIds) {
		int i = logService.deleteByIds(logIds);
		return RUtils.commonFailOrNot(i, "批量删除日志");
	}

}
