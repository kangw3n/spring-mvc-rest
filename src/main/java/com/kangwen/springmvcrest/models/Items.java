package com.kangwen.springmvcrest.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Items {
    @Id
    public ObjectId _id;

    public String name;
    public String description;
    public int qty;

    public Items(ObjectId _id, String name, String description, int qty) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.qty = qty;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
