package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.*;
import com.kaufland.vmdb.dto.HumanDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface CrewService {

    <T extends Human> List<T> findCrewByRole(Class<T> role);

    default <T extends Human> List<T> findCrewByRoleName(String role){
        if(role.equalsIgnoreCase("actor")){
            return (List<T>) findCrewByRole(Actor.class);
        }
        if(role.equalsIgnoreCase("director")){
            return (List<T>) findCrewByRole(Director.class);
        }
        if(role.equalsIgnoreCase("writer")){
            return (List<T>) findCrewByRole(Writer.class);
        }
        if(role.equalsIgnoreCase("producer")){
            return (List<T>) findCrewByRole(Producer.class);
        }
        return null;
    }

    default List<HumanDTO> findCrewByRoleNameDTO(String role){
        return findCrewByRoleName(role).stream().map(HumanDTO::new).collect(Collectors.toList());
    }
}
