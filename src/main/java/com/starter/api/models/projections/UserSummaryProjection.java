package com.starter.api.models.projections;

import com.starter.api.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "UserSummary", types = { User.class })
public interface UserSummaryProjection {

    Long getId();

    String getEmail();

    @Value("#{target.firstname} #{target.lastname}")
    String getFullName();

}

