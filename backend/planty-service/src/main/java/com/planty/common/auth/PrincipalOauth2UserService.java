//package com.planty.common.auth;
//
//import com.planty.common.enums.Role;
//import com.planty.db.entity.UserInfo;
//import com.planty.db.repository.UserInfoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
//
//    @Autowired
//    private UserInfoRepository userInfoRepository;
//    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        String provider = userRequest.getClientRegistration().getRegistrationId();    // google
//        String providerId = oAuth2User.getAttribute("sub");
//        String username = provider+"_"+providerId;  			// 사용자가 입력한 적은 없지만 만들어준다
//
//        String uuid = UUID.randomUUID().toString().substring(0, 6);
//        String password = bCryptPasswordEncoder.encode("패스워드"+uuid);  // 사용자가 입력한 적은 없지만 만들어준다
//
//        String email = oAuth2User.getAttribute("email");
//        Role role = Role.ROLE_USER;
//
//        UserInfo byEmail = userInfoRepository.findByUserEmail(email)
//                .orElse(null);
//
//        //DB에 없는 사용자라면 회원가입처리
//        if(byEmail == null){
//            byEmail = UserInfo.oauth2Register()
//                    .username(username).password(password).email(email).role(role)
//                    .provider(provider).providerId(providerId)
//                    .build();
//            System.out.println(password.length());
//            userInfoRepository.save(byEmail);
//        }
//
//        return new PrincipalDetails(byEmail, oAuth2User.getAttributes());
//    }
//}
