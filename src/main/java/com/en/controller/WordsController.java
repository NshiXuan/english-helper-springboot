package com.en.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.en.mapStruct.MapStructs;
import com.en.pojo.po.Sentences;
import com.en.pojo.po.WordSentence;
import com.en.pojo.po.Words;
import com.en.pojo.vo.req.save.WordsReqVo;
import com.en.service.SentencesService;
import com.en.service.WordSentenceService;
import com.en.service.WordsService;
import com.en.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordsController {
  @Autowired
  private WordsService service;

  @Autowired
  private SentencesService sentencesService;

  @Autowired
  private WordSentenceService wordSentenceService;

  /**
   * 查询单个单词
   *
   * @param word 单词名称
   * @return 单词数据
   */
  @GetMapping
  public R getWord(String word) {
    return R.success(service.getWord(word));
  }


  /**
   * 添加单词
   *
   * @param wordsReqVo
   * @return
   */
  @PostMapping
  @Transactional
  // 记得把@RequestBody拿过来
  public R save(@Valid @RequestBody WordsReqVo wordsReqVo) {
    System.out.println(wordsReqVo + "wordsReqVo");
    // 1.添加单词数据到单词表
    Words words = MapStructs.INSTANCE.reqVo2po(wordsReqVo);
    service.saveOrUpdate(words);
    // MP添加成功后就可以直接拿到新数据的id
    // System.out.println(words.getId());

    // 2.添加例句到例句表 并在单词例句联系表中添加映射关系
    List<Sentences> sentences = wordsReqVo.getSentences();
    for (Sentences sentence : sentences) {
      // 2.1添加例句到例句表中
      sentencesService.saveOrUpdate(sentence);
      System.out.println(sentence.getId());

      // 2.2添加单词例句联系到联系表
      // 映射po
      WordSentence wordSentence = new WordSentence();
      wordSentence.setWordId(words.getId());
      wordSentence.setSentenceId(sentence.getId());
      // System.out.println(wordSentence);
      wordSentenceService.save(wordSentence);
    }

    return R.ok("添加成功");
  }

  /**
   * 删除单词
   *
   * @param id 单词id
   * @return
   */
  @DeleteMapping
  @Transactional
  public R remove(@RequestParam String id) {
    // 1.删除单词
    service.removeById(id);

    // 2.通过单词id查询例句id
    LambdaQueryWrapper<WordSentence> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(WordSentence::getWordId, id);
    List<WordSentence> wordSentenceList= wordSentenceService.list(wrapper);

    // 3.删除例句
    for (WordSentence wordSentence : wordSentenceList) {
      sentencesService.removeById(wordSentence.getSentenceId());
    }

    // 4.删除联系表的映射 有2个 多个也会删除
    wordSentenceService.remove(wrapper);

    return R.ok("删除成功");
  }

  /**
   * 获取单词列表
   * @return
   */
  @GetMapping("/list")
  public R getWordList(){
    return R.success(service.getWordList());
  }
}

