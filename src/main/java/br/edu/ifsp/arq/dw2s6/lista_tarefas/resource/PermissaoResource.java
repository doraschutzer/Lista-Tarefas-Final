package br.edu.ifsp.arq.dw2s6.lista_tarefas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.domain.model.Permissao;
import br.edu.ifsp.arq.dw2s6.lista_tarefas.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_LISTAR_PERMISSAO') and #oauth2.hasScope('read')")
	public List<Permissao> listar(){
		return permissaoRepository.findAll();
	}
}
