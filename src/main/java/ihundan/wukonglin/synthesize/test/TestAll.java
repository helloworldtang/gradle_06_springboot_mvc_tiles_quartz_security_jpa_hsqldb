package ihundan.wukonglin.synthesize.test;

import ihundan.wukonglin.synthesize.security.model.SecurityRole;

import org.junit.Test;

public class TestAll {
	
	@Test
	public void test_001() {
		System.out.println(SecurityRole.ADMIN.name());
		System.out.println(SecurityRole.ADMIN.toString());
	}
}
