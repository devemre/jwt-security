package com.devemre.jwtsecurity.repository;

import com.devemre.jwtsecurity.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    public Optional<Authority> findByName(String name);

}
