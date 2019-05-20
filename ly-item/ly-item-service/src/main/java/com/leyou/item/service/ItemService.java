package com.leyou.item.service;

import com.leyou.item.pojo.Item;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ItemService {
    public Item saveItem(Item item){
        //商品新增
        int id = new Random().nextInt(300);
        item.setId(id);
        return item;
    }
}
