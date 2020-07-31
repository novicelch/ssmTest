package cn.liu.realm;

import cn.liu.dao.PermissionsMapper;
import cn.liu.dao.RoleMapper;
import cn.liu.pojo.Permissions;
import cn.liu.pojo.Role;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
     RoleMapper mapper;
    @Autowired
     PermissionsMapper psm;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String pri = (String)principalCollection.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String>();
//        if("user".equals(pri)){
//            roles.add("user");
//        }
        List<Permissions> list = psm.queryRolesBypri(pri);
        for (Permissions p: list) {
            roles.add(p.getPermissionsName());
        }
//        if("admin".equals(pri)){
//            roles.add("admin");
//        }
        return new SimpleAuthorizationInfo(roles);

    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token1=(UsernamePasswordToken)authenticationToken;
        Role r = mapper.selectByName(token1.getUsername());
        System.err.println(token1.getPrincipal());
        System.err.println(token1.getCredentials());
        if(r!=null){
//            token1.getPrincipal()获取username
//            token1.getCredentials()获取password
            Object pri = r.getrName();
            Object c = r.getrPassword();
            ByteSource bs = ByteSource.Util.bytes(r.getrName());
            String realmName = this.getName();
            return new SimpleAuthenticationInfo(pri,c,bs,realmName);
        }
        else{
            throw new AuthenticationException();
        }
    }

    public static void main(String[] args) {
        //加密测试代码
        //设置加密方式
        String algorithmName="MD5";
        //设置待加密的原密码
        Object source="123";
        //设置加盐方式(一般来说都是以用户名来加盐)
        Object salt= ByteSource.Util.bytes("admin");
        //加密次数
        int hashIterations=1024;
        SimpleHash newPassword=new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(newPassword.toString());
    }
}