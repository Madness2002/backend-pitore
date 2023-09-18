package com.pitore.backendpitore.service;

import com.pitore.backendpitore.model.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer>{
    public void guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Integer usuarioId);

}
