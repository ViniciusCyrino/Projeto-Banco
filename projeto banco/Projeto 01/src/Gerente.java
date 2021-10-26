import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario {

	private String nome;
	private int codigo;
	ArrayList<Cliente> listaclientes = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	protected Gerente (String nome, int codigo, int senha){
	this.nome = nome;
	this.codigo = codigo;
	this.senha = senha;
	}
	
	int getTamanho() {
		return listaclientes.size();
	}
	
	int clientescodigo(int x) {
		return listaclientes.get(x).getCodigo();
	}
	
	String clientesnomes(int x) {
		return listaclientes.get(x).getName();
	}
	
	protected void addCliente(Cliente aux) {
	listaclientes.add(aux);
	}
	
	protected void verClientes() {
		for (Cliente model : listaclientes) {
            System.out.println(model.getName()+ "  " + "codigo: ");
            System.out.println(model.getCodigo());
            model.imprime();
        }
	}
	
	protected void limite(int aux,double valor) {
		
			for(Cliente model : listaclientes) {
				model.limite(aux,valor);
		}
		
	}
	
	protected int getCodigo() {
		return codigo;
	}
	
	protected String getName() {
		return nome;
	}
}
