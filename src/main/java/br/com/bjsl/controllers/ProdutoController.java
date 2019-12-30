package br.com.bjsl.controllers;

import br.com.bjsl.dtos.ProdutoDTO;
import br.com.bjsl.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listar() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity excluir(@PathVariable("codigo") Integer codigo) {
        produtoService.excluirProduto(codigo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
