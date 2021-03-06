package com.leyou.item.web;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.Item;
import com.leyou.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    //REST风格的返回
    public ResponseEntity<Item> savaItem(Item item){
        //校验价格
        if (item.getPrice()==null){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            throw  new LyException(ExceptionEnums.PRIVICE_CAN_BE_NULL);
        }
        item = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
