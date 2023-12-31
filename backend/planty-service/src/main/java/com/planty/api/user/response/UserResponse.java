package com.planty.api.user.response;

import com.planty.common.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponse {

    private Long uid;
    private String userId;
    private String username;
    private String userEmail;
    private Integer emergencyCount;
    private String shippingAddress;
    private UserType userType;

}