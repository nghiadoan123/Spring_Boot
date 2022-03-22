package com.codegym.case_module_four.repository.user;

import com.codegym.case_module_four.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUserName(String username);
}
