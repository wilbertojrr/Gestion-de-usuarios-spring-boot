package com.CursoJava.Curso.Controlers;

import com.CursoJava.Curso.Models.Usuario;
import com.CursoJava.Curso.dao.usuarioDao;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControl {

    @Autowired
    private usuarioDao usuarioDao;

    @Autowired
    private com.cursojava.curso.utils.JWTUtil jwtUtil;

    @RequestMapping (value= "api/usuarios", method = RequestMethod.GET)
    public List <Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {

        if (!validarToken(token)) { return null;}

        return usuarioDao.getUsuario();
    }

    private boolean validarToken (String token){

        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping (value= "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }
    public Usuario editar () {
        Usuario usuario = new Usuario();
        usuario.setNombre("wilberto");
        usuario.setApellido("Ramirez");
        usuario.setEmail("wilberto@gmail.com");
        usuario.setPassword("wilberto1230");
        usuario.setTelefono("56465465");

        return usuario;

    }
    @RequestMapping (value= "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar (@RequestHeader(value = "Authorization") String token ,@PathVariable Long id) {

        if (!validarToken(token)) { return;}

        usuarioDao.eliminar(id);
    }

}
