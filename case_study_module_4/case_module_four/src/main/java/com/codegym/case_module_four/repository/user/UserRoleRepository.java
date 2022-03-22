package com.codegym.case_module_four.repository.user;

import com.codegym.case_module_four.model.user.AppUser;
import com.codegym.case_module_four.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
