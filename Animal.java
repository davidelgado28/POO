package zoologico;

public class Animal {
    private String nome;
    private float comprimento;
    private int patas;
    private String cor;
    private String ambiente;
    private float velocidade;

    public Animal(String nome, float comprimento, int patas, 
                  String cor, String ambiente, float velocidade) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.patas = patas;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velocidade = velocidade;
    }

    public String getNome() { return nome; }
    public float getComprimento() { return comprimento; }
    public int getPatas() { return patas; }
    public String getCor() { return cor; }
    public String getAmbiente() { return ambiente; }
    public float getVelocidade() { return velocidade; }

    public void exibirDados() {
        System.out.printf("%-15s %-12s %-6d %-15s %-10s %-10s%n",
            nome, (int)comprimento + " cm", patas, cor, ambiente, velocidade + " m/s");
    }
}