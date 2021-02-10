package com.fadedos.proxy;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/24
 */
public class OrderServiceProxy implements OrderService {

    //原始对象
    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        //增加日志功能
        System.out.println("-----log-----");
        orderService.showOrder();
    }
}
