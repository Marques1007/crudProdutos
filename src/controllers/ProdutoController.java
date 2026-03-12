package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.util.Scanner;

public class ProdutoController {

    //metodo para capturar os dadoss do produto
    public static void cadastrarProduto () {

        System.out.println("\nCADASTRO DE PRODUTO:\n");

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
            var id = produtoRepository.create(produto);

            System.out.println("\nProduto cadastrado com sucesso!" + id);

        }

        catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
    //FIM do metodo para capturar >>>>>>>>>>>>>>>>>>>>>>>>>>

    //metodo para capturar os dados do produto para edicao
    public static void atualizarProduto () {

        System.out.println("\nATUALIZAÇÃO DE PRODUTO:\n");

        try (var scanner = new Scanner(System.in)) {

            //criando um objeto da classe produto
            var produto = new Produto();

            System.out.print("Informe o id do produto...: ");
            produto.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Informe o nome do produto...: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço    .............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade    ........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //criar um objeto da classe produtoRepository
            var produtoRepository = new ProdutoRepository();
            if (produtoRepository.update(produto)) {
                System.out.println("\nProduto atualizado com sucesso!");
            }
            else {
                System.out.println("\nProduto não encontrado para edição!");
            }
        }
        catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
    //FIM do metodo para capturar para edicao >>>>>>>>>>>>>>>>>>>>>>>>>>

    //metodo para capturar os dados do produto para exclusao
    public static void excluirProdutos () {

        System.out.println("\nEXCLUSÃO DE PRODUTO:\n");

        try (var scanner = new Scanner(System.in)) {

            //criando um objeto da classe produto
            var produto = new Produto();

            System.out.print("Informe o id do produto...: ");
            var id = (Integer.parseInt(scanner.nextLine()));

            //criar um objeto da classe produtoRepository
            var produtoRepository = new ProdutoRepository();
            if (produtoRepository.delete(id)) {
                System.out.println("\nProduto excluido com sucesso!");
            }
            else {
                System.out.println("\nProduto não encontrado para exclusao!");
            }
        }
        catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }


    }
    //FIM do metodo para exclusao >>>>>>>>>>>>>>>>>>

    //metodo para consultar os dados dos produtos
    public static void consultarProdutos () {

        System.out.println("\nCONSULTA DE PRODUTOS:\n");

        try {

            var produtoRepository = new ProdutoRepository();
            produtoRepository.findAll();

        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }

    }
    //FIM do metodo para consultar >>>>>>>>>>>>>>>>>>



}
