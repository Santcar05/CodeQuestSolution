package org.javeriana.codequest.repository;

import org.javeriana.codequest.entity.FeaturedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeaturedUserRepository extends JpaRepository<FeaturedUser, Long> {

}
