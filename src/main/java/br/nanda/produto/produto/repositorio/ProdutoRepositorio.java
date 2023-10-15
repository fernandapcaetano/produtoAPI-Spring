package br.nanda.produto.produto.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.nanda.produto.produto.modelo.ProdutoModelo;

//Fazer crud na tabela Produto com a classe ProdutoModelo em q o ID é do tipo Integer
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer>{
    //Listar todos os produtos
    List<ProdutoModelo> findAll();
    
    //Pesquisar por código
    ProdutoModelo findByCodigo(int codigo);

    //Remover Produto
    void delete(ProdutoModelo produto);

    //Alterar/Cadastrar produto
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);
}
