package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

        List<Permission> findAllByName(String name);
}
