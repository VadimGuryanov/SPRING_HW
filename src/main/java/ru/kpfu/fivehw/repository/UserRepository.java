package ru.kpfu.fivehw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.fivehw.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
