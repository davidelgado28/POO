class Main{

    private String nome = "David";
    private double salario = 2000.20;

    public Main(String nome, double salario){
        this.nome = nome;
        setSalario(salario);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        if(salario>=0){
            this.salario = salario;
        }
    }
    public void aplicarAumento(double percentual){
        if(percentual>0){
            this.salario += this.salario*(percentual/100.0);
        }
    }
    public String toString(){
        return "Nome do funcionario: " + nome + " | Salario=R$ " + String.format("%.2f", salario);
    }
    public static void main(String[] args){
    desafioFinal x = new desafioFinal("David", 2000.20);

    x.aplicarAumento(10);
    
    System.out.println(x.toString()); 
    }
}