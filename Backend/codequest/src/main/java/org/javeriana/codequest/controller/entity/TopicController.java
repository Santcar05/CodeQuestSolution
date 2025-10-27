package org.javeriana.codequest.controller.entity;

import java.util.List;

import org.javeriana.codequest.entity.ModuleModel;
import org.javeriana.codequest.entity.Topic;
import org.javeriana.codequest.service.entity.ModuleModelService;
import org.javeriana.codequest.service.entity.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private ModuleModelService moduleService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id) {
        return topicService.findById(id);
    }

    @GetMapping("/module/{idModule}")
    public List<Topic> getTopicsByModuleId(@PathVariable Long idModule) {
        return topicService.findByModuleId(idModule);
    }

    @PostMapping("/save/{idModule}")
    public void save(@RequestBody Topic topic, @PathVariable Long idModule) {
        ModuleModel module = moduleService.findById(idModule);
        topic.setModule(module);
        topicService.save(topic);
    }

    @PutMapping("/update")
    public void update(@RequestBody Topic topic) {
        topicService.update(topic);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Topic topic = topicService.findById(id);
        topicService.delete(topic);
    }
}
