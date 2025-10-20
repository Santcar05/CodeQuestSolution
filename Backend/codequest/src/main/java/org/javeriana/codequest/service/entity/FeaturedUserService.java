package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.FeaturedUser;
import org.javeriana.codequest.repository.FeaturedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeaturedUserService {

    @Autowired
    private FeaturedUserRepository featuredUserRepository;

    public void save(FeaturedUser featuredUser) {
        featuredUserRepository.save(featuredUser);
    }

    public void delete(FeaturedUser featuredUser) {
        featuredUserRepository.delete(featuredUser);
    }

    public void deleteById(Long id) {
        featuredUserRepository.deleteById(id);
    }

    public FeaturedUser findById(Long id) {
        return featuredUserRepository.findById(id).orElse(null);
    }

    public List<FeaturedUser> findAll() {
        return featuredUserRepository.findAll();
    }

}
