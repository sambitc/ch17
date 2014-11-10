package com.apress.prospring3.ch17.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.apress.prospring3.ch17.domain.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}