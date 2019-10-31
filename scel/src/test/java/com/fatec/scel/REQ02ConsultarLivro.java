package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fatec.scel.model.Livro;
import com.fatec.scel.model.LivroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class REQ02ConsultarLivro {
	@Autowired
	LivroRepository repository;
	static Livro livro;

	@Test
	public void CT01ConsultaLivro_com_sucesso() {
		// dado que o livro esta cadastrado
		livro = new Livro("3333", "Teste de Software", "Delamaro");
		repository.save(livro);
		// quando o usurio consulta o livro
		Livro ro = repository.findByIsbn("3333");
		// entao 
		assertThat(ro.getTitulo()).isEqualTo(livro.getTitulo());
		equals (ro.equals(livro));
	}
	@Test
	public void CT02ConsultaLivro_isbn_invalido() {
		// dado que o livro esta cadastrado
		// quando o usurio consulta o livro
		Livro ro = repository.findByIsbn("");
		// entao 
		assertThat(ro).isNull();
	}
	@Test
	public void CT03ConsultaLivro_isbn_nao_cadastrado() {
		// dado que o livro esta cadastrado
		// quando o usurio consulta o livro
		Livro ro = repository.findByIsbn("");
		// entao 
		assertThat(ro).isNull();
	}
}