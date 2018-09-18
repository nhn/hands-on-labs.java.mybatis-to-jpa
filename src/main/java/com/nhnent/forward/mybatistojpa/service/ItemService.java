package com.nhnent.forward.mybatistojpa.service;

import com.nhnent.forward.mybatistojpa.mapper.ItemMapper;
import com.nhnent.forward.mybatistojpa.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;

    public List<Item> getItems(int pageNumber, int pageSize) {
        int totalCount = itemMapper.getItemCount();

        int pageOffset = (pageNumber - 1) * pageSize;
        if (pageOffset >= totalCount) {
            return Collections.emptyList();
        }

        return itemMapper.getItems(pageOffset, pageSize);
    }

    public Item getItem(Long itemId) {
        return itemMapper.getItem(itemId);
    }

}
