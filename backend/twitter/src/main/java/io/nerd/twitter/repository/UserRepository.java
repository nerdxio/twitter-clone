/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/25/2023 9:01 AM
 */
package io.nerd.twitter.repository;

import io.nerd.twitter.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser,Integer> {
    Optional<ApplicationUser> findByUsername(String username);
}
