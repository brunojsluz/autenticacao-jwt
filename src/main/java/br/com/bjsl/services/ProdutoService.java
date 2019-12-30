package br.com.bjsl.services;

import br.com.bjsl.dtos.ProdutoDTO;
import br.com.bjsl.mappers.ProdutoDTOMapper;
import br.com.bjsl.mappers.ProdutoMapper;
import br.com.bjsl.models.Produto;
import br.com.bjsl.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarProdutos() {
        return repository.findAll().stream()
                .map(produto -> ProdutoDTOMapper.mapFrom(produto))
                .collect(Collectors.toList());
    }

    public void salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.mapFrom(produtoDTO);
        repository.save(produto);
    }

    public void excluirProduto(Integer codigo) {
        repository.deleteById(codigo);
    }
}
