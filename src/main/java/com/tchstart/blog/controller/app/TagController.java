package com.tchstart.blog.controller.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tchstart.blog.annotation.AccessLimit;
import com.tchstart.blog.model.vo.TagVO;
import com.tchstart.blog.service.TagService;
import com.tchstart.blog.model.R;
import com.tchstart.blog.utils.RUtils;

import java.util.List;

/**
 * Tag Controller
 *
 * @author tchstart
 */
@Validated
@RestController("AppTagController")
@RequestMapping("/api/app/tag")
@Api(value = "前台标签控制器", tags = {"前台标签接口"})
public class TagController {

	@Autowired
	private TagService tagService;

	@AccessLimit(maxCount = 2)
	@GetMapping("/list")
	@ApiOperation("获取全部已使用的博客标签")
	public R listUsed() {
		List<TagVO> tagVOList = tagService.listUsed();
		return RUtils.success("博客标签", tagVOList);
	}

}
