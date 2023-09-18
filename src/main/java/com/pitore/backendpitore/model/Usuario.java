package com.pitore.backendpitore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cusuario;

    @NotEmpty(message = "Ingrese el usuario")
    @NotBlank (message = "No deje en blanco el username")
    @NotNull
    @Column(name = "username", nullable = false, length = 50,unique=true)
    private String username;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Ingrese nombre del usuario")
    @Column(name = "nomUsuario", nullable = false, length = 50)
    private String nomUsuario;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Ingrese la contraseña")
    @Column(name = "password", nullable = false, length = 50)
    private String password;


    @Column(name = "imgUsuario", nullable = false, length = 1000)
    private String imgUsuario;

    @NotEmpty(message = "Ingrese una fecha")
    @Column(name = "dUsuario", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dUsuario;

    @OneToMany(mappedBy = "usuario", cascade = {
            CascadeType.REMOVE
    })
    private List<GrupoEvaluacion> grupos;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonBackReference
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    @NotNull()
    @Value("${usuario.f:true}")
    private boolean fUsuario;

    public Usuario(int cusuario, String username, String nomUsuario, String password, String imgUsuario, Date dUsuario, List<GrupoEvaluacion> grupos, Set<UsuarioRol> usuarioRoles, boolean fUsuario) {
        this.cusuario = cusuario;
        this.username = username;
        this.nomUsuario = nomUsuario;
        this.password = password;
        this.imgUsuario = imgUsuario;
        this.dUsuario = dUsuario;
        this.grupos = grupos;
        this.usuarioRoles = usuarioRoles;
        this.fUsuario = fUsuario;
    }

    public Usuario(){


    }

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
        return this.fUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return autoridades;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public int getCusuario() {
        return cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUsuario() {
        return imgUsuario;
    }

    public void setImgUsuario(String imgUsuario) {
        this.imgUsuario = imgUsuario;
    }

    public Date getdUsuario() {
        return dUsuario;
    }

    public void setdUsuario(Date dUsuario) {
        this.dUsuario = dUsuario;
    }

    public List<GrupoEvaluacion> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<GrupoEvaluacion> grupos) {
        this.grupos = grupos;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public boolean isfUsuario() {
        return fUsuario;
    }

    public void setfUsuario(boolean fUsuario) {
        this.fUsuario = fUsuario;
    }
}
