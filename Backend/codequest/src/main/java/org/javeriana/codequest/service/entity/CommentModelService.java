package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.CommentModel;
import org.javeriana.codequest.repository.CommentModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentModelService {

    @Autowired
    private CommentModelRepository commentModelRepository;

    public void save(CommentModel commentModel) {
        commentModel.setId(null);
        commentModelRepository.save(commentModel);
    }

    public void delete(CommentModel commentModel) {
        commentModelRepository.delete(commentModel);
    }

    public void deleteById(Long id) {
        commentModelRepository.deleteById(id);
    }

    public CommentModel findById(Long id) {
        return commentModelRepository.findById(id).orElse(null);
    }

    public List<CommentModel> findAll() {
        return commentModelRepository.findAll();
    }

    public void update(CommentModel commentModel) {
        commentModelRepository.save(commentModel);
    }
}
