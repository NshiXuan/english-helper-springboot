package com.en.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.en.mapStruct.MapStructs;
import com.en.pojo.po.Words;
import com.en.pojo.vo.req.save.WordsReqVo;
import com.en.service.WordsService;
import com.en.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.function.Function;

@RestController
@RequestMapping("/words")
public class WordsController extends BaseController<Words, WordsReqVo> {
    @Autowired
    private WordsService service;

    /**
     * 查询单个单词
     * @param word 单词名称
     * @return 单词数据
     */
    @GetMapping
    public R getWord(String word)   {
        return R.success( service.getWord(word));
    }



    /**
     * 添加或者修改单词
     * @param ReqVo
     * @return
     */
    @PostMapping
    @Override
    // 记得把@RequestBody拿过来
    public R save(@Valid @RequestBody  WordsReqVo ReqVo) {
        System.out.println(ReqVo+"wordsReqVo");
        // return super.save(wordsReqVo);
        return null;
    }

    // 相当于子传父
    @Override
    protected IService<Words> getService() {
        // 把service传递给父类抽象的Iservice(service继承了Iservice) 供父类使用
        return service;
    }

    @Override
    protected Function<WordsReqVo, Words> getFunction() {
        // 把MapStructs中的reqVo2po方法传递给父类抽象的函数 供父类使用
        return MapStructs.INSTANCE::reqVo2po;
    }
}

