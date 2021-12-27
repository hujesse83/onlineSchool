package com.hujesse.onlineSchool;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hujesse.onlineSchool.mapper.UserMapper;
import com.hujesse.onlineSchool.entity.User;
import com.hujesse.onlineSchool.mapper.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Slf4j
class OnlineSchoolApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    void queryTest() {
        // query
        List<User> users = userMapper.selectList(null);
        log.info("{}", users);

    }

    @Test
    void testAdd() {
        //insert
        User insertUser = User.builder().age(100).email("testDelete").name("testDelete").build();
        userMapper.insert(insertUser);
    }

    @Test
    void update() {
        User user = userMapper.selectById(4L);
        user.setName("updatedNameAgain");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    void query() {
        userMapper.selectById(4L);
        userMapper.selectBatchIds(Arrays.asList(2, 3));
        // 通过map查询
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "seh");
        map.put("age", 23);
        userMapper.selectByMap(map);
    }

    @Test
    void testPage() {
        // 当前页 和 每页记录数
        Page<User> page = new Page<>(1, 3);
        Page<User> res = userMapper.selectPage(page, null);
        List<User> records = res.getRecords();
        records.forEach(System.out::println);
        System.out.println("当前页" + page.getCurrent());
        System.out.println("每页显示记录数" + page.getSize());
        System.out.println("总记录数" + page.getTotal());
        System.out.println("总叶数" + page.getPages());
        System.out.println("是否有上页" + page.hasPrevious());
        System.out.println("是否有下页" + page.hasNext());
    }

    @Test
    void testDelete() {
        int i = userMapper.deleteById(1);
        System.out.println(i);
    }

    @Test
    void testQueryWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("id", 2);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
        /**
         * ge : greater equals
         * gt: greater than
         * le : lesser equals
         * lt : lesser than
         * eq: equals.       等于 常用
         * ne：not equals  不等于
         * -----
         * between("age",10,20)
         * like("name",e);
         * orderByDesc("id")  根据id降序
         * 指定要查询的列
         * select("id","name")  只会查询这二个字段
         */


    }

}
