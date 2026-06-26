package zoologico;

public class Zoo {
    public static void main(String[] args) {

        Terrestre oncaPintada = new Terrestre("Onça-pintada", 190, 4, "Amarelo/Preto", 2.8f, "Carne");
        Terrestre camelo      = new Terrestre("Camelo",       150, 4, "Amarelo",       2.0f, "Grama");
        Aquatico  tubarao     = new Aquatico ("Tubarão",      300, "Cinzento", "Mar",  1.5f, "Barbatanas e cauda");
        Terrestre urso        = new Terrestre("Urso",         180, 4, "Castanho",      0.5f, "Mel");
        Aquatico  baleia      = new Aquatico ("Baleia",      2500, "Azul",     "Mar",  1.2f, "Barbatanas e cauda");

        System.out.println("Zoo:\n");
        System.out.printf("%-15s %-12s %-6s %-15s %-10s %-10s %-10s%n",
            "Animal", "Comprimento", "Patas", "Cor", "Ambiente", "Velocidade", "Característica/Alimento");

        oncaPintada.exibirDados();
        camelo.exibirDados();
        tubarao.exibirDados();
        urso.exibirDados();
        baleia.exibirDados();
    }
}