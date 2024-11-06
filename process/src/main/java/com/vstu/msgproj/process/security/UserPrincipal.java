package com.vstu.msgproj.process.security;//package com.vstu.msgProject.security;
//
//import com.vstu.msgProject.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//
//import java.util.Collection;
//
//public class UserPrincipal implements UserDetails {
//
//    private final User user;
//
//    public UserPrincipal(User user) {
//        this.user = user;
//    }
//
//    public static UserPrincipal create(User user) {
//        return new UserPrincipal(user);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // 返回用户的角色权限
//        return null; // 替换为实际的权限集合
//    }
//
//    @Override
//    public String getPassword() {
//        return "";
//    }
//
//    @Override
//    public String getUsername() {
//        return "";
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // 假设账户始终有效
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // 假设账户始终未锁定
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // 假设凭证始终有效
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // 假设用户始终启用
//    }
//}