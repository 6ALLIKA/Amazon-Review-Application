package com.ma.springboot.service;

import com.ma.springboot.model.Role;

public interface RoleService extends EntityService<Role> {

    Role findByRoleName(Role.RoleName roleName);
}
