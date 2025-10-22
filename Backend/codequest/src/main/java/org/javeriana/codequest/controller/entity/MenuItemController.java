package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.MenuItem;
import org.javeriana.codequest.service.entity.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/MenuItem")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    public MenuItemService getMenuItemService() {
        return menuItemService;
    }

    @GetMapping("/all")
    public List<MenuItem> findAll() {
        return menuItemService.findAll();
    }

    @GetMapping("/{id}")
    public MenuItem findById(@PathVariable Long id) {
        return menuItemService.findById(id);
    }
}
