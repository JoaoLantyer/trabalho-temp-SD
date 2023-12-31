package com.mycompany.trabalhoa3;

import java.io.File;


public class MultiPrograma {
    public static void main(String[] args) {

        //Criando o banco de dados se não existir
        File arquivodb = new File("database.db");
        boolean exists = arquivodb.exists();

        if(!exists){
            System.out.println("Criando o banco de dados.");
            Database database = new Database();
            database.operarDatabase();
        }else {
            System.out.println("Banco de dados disponível.");
        }

        if(args.length != 3){
            System.out.println("Para executar o programa: MultiPrograma <tipo> <identificador> <porta>");
            System.exit(0);
        }

        String tipo = args[0];
        String nome = args[1];
        String porta = args[2];
        System.out.println("Olá, eu sou o programa do tipo " + tipo + " com o identificador " + nome);


        switch (tipo) {
            case "gerente":
                Gerente gerente = new Gerente(porta, nome);
                gerente.run();
                break;
            case "vendedor":
                Vendedor vendedor = new Vendedor(porta, nome);
                vendedor.run();
                break;
            case "servidor":
                Servidor servidor = new Servidor(porta, nome);
                servidor.run();
                break;
            default:
                System.out.println("Tipo não válido!");
                break;
        }
    }
}
