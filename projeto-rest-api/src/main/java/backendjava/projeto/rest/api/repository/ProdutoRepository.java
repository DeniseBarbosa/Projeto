package backendjava.projeto.rest.api.repository;

import backendjava.projeto.rest.api.modelo.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
