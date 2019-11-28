package com.fc.springmvc.utils;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtUtils {
	private static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	private static final String secret = "f4e2e52034348f86b67cde581c0f9eb5";
	public static final Long expire = 604800l;
	public static final String header = "token";

	/**
	 * 生成jwt token
	 */
	public static String generateToken(String userId) {
		Date nowDate = new Date();
		// 过期时间
		Date expireDate = new Date(nowDate.getTime() + expire * 1000);

		return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(userId + "").setIssuedAt(nowDate)
				.setExpiration(expireDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public static Claims getClaimByToken(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			logger.debug("validate is token error ", e);
			return null;
		}
	}

	/**
	 * token是否过期
	 * 
	 * @return true：过期
	 */
	public static boolean isTokenExpired(Date expiration) {
		return expiration.before(new Date());
	}
	
}
