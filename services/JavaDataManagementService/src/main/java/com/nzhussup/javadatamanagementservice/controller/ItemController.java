package com.nzhussup.javadatamanagementservice.controller;

import com.nzhussup.javadatamanagementservice.model.Item;
import com.nzhussup.javadatamanagementservice.model.Response;
import com.nzhussup.javadatamanagementservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/items")
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    private Response response;

    private Response errorResponse(Exception e) {
        e.printStackTrace();
        response.setMessage(e.getMessage());
        response.setObj(null);
        return response;
    }

    @GetMapping("")
    public String root() {
        return "Item root";
    }

    @GetMapping("/all")
    public Response<List<Item>> getAllItems() {
        try {
            response.setMessage("Successfully retrieved all items");
            response.setObj(itemService.findAll());
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @PostMapping("/add")
    public Response<Item> addItem(Item item) {

        try {
            itemService.add(item);
            response.setObj(itemService.findLastEntry());
            response.setMessage("Item added successfully");
            return response;

        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response<Item> deleteItemById(@PathVariable int id) {
        try {
            itemService.deleteById(id);
            response.setObj(null);
            response.setMessage("Item deleted successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @PutMapping("/update")
    public Response<Item> updateItem(Item item) {
        try {
            itemService.update(item);
            response.setObj(itemService.findById(item.getItemid()));
            response.setMessage("Item updated successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @GetMapping("/{id}")
    public Response<Item> getItemById(@PathVariable int id) {
        try {
            response.setObj(itemService.findById(id));
            response.setMessage("Item found successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    @GetMapping("/last")
    public Response<Item> getLastItem() {
        try {
            response.setObj(itemService.findLastEntry());
            response.setMessage("Item found successfully");
            return response;
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

}
