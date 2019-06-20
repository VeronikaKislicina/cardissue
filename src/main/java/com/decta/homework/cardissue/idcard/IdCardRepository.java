package com.decta.homework.cardissue.idcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IdCardRepository extends CrudRepository<IdCardEntity, Long> {

    IdCardEntity findByPersonalNumber(String personalNumber);

}
