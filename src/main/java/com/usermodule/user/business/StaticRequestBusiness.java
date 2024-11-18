package com.usermodule.user.business;


import com.usermodule.user.dto.RoleDto;

public interface StaticRequestBusiness {
    public String generateAPIResponse(RoleDto roleDto);
}
