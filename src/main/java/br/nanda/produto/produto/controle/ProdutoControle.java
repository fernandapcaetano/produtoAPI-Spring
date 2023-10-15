package br.nanda.produto.produto.controle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.nanda.produto.produto.modelo.ProdutoModelo;
import br.nanda.produto.produto.modelo.RespostaModelo;
import br.nanda.produto.produto.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/api")
public class ProdutoControle {

    //açoes previamente disposniveis no nosso repositório
    @Autowired
    private ProdutoRepositorio acoes;

    //Listar Produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo > Listar(){
        return acoes.findAll();
    }
    //CADASTRAR PRODUTO
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
    //Filtrar Produtos
    @RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo){
        return acoes.findByCodigo(codigo);
    }
    //EDITAR PRODUTOS
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto){
        return acoes.save(produto);
    }
    //Deletar produto
    @RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody RespostaModelo delete(@PathVariable Integer codigo){
        
        RespostaModelo resposta = new RespostaModelo();
        
        try {
            ProdutoModelo produto = filtrar(codigo);
            this.acoes.delete(produto);
            resposta.setMensagem("Produto Removido");
        } catch (Exception e) {
            resposta.setMensagem("Falha ao remover");
        }
        return resposta;
    }

    // //inicio
    // @RequestMapping(value = "", method = RequestMethod.GET)
    // public @ResponseBody String inicio(){
    //     return "Inicio";
    // }
    // //sobre
    // @RequestMapping(value = "/sobre", method = RequestMethod.GET)
    // public @ResponseBody String Sobre(){
    //     return "Sobre";
    // }
    // //contato
    // @RequestMapping(value = "/contato", method = RequestMethod.GET)
    // public @ResponseBody String contato(){
    //     return "contato";
    // }
    
}
