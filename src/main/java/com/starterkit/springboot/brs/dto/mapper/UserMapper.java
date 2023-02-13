package com.starterkit.springboot.brs.dto.mapper;

import com.starterkit.springboot.brs.dto.model.user.RoleDto;
import com.starterkit.springboot.brs.dto.model.user.UserDto;
import com.starterkit.springboot.brs.dto.model.user.UserProfileDto;
import com.starterkit.springboot.brs.model.user.Role;
import com.starterkit.springboot.brs.model.user.User;
import com.starterkit.springboot.brs.model.user.UserProfile;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by Arpit Khandelwal.
 */
@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setMobileNumber(user.getMobileNumber())
                .setAdmin(false)
                .setPassword(user.getPassword())
                .setProfilePicture(user.getProfilePicture())
                .setUserProfile(new HashSet<UserProfileDto>(
                        user.getUserProfiles()
                                .stream()
                                .map(profile-> new ModelMapper().map(profile,UserProfileDto.class))
                                .collect(Collectors.toSet())
                ))
                .setRoles(new HashSet<RoleDto>(user
                        .getRoles()
                        .stream()
                        .map(role -> new ModelMapper().map(role, RoleDto.class))
                        .collect(Collectors.toSet())));
    }

    public static User toUser(UserDto user) {
        return new User()
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setMobileNumber(user.getMobileNumber())
                .setUserProfiles(new HashSet<UserProfile>(
                        user.getUserProfile()
                                .stream()
                                .map(profile-> new ModelMapper().map(profile, UserProfile.class))
                                .collect(Collectors.toSet())
                ))
                .setRoles(new HashSet<Role>(user
                        .getRoles()
                        .stream()
                        .map(role -> new ModelMapper().map(role, Role.class))
                        .collect(Collectors.toSet())));
    }

}
