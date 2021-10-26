import java.util.Scanner;
import java.util.ArrayList;
//import java.util.List;

public  class  Cliente extends Usuario {
	
	private String nome;
	private int codigo;
	private ArrayList<Conta> contas = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	protected Cliente (String nome, int codigo, int senha){
	this.nome = nome;
	this.codigo = codigo;
	this.senha = senha;
	}
	
	protected void cria(int aux) {
		if(aux==1) {
			contas.add(new ContaSimples(this.nome));
		} else if(aux==2) {
			contas.add(new ContaEspecial(this.nome));
		} else {
			contas.add(new ContaPoupança(this.nome));
		}
	}
	 
	double getSaldo(int aux) {
		return contas.get(aux).getSaldo();
	}
	
	protected double[] getExtrato(int aux) {
		int i=contas.get(aux).getTamanho();
		double[] extrato=new double[i];
		for(int j=0;j<i;j++) {
			extrato[j]=contas.get(aux).Getextrato(j);
		}
		return extrato;
	
	}
	
	protected void imprime() {
		for (Conta model : contas) {
			System.out.print(model.getTipo() + "  " + "conta: " );
            System.out.println(model.getCodigo());
		}}

	protected void deposito(int aux,double valor) {
		 contas.get(aux).deposito(valor);
}
	
	protected void saque(int aux,double valor) {
		 contas.get(aux).sacar(valor);
}
	
	protected int tamExtrato(int aux) {
		return contas.get(aux).getTamanho();
	}
 
	protected void limite(int aux,double valor) {
		if(aux==1) {
			for (Conta model : contas) {
				model.setJuros(valor);
			}
			}
		else {
			for (Conta model : contas) {
				model.setLimite(valor);
		}}
		}
	 
	 
	protected String getName() {
		    return nome;
		  }
	
	protected int getCodigo() {
		    return codigo;
		  }
	protected int contasCodigo(int y) {
		return contas.get(y).codigo;
	}

	
	protected int getTamanho() {
		return contas.size();
	}
}
