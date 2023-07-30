package music.school.api.controller;

import music.school.api.professor.*;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBiulder) {

        var professor = new Professor(dados);
        repository.save(professor);

        var uri = uriBiulder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DadosDetalhamentoProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProfessor>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCadastroProfessor dados) {
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var professor = repository.getReferenceById(id);
        professor.excluir();

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var professor = repository.getReferenceById(id);

        return  ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }
}
