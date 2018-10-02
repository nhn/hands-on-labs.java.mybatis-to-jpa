package com.nhnent.forward.mybatistojpa.mapper;

import com.nhnent.forward.mybatistojpa.model.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    int getItemCount();

    List<Item> getItems(@Param("offset") int offset, @Param("limit") int limit);

    Item getItem(Long itemId);

    int insertItem(Item item);

    int updateItem(Item item);

    int deleteItem(Long itemId);

}
