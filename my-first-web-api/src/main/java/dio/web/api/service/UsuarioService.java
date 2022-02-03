package dio.web.api.service;

import dio.web.api.entity.UsuarioEntity;
import dio.web.api.entity.dto.UsuarioDTO;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity findById(Integer id) {
        Optional<UsuarioEntity> entity = usuarioRepository.findById(id);
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException();
    }

    public UsuarioEntity save(UsuarioDTO dto) {

        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setDataAdmissao(dto.getDataAdmissao());
        entity.setSalario(dto.getSalario());

        return usuarioRepository.save(entity);
    }

    public UsuarioEntity update(UsuarioEntity entity, UsuarioDTO dto) {
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setDataAdmissao(dto.getDataAdmissao());
        entity.setSalario(dto.getSalario());

        return usuarioRepository.save(entity);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
