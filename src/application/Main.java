package application;

import controllers.ProdutoController;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nSISTEMA DE CONTROLE DE PRODUTOS:\n");

        var a = new A();
        // a.nome = "teste1"; não enxerga porque é estatico print
        a.print("Francisco");

        var a1 = new A();
        a1.nome = "teste1";
        a1.printNOVO();

        ProdutoController.cadastrarProduto();
        //rotina para pegar o ID gerado e a data gravacao FALTA CRIAR
        //???????????????????????????????????????????????????????



    }
}
//sem o public na frente abaixo, essa classe só é vista na classe Main
class A {

    public String nome;

    public static void print (String teste) {

        System.out.println("Ola, sou A " + teste + ".....");


    }
    public  void printNOVO () {


        System.out.println("Ola, sou A " + nome);
    }


    }