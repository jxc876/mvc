package security;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * Requires the spring-test artifact.
 * 
 * @author mramirez
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/servlet-context.xml", "/spring/security.xml" })
public class SecurityTest {

	@Autowired
	private WebInvocationPrivilegeEvaluator eval;
	@Autowired
	private UserDetailsService service;

	@Test
	public void testNotAllowed() {
		boolean isAllowed = eval.isAllowed("/myFlow", getAuth());
		Assert.assertFalse(isAllowed);
	}

	@Test
	public void testAllowedAfterLogin() {
		boolean isAllowed = eval.isAllowed("/myFlow", getAuthToken("admin"));
		Assert.assertTrue(isAllowed);
	}
	
	/**
	 * Generates a Authentication for the given username
	 */
	private Authentication getAuthToken(String username) {
		return new UsernamePasswordAuthenticationToken(username, null,
		        getAuthorities(username));
	}

	/**
	 * Load GrantedAuthorities using the UserDetailsService
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(
	        String username) {
		return service.loadUserByUsername(username).getAuthorities();
	}
	
	private Authentication getAuth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
