package com.CursoJava.Curso.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Getter @Setter @Column (name = "id")
    private long id;

    @Getter @Setter @Column (name = "nombre")
    private String nombre;

    @Getter @Setter @Column (name = "apellido")
    private String apellido;

    @Getter @Setter @Column (name = "email")
    private String email;

    @Getter @Setter @Column (name = "telefono")
    private String telefono;

    @Getter @Setter @Column (name = "password")
    private String password;
}
