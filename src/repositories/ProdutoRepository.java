package repositories;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {

    //metodo para inserir um produto no banco de dados
    public void create(Produto produto) throws Exception {
        //abrir conexao com o banco de dados
        // caso dê um erro dentro do try na gravacao ele sempre fecha a conexao
        try (var connection = ConnectionFactory.getConnection()) {

            var statement = connection.prepareStatement
                    ( "INSERT INTO produtos(nome, preco, quantidade) VALUES (?,?,?)");
            //passando os valores de cada campo a ser preenchido
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            //executando essa sentence no banco de dados
            statement.execute();

        }
    }
}
