package com.decta.homework.cardissue.privateindividual;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PrivateClientRepository extends CrudRepository<PrivateClientEntity, Long> {

}
