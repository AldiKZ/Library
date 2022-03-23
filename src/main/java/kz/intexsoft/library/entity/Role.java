package kz.intexsoft.library.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority {

    @Id
    private Long id;
    private String name;

    @Transient
    @OneToMany()
    private Set<User> users;

    public Role(){}
    public  Role(Long id){
        this.id = id;
    }
    public Role(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}
