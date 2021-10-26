import java.util.ArrayList;
import java.util.Scanner;
  


public class Usuario {
	
	protected int senha;
	ArrayList<Cliente> clientes = new ArrayList<>();	
	ArrayList<Gerente> gerentes = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	
	
	protected void criarGerente() {
	gerentes.add(new Gerente("Banco",0,0));	
	}
	
	protected void limite(int[] i,int aux,double valor) {
		gerentes.get(i[0]).limite(aux, valor);
	}
	
	
	protected void criaCliente(String nome,int codigo,int senha,int[] x) {
	
		int i=clientes.size();
		clientes.add(new Cliente(nome,codigo,senha));
		gerentes.get(x[0]).addCliente(clientes.get(i));
	}
	
	protected void criaGerente(String nome,int codigo,int senha) {
		
		gerentes.add(new Gerente(nome,codigo,senha));
		
	}
	
	
	protected void setContas(int[] i,int tipo) {
		clientes.get(i[0]).cria(tipo);
	}
	
	protected int[] getContas(int[] x) {
		int i=clientes.get(x[0]).getTamanho();
		int[] contas=new int[i];
		for(int j=0;j<i;j++) {
			contas[j]=clientes.get(x[0]).contasCodigo(j);
		}
		return contas;
	}
	
	protected String getNome(int[] i) {
		return clientes.get(i[0]).getName();
	}
	
	protected int getCodigo(int[] i,int aux) {
		return clientes.get(i[0]).contasCodigo(aux);
	}
	
	protected int[] getClientes(int[] x) {
		int i=gerentes.get(x[0]).getTamanho();
		int[] contas=new int[i];
		for(int j=0;j<i;j++) {
			contas[j]=gerentes.get(x[0]).clientescodigo(j);
		}
		return contas;
	}
	
	protected String[] getNomes(int[] x) {
		int i=gerentes.get(x[0]).getTamanho();
		String[] nomes=new String[i];
		for(int j=0;j<i;j++) {
			nomes[j]=gerentes.get(x[0]).clientesnomes(j);
		}
		return nomes;
	}
	
	protected double[] getExtrato(int[] x,int aux) {
		return clientes.get(x[0]).getExtrato(aux);
	}
	
	protected int tamExtrato(int[] i,int aux) {
		return clientes.get(i[0]).tamExtrato(aux);
	}
	
	double getSaldo(int[] i,int aux) {
		return clientes.get(i[0]).getSaldo(aux);
	}
	
	void setSaldo(int[] i,int aux,double valor) {
		clientes.get(i[0]).deposito(aux,valor);
	}
	
	void setSaldoSa(int[] i,int aux,double valor) {
		clientes.get(i[0]).saque(aux,valor);
	}
	
	
	void setTrans(int aux,double valor) {
		int x=0,z=0;

			for (int i=0;i<clientes.size();i++) {
			for(int j=0;j<clientes.get(i).getTamanho();j++){
				if(aux==clientes.get(i).contasCodigo(j)) {
					x=i;
					z=j;
			}	
			}
		}
			
		clientes.get(x).deposito(z,valor);
	}
	
	void setTransSa(int aux,double valor) {
		int x=0,z=0;

		for (int i=0;i<clientes.size();i++) {
		for(int j=0;j<clientes.get(i).getTamanho();j++){
			if(aux==clientes.get(i).contasCodigo(j)) {
				x=i;
				z=j;
		}	
		}
	}
		clientes.get(x).saque(z,valor);
	}
	
	protected int getTamanho(int[] i) {
		return clientes.get(i[0]).getTamanho();
	}
	
	protected int getTamanhogerente(int[] i) {
		return gerentes.get(i[0]).getTamanho();
	}
	
		
	protected void mudarSenhacliente(int[] i,int senha) {
			clientes.get(i[0]).senha=senha;
		}
	
	protected void mudarSenhagerente(int[] i,int senha) {
		gerentes.get(i[0]).senha=senha;
	}
		
		
	protected void mudarSenhagerente(int i) {
			System.out.println("Digite a nova senha por favor");
			int senha = scanner.nextInt();
			gerentes.get(i).senha=senha;
	}
		
	public void login(int aux,int controle[],int login, int senha,int[] x) {
			int lenght=0;
			if(aux==1) {
				 lenght=clientes.size();
				for(int i=0;i<lenght;i++) {
					if(clientes.get(i).getCodigo()==login && clientes.get(i).senha==senha) {
					controle[0]++;
					x[0]=i;
						}}} 
			else {
				 lenght=gerentes.size();
				for(int i=0;i<lenght;i++) {
					if(gerentes.get(i).getCodigo()==login && gerentes.get(i).senha==senha) {
						controle[0]++;
						x[0]=i;
					}}}}}
		
	

