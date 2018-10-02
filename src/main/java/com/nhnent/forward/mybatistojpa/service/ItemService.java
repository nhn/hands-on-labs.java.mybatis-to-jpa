package com.nhnent.forward.mybatistojpa.service;

import com.nhnent.forward.mybatistojpa.entity.ItemEntity;
import com.nhnent.forward.mybatistojpa.model.Item;
import com.nhnent.forward.mybatistojpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems(Pageable pageable) {
        Page<ItemEntity> itemPage = itemRepository.findAll(pageable);

        return itemPage.getContent()
                       .stream()
                       .map(ItemEntity::toItemDto)
                       .collect(Collectors.toList());
    }

    public Item getItem(Long itemId) {
        return itemRepository.findOne(itemId).toItemDto();
    }

    @Transactional
    public Item createItem(Item item) {
        ItemEntity entity = new ItemEntity();
        entity.setItemName(item.getItemName());
        entity.setPrice(item.getPrice());

        return itemRepository.save(entity).toItemDto();
    }

    @Transactional
    public Item updateItem(Item item) {
        ItemEntity entity = new ItemEntity();
        entity.setItemId(item.getItemId());
        entity.setItemName(item.getItemName());
        entity.setPrice(item.getPrice());

        return itemRepository.save(entity).toItemDto();
    }

    @Transactional
    public boolean deleteItem(Long itemId) {
        itemRepository.delete(itemId);
        return true;
    }

}
