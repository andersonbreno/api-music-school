package music.school.api.professor;

public record DadosListagemProfessor(Long id, String nome, String email, Especialidade especialidade) {
    
    public DadosListagemProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getEspecialidade());
    }
}
