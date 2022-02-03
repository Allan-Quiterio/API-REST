package dio.web.api.controller;

import dio.web.api.entity.UsuarioEntity;
import dio.web.api.entity.dto.UsuarioDTO;
import dio.web.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> findAll(){
        return usuarioService.findAll();
    }
    @GetMapping("/{id}")
    public UsuarioEntity findById(@PathVariable Integer id){
        return usuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntity save(@RequestBody UsuarioDTO dto){
        return usuarioService.save(dto);
    }

    @PutMapping("/{id}")
    public UsuarioEntity update(@RequestBody UsuarioDTO dto, @PathVariable Integer id){
        UsuarioEntity usuarioEntity = usuarioService.findById(id);
        return usuarioService.update(usuarioEntity, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        usuarioService.delete(id);
    }

}
