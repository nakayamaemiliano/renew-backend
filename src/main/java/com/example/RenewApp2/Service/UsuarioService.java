package com.example.RenewApp2.Service;

import com.example.RenewApp2.Entity.Usuario;
import com.example.RenewApp2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){

        return usuarioRepository.findAll();

    }

    public Optional<Usuario> buscarUsuarioById (Integer id ){
        return usuarioRepository.findById(id);

    }
    public Usuario crearUsuario(Usuario usuario ){
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Integer id , Usuario usuarioActualizado ){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario con ID " + id + " no encontrado"));
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setContrasena(usuarioActualizado.getContrasena());
        usuario.setRol(usuarioActualizado.getRol());
        return usuarioRepository.save(usuario);

    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

}
