package dev.application.system_auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAuthRepository extends CrudRepository<SystemAuth, Long> {}