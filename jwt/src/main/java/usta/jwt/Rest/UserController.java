package usta.jwt.Rest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import usta.jwt.dto.User;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @PostMapping("/user")
    public User login(@RequestParam("user")String username, @RequestParam("password")String password){
        String token = getJWTtoken(username);
        User user = new User();
        user.setUser(username);
        user.setPwd(password);
        user.setToken(token);
        return user;
    }

    private String getJWTtoken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 120000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}
