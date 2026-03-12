package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.Statement;

public class ProdutoRepository {

    //metodo para inserir um produto no banco de dados (void=nao retorna nada)
    //trocou o void para Integer quando colocou return_generated_keys para
    //retornar qual o código que foi gerado
    public Integer create(Produto produto) throws Exception {
        //abrir conexao com o banco de dados
        // caso dê um erro dentro do try na gravacao ele sempre fecha a conexao
        try (var connection = ConnectionFactory.getConnection()) {


            var statement = connection.prepareStatement (
                    "INSERT INTO produtos(nome, preco, quantidade) VALUES (?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);

            //passando os valores de cada campo a ser preenchido
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());

            //executando essa sentence no banco de dados
            statement.execute();

            //obter o ID gerado no banco de dados
            var keys = statement.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1); // retornar o ID gerado
            }

            return 0;

        }
    }
    //FIM do metodo para inserir >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //metodo para atualizar um produto no banco de dados (boolean=retorna algo)
    public boolean update(Produto produto) throws Exception {

        //abrir conexao com o banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //escrevendo a sentenca SQL para atualizar um produto no banco de dados
            var statement = connection.prepareStatement
                    ("UPDATE produtos SET nome=?, preco=?, quantidade=? WHERE id=?");
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());

            //executando essa sentence no banco de dados e retorna a qtde reg atualizados
            return statement.executeUpdate() > 0;
            // var result = statement.executeUpdate();
            // return result > 0;     ou
            // if (result > 0 ) {
            //            return true
            //        }
            //      else {
            //        return false;
            //  }
        }
    }
    //fim do metodo para atualizar >>>>>>>>>>>>>>>>>>>>>>>>>

    //metodo para excluir um produto no banco de dados
    public boolean delete(Integer id) throws Exception {

        //abrir conexao com o banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //escrever uma sentenca SQL para excluir um produto no banco de dados
            var statement = connection.prepareStatement
                    ("DELETE FROM produtos WHERE id=?");
            statement.setInt(1, id);

            //executando essa sentence no banco de dados e retorna a qtde reg excluidos
            return statement.executeUpdate() > 0;
        }
    }
    //FIM do metodo para excluir >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //metodo para consultar e exibir todos os produtos contidos na tabela do banco
    public void findAll () throws Exception {

        //abrir conexao com o banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //escrever uma sentenca para consultar os produtos da tabela
            var statement = connection.prepareStatement
                    ("SELECT * FROM produtos ORDER BY id");
            //executa a consulta e retorna todos os registros obtidos
            var data = statement.executeQuery();

            //percorrer cada registro obtido
            while (data.next()) {
                System.out.println("Id...........: " + data.getInt("id"));
                System.out.println("nome.........: " + data.getString("nome"));
                System.out.println("preco........: " + data.getDouble("preco"));
                System.out.println("quantidade...: " + data.getInt("Quantidade"));
                System.out.println("data/hora....: " + data.getTimestamp("datahoracadastro"));
                System.out.println("....");
            }
        }
    }
    //FIM do metodo para consultar >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
