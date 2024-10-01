package com.Voting.votingApp.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class Admin implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	
	  @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JsonBackReference
	    private List<Candidates> candidates = new ArrayList<>();
	  
	  @OneToMany(fetch = FetchType.EAGER, mappedBy = "admin",cascade = CascadeType.ALL)
	  @JsonManagedReference
		private Set<AdminRole> adminrole ;
	  
		public Admin(int id, String name, String email, String password, String phoneNumber, List<Candidates> candidates,
				Set<AdminRole> adminrole) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.phoneNumber = phoneNumber;
			this.candidates = candidates;
			this.adminrole = adminrole;
		}
	
	public Admin()
	{
		
	}
	
	
	@Override
	
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return adminrole.stream()
				.map(role-> new SimpleGrantedAuthority("ROLE_" +role.getName()))
				.collect(Collectors.toSet());
	}


   

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement according to your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement according to your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement according to your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement according to your requirements
    }







}
