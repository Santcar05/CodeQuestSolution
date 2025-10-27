package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Topic;
import org.javeriana.codequest.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public Topic save(Topic topic) {
        topic.setId(null);
        return topicRepository.save(topic);
    }

    public void delete(Topic topic) {
        topicRepository.delete(topic);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public List<Topic> findByModuleId(Long idModule) {
        return topicRepository.findByModuleId(idModule);
    }

    public void update(Topic topic) {
        topicRepository.save(topic);
    }

}
