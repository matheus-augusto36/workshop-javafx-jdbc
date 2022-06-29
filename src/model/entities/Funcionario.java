package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String area;

	public Funcionario(String name, String email, String area) {
		super();
		this.name = name;
		this.email = email;
		this.area = area;
	}

	public Funcionario() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(area, other.area) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Funcionario [name=" + name + ", email=" + email + ", area=" + area + "]";
	}

}
