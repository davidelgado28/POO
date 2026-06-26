class Funcionario{

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario){
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
    public String toString(){
        return "Nome: " + nome + " | Salario: R$ " + String.format("%.2f", salario);
    }
}
class folhaDoSevico{
    public void aplicarAumento(Funcionario funcionario, double percentual){
        if(percentual>0){
            double novoSalario = funcionario.getSalario()*(1+percentual/100.0);
            funcionario.setSalario(novoSalario);
        }
    }
    public double calcularSalarioLiquido(Funcionario funcionario){
        return funcionario.getSalario()*0.89;
    }
    public double calcularBonus(Funcionario funcionario){
        return funcionario.getSalario() < 3000 ? 500.0 : 0.0;
    }
}
public class Exercicio04{

    public static void main(String[] args){

        Funcionario f1 = new Funcionario("David", 2000.0);
        Funcionario f2 = new Funcionario("Carlos", 4000.0);

        folhaDoSevico folha = new folhaDoSevico();

        folha.aplicarAumento(f1, 10);

        System.out.println(f1.getNome() + " - R$ " + String.format("%.2f", f1.getSalario()));
        System.out.println(f2.getNome() + " - R$ " + String.format("%.2f", f2.getSalario()));
    }
}