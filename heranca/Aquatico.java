public class Aquatico extends Animal {
    private String caracteristica;

    public Aquatico(String nome, float comprimento, String cor, 
                    String ambiente, float velocidade, String caracteristica) {
        super(nome, comprimento, 0, cor, ambiente, velocidade);
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica() { return caracteristica; }

    @Override
    public void exibirDados() {
        System.out.printf("%-15s %-12s %-6d %-15s %-10s %-10s %-10s%n",
            getNome(), (int)getComprimento() + " cm", getPatas(),
            getCor(), getAmbiente(), getVelocidade() + " m/s", caracteristica);
    }
}