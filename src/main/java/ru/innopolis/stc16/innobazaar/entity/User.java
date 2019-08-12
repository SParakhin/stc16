package ru.innopolis.stc16.innobazaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 1, message = "Поле не может быть пустым")
    private String lastName;
    @NotEmpty
    private String email;
    private String phone;
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            targetEntity = Address.class,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Store> storeList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE,
            targetEntity = Role.class)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_bookings",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "booking_id") }
    )
    private List<Booking> bookings;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket_merchandise",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "merchandise_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Merchandise> merchandises = new CopyOnWriteArrayList<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void addAddressToUser(Address address) {
        address.setUser(this);
        getAddressList().add(address);
    }

    public void addStoreToUser(Store store) {
        store.setUser(this);
        getStoreList().add(store);
    }

}





