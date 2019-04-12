package com.kangwen.springmvcrest.controllers;

import com.kangwen.springmvcrest.models.Items;
import com.kangwen.springmvcrest.respositories.ItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(ItemController.BASE_URL)
public class ItemController {
    public static final String BASE_URL = "/api/v1/items";

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Items> getAllItems() {
        return repository.findAll();
    }

    @GetMapping(path="/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public Items getItemById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @GetMapping("/search/{kw}")
    public List<Items> searchByName(@PathVariable("kw") String kw) {
        return repository.findByNameContaining(kw);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable("id") ObjectId id, @Valid @RequestBody Items item) {
        item.set_id(id);
        repository.save(item);
    }

    @PostMapping
    public Items createItem(@Valid @RequestBody Items item) {
        item.set_id(ObjectId.get());
        repository.save(item);
        return item;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }


}
