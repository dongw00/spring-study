package com.example.springdb.repository;

import com.example.springdb.domain.Item;
import com.example.springdb.dto.ItemSearchCond;
import com.example.springdb.dto.ItemUpdateDto;
import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);

}
