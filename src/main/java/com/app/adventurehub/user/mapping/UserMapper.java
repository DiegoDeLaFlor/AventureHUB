package com.app.adventurehub.user.mapping;

import com.app.adventurehub.shared.mapping.EnhancedModelMapper;
import com.app.adventurehub.user.domain.model.entity.User;
import com.app.adventurehub.user.resource.CreateUserResource;
import com.app.adventurehub.user.resource.UserResource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private EnhancedModelMapper modelMapper;

    public UserMapper userMapper() {
        return new UserMapper(modelMapper);
    }

    public Page<UserResource> modelListPage(List<UserResource> modelList, Pageable pageable) {
        return new PageImpl<>(modelMapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public User toModel(CreateUserResource resource) {
        return modelMapper.map(resource, User.class);
    }

    public UserResource toResource(User user) {
        return new UserResource(user.getId(), user.getEmail());
    }

}

