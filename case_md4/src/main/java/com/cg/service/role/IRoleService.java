package com.cg.service.role;

import com.cg.model.Role;
import com.cg.model.dto.RoleDTO;
import com.cg.service.IGeneralService;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);

    List<RoleDTO> getAllRole();
}
