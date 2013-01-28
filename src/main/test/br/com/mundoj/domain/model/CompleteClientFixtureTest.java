package br.com.mundoj.domain.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.fixturefactory.Fixture;
import br.com.fixturefactory.Rule;

public class CompleteClientFixtureTest {
	@Before
	public void setUp() {
		Fixture.of(Address.class).addTemplate("brazilianAddress", new Rule() {{
			add("id", random(Long.class, range(1L, 100L)));
			add("street", random("Paulista Avenue", "Ibirapuera Avenue"));
			add("city", "São Paulo");
			add("state", "SP");
			add("country", "Brazil");
			add("zipCode", random("0660800", "17720000"));
		}});
		
		Fixture.of(Phone.class).addTemplate("brazilianPhoneNumber", new Rule() {{
			add("number", regex("(\\d{2}) \\d{4}-\\d{4}"));
		}});
		
		Fixture.of(Client.class).addTemplate("geekAndNerdClient", new Rule() {{
			add("id", random(Long.class, range(1L, 200L)));
			add("name", random("Nykolas Laurentino de Lima", "Anderson Parra"));
			add("lastName", lastName());
			add("nickname", random("nerd", "geek"));
			add("email", "${nickname}@gmail.com");
			add("birthday", instant("18 years ago"));
			add("address", one(Address.class, "brazilianAddress"));
			add("phones", has(3).of(Phone.class, "brazilianPhoneNumber"));
		}});
	}
	
	@Test
	public void testGeekAndNerdClient() {
		Client client = Fixture.from(Client.class).gimme("geekAndNerdClient");
		assertNotNull(client);
		assertNotNull(client.getAddress());
		assertNotNull(client.getPhones());
	}
}
