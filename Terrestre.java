package zoologico;

public class Terrestre extends Animal {
    private String alimentoPreferido;

    public Terrestre(String nome, float comprimento, int patas,
                     String cor, float velocidade, String alimentoPreferido) {
        super(nome, comprimento, patas, cor, "Terra", velocidade);
        this.alimentoPreferido = alimentoPreferido;
    }

    public String getAlimento() { return alimentoPreferido; }

    @Override
    public void exibirDados() {
        System.out.printf("%-15s %-12s %-6d %-15s %-10s %-10s %-10s%n",
            getNome(), (int)getComprimento() + " cm", getPatas(),
            getCor(), getAmbiente(), getVelocidade() + " m/s", alimentoPreferido); 
    }
}