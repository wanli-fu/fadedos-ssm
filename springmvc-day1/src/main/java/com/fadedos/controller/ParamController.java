package com.fadedos.controller;

import com.fadedos.entity.User;
import com.fadedos.vo.CollectionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.function.BiConsumer;

/**
 * @Description:用来测试参数接收的Controller
 * @author: pengcheng
 * @date: 2021/2/2
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 测试: 零散类型参数接收
     * 路径: http://localhost:9999/springmvc-day1/param/test?name=fadedos
     * 默认日期格式:  yyyy/MM/dd HH:mm:ss
     * @return
     */
    @RequestMapping("/test1")
    public String test1(String name, Date bir) {
        System.out.println("name = " + name);
        System.out.println("bir = " + bir);
        return "index";
    }

    /**
     * 测试: 对象类型参数接收
     * 接收对象类型:  也是直接将要接收对象作为控制器方法的参数声明
     *
     * 注意:Springmvc 封装对象时直接根据传递参数key与对象中属性名一致自动封装
     *
     * url:  http://localhost:9999/springmvc-day1/param/test2?id=21&name=zhangsan&age=23&bir=2012/12/12
     *
     * form:
     *         input  name="id"
     *         input  name="name"
     *         input  name="age"
     *         ...
     * @return
     */
    @RequestMapping("/test2")
    public String test2(User user,String name) {
        System.out.println("user = " + user);
        System.out.println("name = " + name);
        return "index";
    }

    /**
     * 测试: 数组类型参数接收
     * 接收数组:  将要接收数组类型直接声明为方法的形参即可
     *
     * 注意:保证请求参数多个参数key与声明数组变量名一致 springmvc会自动放入同一个数组中的
     *
     * url:  http://localhost:9999/springmvc-day1/param/test3?qqs=11&qqs=dddd&qqs=12332
     *
     * form: checkbox
     *         input  type="Checkbox" name="qqs" value="看书"
     *         input  type="Checkbox" name="qqs" value="卖报"
     *         input  type="Checkbox" name="qqs" value="吃饭"
     *         input  type="Checkbox" name="qqs" value="打豆豆"
     *         ...
     * @return
     */
    @RequestMapping("/test3")
    public String test3(String[] qqs) {
        for (String qq : qqs) {
            System.out.println("qq = " + qq);
        }
        return "index";
    }

    /**
     * 测试: 集合类型参数接收
     * list  set map
     *
     * 注意:
     *      spring mvc不能直接通过形参列表方式收集集合类型参数
     *      如果要接收集合类型的参数必须将集合放入对象中接收才可以 推荐vo对象中接收集合类型
     *      vo = value Object 值对象
     *  list
     *  url:  http://localhost:9999/springmvc-day1/param/test4?lists=%E5%B0%8F%E5%BC%A0&lists=%E5%B0%8F%E6%9D%8E&lists=fadedos
     *
     *  map
     *      %27 是'
     *      url: http://localhost:9999/springmvc-day1/param/test4?maps[%27a%27]=xiaohei&maps[%27bbb%27]=xiaozhang
     *
     * @return
     */
    @RequestMapping("/test4")
    public String test4(CollectionVO collectionVO) {
/*        //list
        System.out.println("=================");
        collectionVO.getLists().forEach(str-> System.out.println("str = " + str));*/

        //map
        System.out.println("=================");
        collectionVO.getMaps().forEach((k, v) -> System.out.println("k = " + k +"  v="+ v));
        return "index";
    }
}
