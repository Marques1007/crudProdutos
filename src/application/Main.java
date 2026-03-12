package application;

import controllers.ProdutoController;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nSISTEMA DE CONTROLE DE PRODUTOS:\n");

        var a = new A();
        // a.nome = "teste1"; não enxerga porque é estatico print
        a.print("Francisco");

        var a1 = new A();
        a1.nome = "teste1";
        a1.printNOVO();

        //ProdutoController.consultarProdutos();
        //rotina para pegar o ID gerado e a data gravacao FALTA CRIAR
        //???????????????????????????????????????????????????????
        //teste

        System.out.println("(1) - Cadastrar produto");
        System.out.println("(2) - Atualizar produto");
        System.out.println("(3) - Excluir produto");
        System.out.println("(4) - Consultar produto");

        var opcao = JOptionPane.showInputDialog("Informe a opção desejada: ");

        switch (opcao) {
            case "1":
                ProdutoController.cadastrarProduto();
                break;
            case "2":
                ProdutoController.atualizarProduto();
                break;
            case "3":
                ProdutoController.excluirProdutos();
                break;
            case "4":
                ProdutoController.consultarProdutos();
                break;

            default:
                System.out.println("\nopção invalida.");
        }
    }
}

//sem o public na frente abaixo, essa classe só é vista na classe Main
class A {

    public String nome;

    public static void print(String teste) {

        System.out.println("Ola, sou A " + teste + ".....");


    }

    public void printNOVO() {

        System.out.println("Ola, sou A " + nome);
    }
}