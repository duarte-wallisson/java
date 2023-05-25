/*
Fazer um programa para ler um conjunto de produtos a partir de um
arquivo em formato .csv (suponha que exista pelo menos um produto).
Em seguida mostrar o preço médio dos produtos. Depois, mostrar os
nomes, em ordem decrescente, dos produtos que possuem preço
inferior ao preço médio.
*/
public class Main {
    public static void main(String[] args) {
        String path = "C:\\Developer\\Projects\\java\\exercise01\\files\\in.csv";
        var items = ManipulatingFiles.toRead(path);
        System.out.println("Map of items: " + items);
        var avg = ManipulatingFiles.avgPrice(items);
        System.out.println("Average price: " + avg);
        ManipulatingFiles.sort(items, avg);
    }
}