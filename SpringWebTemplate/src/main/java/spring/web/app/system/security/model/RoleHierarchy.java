package spring.web.app.system.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SECURITY_ROLE_HIERARCHY")
@Data
public class RoleHierarchy {
    @Id
    @Column(name = "ROLE_ID")
    private String roleId;
    
    @Column(name = "ROLE_NAME")
    private String roleNm;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "PARENT_ROLE_ID")
    private RoleHierarchy parentRole;

    @OneToMany(mappedBy = "parentRole", cascade={CascadeType.ALL})
    private Set<RoleHierarchy> roleHierarchy = new HashSet<RoleHierarchy>();
}
