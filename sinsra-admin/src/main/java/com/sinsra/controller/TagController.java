package com.sinsra.controller;/*
 * ClassName: TagController
 * Package: com.sinsra.controller
 * @Create: 2024/5/8 21:02
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.domain.dto.EditTagDto;
import com.sinsra.domain.entity.Tag;
import com.sinsra.domain.dto.AddTagDto;
import com.sinsra.domain.dto.TagListDto;
import com.sinsra.service.TagService;
import com.sinsra.util.BeanCopyUtils;
import com.sinsra.domain.vo.PageVo;
import com.sinsra.domain.vo.TagVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Resource
    //TagService是我们在sinsra-framework工程的接口
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.okResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        tagService.removeById(id);
        return ResponseResult.okResult();
    }

    @PutMapping
    public ResponseResult edit(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.copyBean(tagDto,Tag.class);
        tagService.updateById(tag);
        return ResponseResult.okResult();
    }


    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Tag tag = tagService.getById(id);
        return ResponseResult.okResult(tag);
    }


    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.okResult(list);
    }
}
