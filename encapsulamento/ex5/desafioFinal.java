import java.util.ArrayList;
import java.util.List;

class Cliente{
    private String nome;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco(){
        return preco;
    }
}
class Pedido{
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(Cliente cliente){
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        if(produto != null){
            produtos.add(produto);
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(Produto p : produtos){
            total += p.getPreco();
        }
        return total;
    }

    @Override
    public String toString(){
        return "Cliente: " + cliente.getNome() + " | Valor total: R$ " + String.format("%.2f", calcularTotal());
    }
}
public class desafioFinal {
    public static void main(String[] args) {
        Cliente cl = new Cliente("David");
        Produto p1 = new Produto("Teclado", 150.0);
        Produto p2 = new Produto("Mouse", 80.0);

        Pedido pedido = new Pedido(cl);
        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        System.out.println(pedido.toString());
    }
}