package io.oken1.modules.mug.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "过滤器接口", tags = {"过滤器接口"})
@RestController
@RequestMapping("/mug/filter")
public class FilterController {
}
