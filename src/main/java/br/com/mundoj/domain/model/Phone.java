package br.com.mundoj.domain.model;

public class Phone {

	private String number;

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Phone [number=" + number + "]";
	}
}
