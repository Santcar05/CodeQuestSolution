package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.MenuItem;
import org.javeriana.codequest.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public void save(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    public void delete(MenuItem menuItem) {
        menuItemRepository.delete(menuItem);
    }

    public void deleteById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }
}
