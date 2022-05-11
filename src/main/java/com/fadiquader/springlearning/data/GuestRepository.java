package com.fadiquader.springlearning.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository // not required
public interface GuestRepository extends CrudRepository<Guest, Long> {
}

