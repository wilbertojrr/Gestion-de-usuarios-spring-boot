package com.CursoJava.Curso.dao;

import com.CursoJava.Curso.Models.Usuario;

import java.util.List;

public interface usuarioDao {

    List<Usuario> getUsuario ();

    void eliminar(Long id);

    void registrar(Usuario usuario);



    Usuario validacionUsuario(Usuario usuario);
}
