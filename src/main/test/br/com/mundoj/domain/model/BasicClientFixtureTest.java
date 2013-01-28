package br.com.mundoj.domain.model;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.fixturefactory.Fixture;
import br.com.fixturefactory.Rule;

public class BasicClientFixtureTest {
	
	@Before
	public void setUp() {
		Fixture.of(Address.class).addTemplate("brazilianAddress", new Rule() {{
			add("id", 1L);
			add("street", "Paulista Avenue");
			add("city", "São Paulo");
			add("state", "SP");
			add("country", "Brazil");
			add("zipCode", "0660800");
		}});
		Fixture.of(Phone.class).addTemplate("brazilianPhoneNumber", new Rule() {{
			add("number", "11 9999-9999");
		}});
		
		Fixture.of(Client.class).addTemplate("geekClient", new Rule() {{
			add("id", 1L);
			add("name", "Nykolas Laurentino de Lima");
			add("nickname", "geek");
			add("email", "${nickname}@gmail.com");
			add("birthday", Calendar.getInstance());
			add("address", one(Address.class, "brazilianAddress"));
			add("phones", has(3).of(Phone.class, "brazilianPhoneNumber"));
		}}
		).addTemplate("nerdClient", new Rule() {{
			add("id", 2L);
			add("name", "Anderson Parra");
			add("nickname", "nerd");
			add("email", "${nickname}@gmail.com");
			add("birthday", Calendar.getInstance());
			add("address", one(Address.class, "brazilianAddress"));
			add("phones", has(3).of(Phone.class, "brazilianPhoneNumber"));
		}});

	}
	
	@Test
	public void testGeekClient() {
		Client client = Fixture.from(Client.class).gimme("geekClient");
		assertNotNull(client);
		assertNotNull(client.getAddress());
		assertNotNull(client.getPhones());
	}
}