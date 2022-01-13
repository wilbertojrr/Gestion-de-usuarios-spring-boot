package com.CursoJava.Curso.Controlers;

import com.CursoJava.Curso.Models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private com.CursoJava.Curso.dao.usuarioDao usuarioDao;
    @Autowired
    private com.cursojava.curso.utils.JWTUtil jwtUtil;

    @RequestMapping(value= "api/login", method = RequestMethod.POST)
    public String login (@RequestBody Usuario usuario) {

        Usuario usuarioLogin = usuarioDao.validacionUsuario(usuario);
        if (usuarioLogin != null) {
           String token = jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getEmail());
            return token;
        }
        return "FAIL";

    }
}
