package br.com.mundoj.domain.model;

import java.util.Calendar;
import java.util.List;

public class Client {

	private Long id;
	private String name;
	private String lastName;
	private String nickname;
	private String email;
	private Calendar birthday;
	private Address address;
	private List<Phone> phones;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Calendar getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Client [address=" + address + ", birthday=" + birthday + ", email=" + email + ", id=" + id + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
