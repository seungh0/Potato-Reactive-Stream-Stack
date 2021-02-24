package com.potato.domain.resume;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ReactiveMongoRepository<Resume, String> {

}
