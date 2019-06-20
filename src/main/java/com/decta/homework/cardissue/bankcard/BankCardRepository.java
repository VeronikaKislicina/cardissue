package com.decta.homework.cardissue.bankcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BankCardRepository extends CrudRepository<BankCardEntity, Long> {
}
