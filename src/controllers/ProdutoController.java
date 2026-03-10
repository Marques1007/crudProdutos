package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.util.Scanner;

public class ProdutoController {

    //metodo para capturar os dadoss do produto
    public static void cadastrarProduto () {

        try (var scanner = new Scanner(System.in)) {

            //criando um objeto da classe produto
            var produto = new Produto();

            System.out.print("Informe o nome do produto...: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço    .............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade    ........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //criar um objeto da classe produtoRepository
            var produtoRepository = new ProdutoRepository();
            produtoRepository.create(produto);

            System.out.println("\nProduto cadastrado com sucesso!");

        }

        catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
}
