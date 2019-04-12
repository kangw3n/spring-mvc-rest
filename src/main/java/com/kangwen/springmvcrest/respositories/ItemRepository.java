package com.kangwen.springmvcrest.respositories;

import com.kangwen.springmvcrest.models.Items;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Items, String> {
    Items findBy_id(ObjectId _id);
    List<Items> findByNameContaining(String string);
}
