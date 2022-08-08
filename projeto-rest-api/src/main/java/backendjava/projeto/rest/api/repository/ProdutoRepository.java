package backendjava.projeto.rest.api.repository;

import backendjava.projeto.rest.api.modelo.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de produtos.
     * @return lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo o seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id )
                .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * @param produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return o produtos apos atualizar a lista.
     */
    public Produto atualizar(Produto produto){
        //Encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        //Se produto encontrado estiver vazio
        if (produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }
        // Remover o produto antigo na lista
        deletar(produto.getId());
        // Adicionar um novo produto
        produtos.add(produto);
        return produto;
    }

}
