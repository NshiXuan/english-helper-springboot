package com.en.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.en.mapStruct.MapStructs;
import com.en.pojo.po.CollectWord;
import com.en.pojo.po.Collects;
import com.en.pojo.po.Users;
import com.en.pojo.po.Words;
import com.en.pojo.vo.list.CollectsVo;
import com.en.pojo.vo.req.save.CollectWordReqVo;
import com.en.pojo.vo.req.save.CollectsReqVo;
import com.en.service.CollectWordService;
import com.en.service.CollectsService;
import com.en.service.UsersService;
import com.en.service.WordsService;
import com.en.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/collects")
public class CollectsController extends BaseController<Collects, CollectsReqVo> {
  @Autowired
  private CollectsService service;

  @Autowired
  private UsersService usersService;

  @Autowired
  private CollectWordService collectWordService;

  @Autowired
  private WordsService wordsService;

  /**
   * 如果用户id查询收藏夹列表
   *
   * @param user_id
   * @return
   */
  @GetMapping("user")
  public R getCollectById(Integer user_id) {
    LambdaQueryWrapper<Collects> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(Collects::getUserId, user_id);
    return R.success(service.list(wrapper));
  }

  /**
   * 通过名称查询收藏夹
   *
   * @param name
   * @return
   */
  @GetMapping("name")
  public R getCollectByName(String name) {
    // 1.通过名称查询收藏夹
    LambdaQueryWrapper<Collects> collectWrapper = new LambdaQueryWrapper<>();
    collectWrapper.eq(Collects::getName, name);
    Collects collectRes = service.getOne(collectWrapper);

    // 2.通过收藏夹数据的user_id获取用户
    Users userRes = usersService.getById(collectRes.getUserId());

    // 3.获取收藏夹单词映射表的word_id 获取到单词List
    // 3.1 获取映射表的List
    LambdaQueryWrapper<CollectWord> cwWrapper = new LambdaQueryWrapper<>();
    cwWrapper.eq(CollectWord::getCollectId, collectRes.getId());
    List<CollectWord> collectWordList = collectWordService.list(cwWrapper);

    // 3.2 遍历获取到word_id的List
    List<Integer> idsList = new ArrayList<>();
    for (CollectWord collectWord : collectWordList) {
      idsList.add(collectWord.getWordId());
    }

    // 3.3 获取word_id的List获取单词列表
    List<Words> wordsListRes = wordsService.listByIds(idsList);

    // 4.把数据映射到CollectVo
    CollectsVo collectsVo = new CollectsVo();
    collectsVo.setId(collectRes.getId());
    collectsVo.setName(collectRes.getName());
    collectsVo.setUser(userRes);
    collectsVo.setWords(wordsListRes);
    return R.success(collectsVo);
  }

  /**
   * 获取收藏夹列表
   *
   * @return
   */
  @GetMapping("/list")
  public R getCollectList() {
    // 1. 构造返回的CollectVo数组
    List<CollectsVo> collectsListVo = new ArrayList<>();

    // 2. 获取po List
    List<Collects> collectsListRes = service.list();

    // 3. 通过po List的user_id获取用户数据
    for (Collects collectsRes : collectsListRes) {
      CollectsVo collectsVo = new CollectsVo();

      // 3.1 通过user_id获取用户数据
      Users user = usersService.getById(collectsRes.getUserId());

      // 3.2 赋给CollectsVo
      collectsVo.setUser(user);
      collectsVo.setId(collectsRes.getId());
      collectsVo.setName(collectsRes.getName());
      System.out.println(collectsVo);

      // 3.3 添加给collectsListVo
      collectsListVo.add(collectsVo);
    }

    return R.success(collectsListVo);
  }

  /**
   * 收藏单词
   *
   * @return
   */
  @PostMapping("/word")
  public R addWordToCollect(@RequestBody CollectWordReqVo reqVo) {
    System.out.println("addWordToCollect" + reqVo);
    CollectWord collectWord = new CollectWord();
    collectWord.setCollectId(reqVo.getCollectId());
    collectWord.setWordId(reqVo.getWordId());
    System.out.println(collectWord);

    // 1.查收是否已收藏
    LambdaQueryWrapper<CollectWord> wrapper = new LambdaQueryWrapper<>();
    // 单词id与收藏夹id都存在则改收藏夹中单词已存在
    wrapper.eq(CollectWord::getWordId, reqVo.getWordId());
    wrapper.eq(CollectWord::getCollectId, reqVo.getCollectId());
    if (collectWordService.getOne(wrapper) != null) {
      return R.error("单词已存在");
    }

    if (collectWordService.save(collectWord)) {
      return R.ok("添加成功");
    }

    return R.error("添加失败");
  }


  // @PostMapping("/word")
  // public R addWordToCollect(@RequestParam Integer collect_id, Integer word_id) {
  //   System.out.println("addWordToCollect" + collect_id + word_id);
  //   CollectWord collectWord = new CollectWord();
  //   // collectWord.setCollectId(collect_id);
  //   // collectWord.setWordId(word_id);
  //   System.out.println(collectWord);
  //   // if (collectWordService.save(collectWord)) {
  //   //   return R.ok("添加成功");
  //   // }
  //
  //   return R.error("添加失败");
  // }


  // 删除
  @DeleteMapping("delete")
  public R deleteCollect(Integer id) {
    // 1.通过收藏夹id删除收藏夹
    service.removeById(id);

    // 2.通过收藏夹id删除收藏夹与单词的联系
    LambdaQueryWrapper<CollectWord> cwWrapper = new LambdaQueryWrapper<>();
    cwWrapper.eq(CollectWord::getCollectId, id);
    if (collectWordService.remove(cwWrapper)) {
      return R.ok("删除成功");
    }

    return R.ok("删除成功");
  }


  @Override
  protected IService<Collects> getService() {
    return service;
  }

  @Override
  protected Function<CollectsReqVo, Collects> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

