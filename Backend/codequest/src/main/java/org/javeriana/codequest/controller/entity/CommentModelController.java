package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.CommentModel;
import org.javeriana.codequest.service.entity.CommentModelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/commentModel")
public class CommentModelController {

    private CommentModelService commentModelService;

    public CommentModelController(CommentModelService commentModelService) {
        this.commentModelService = commentModelService;
    }

    @GetMapping("/all")
    public List<CommentModel> findAll() {
        return commentModelService.findAll();
    }

    @GetMapping("/{id}")
    public CommentModel findById(@PathVariable Long id) {
        return commentModelService.findById(id);
    }
}
