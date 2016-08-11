package com.csmy.object;

/**
 * RolemenuId entity. @author MyEclipse Persistence Tools
 */

public class RolemenuId implements java.io.Serializable {

	// Fields

	private Userrole userrole;
	private Menu menu;

	// Constructors

	/** default constructor */
	public RolemenuId() {
	}

	/** full constructor */
	public RolemenuId(Userrole userrole, Menu menu) {
		this.userrole = userrole;
		this.menu = menu;
	}

	// Property accessors

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolemenuId))
			return false;
		RolemenuId castOther = (RolemenuId) other;

		return ((this.getUserrole() == castOther.getUserrole()) || (this
				.getUserrole() != null && castOther.getUserrole() != null && this
				.getUserrole().equals(castOther.getUserrole())))
				&& ((this.getMenu() == castOther.getMenu()) || (this.getMenu() != null
						&& castOther.getMenu() != null && this.getMenu()
						.equals(castOther.getMenu())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserrole() == null ? 0 : this.getUserrole().hashCode());
		result = 37 * result
				+ (getMenu() == null ? 0 : this.getMenu().hashCode());
		return result;
	}

}