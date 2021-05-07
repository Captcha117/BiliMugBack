package io.oken1.modules.person.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.person.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "人物", tags = {"人物"})
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @ApiOperation("曲目艺术家标签化")
    @GetMapping("/processSongArtist")
    public R processSongArtist(@RequestParam String gameId) {
        if (StringUtils.isBlank(gameId)) {
            return R.error();
        }
        personService.processSongArtist(gameId);
        return R.ok();
    }
}
