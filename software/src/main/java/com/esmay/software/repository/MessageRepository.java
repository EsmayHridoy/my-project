package com.esmay.software.repository;

import com.esmay.software.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Integer> {
}
