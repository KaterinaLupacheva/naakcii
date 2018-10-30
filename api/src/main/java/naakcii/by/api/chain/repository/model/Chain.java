package naakcii.by.api.chain.repository.model;

import naakcii.by.api.action.repository.model.Action;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CHAIN")
//@Cacheable
//@org.hibernate.annotations.Cache(
//		usage = org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
//		region = "naakcii.by.repository.modelDTO.cache.Chain"
//)
//@org.hibernate.annotations.NaturalIdCache
public class Chain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4338838997190141797L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHAIN_ID")
	private Long id;
	
	@Column(name = "CHAIN_NAME", length = 100)
	@NotNull
	@Size(min = 3, max = 45)
	@org.hibernate.annotations.NaturalId(mutable = true)
	private String name;
	
	@Column(name = "CHAIN_LOGO")
	@Size(max = 255)
	private String logo;
	
	@Column(name = "CHAIN_LOGO_SMALL")
	@Size(max = 255)
	private String logoSmall;

	@Column(name = "CHAIN_IS_ACTIVE")
	@NotNull
	private boolean isActive;
	
	@Column(name = "CHAIN_LINK")
	@NotNull
	@Size(max = 255)
	private String link;
	
	@OneToMany(mappedBy = "chain", fetch = FetchType.LAZY)
	private Set<Action> actions = new HashSet<>();
	
	public Chain() {
		
	}
	
	public Chain(String name, String link, boolean isActive) {
		this.name = name;
		this.link = link;
		this.isActive = isActive;
	}

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogoSmall() {
		return logoSmall;
	}

	public void setLogoSmall(String logoSmall) {
		this.logoSmall = logoSmall;
	}
	
}
