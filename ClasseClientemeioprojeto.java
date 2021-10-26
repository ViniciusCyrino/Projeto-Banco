import java.util.Scanner;
import java.util.ArrayList;
//import java.util.List;

public  class  Cliente extends Usuario {
	
	String nome;
	int codigo;
	ArrayList<Conta> contas = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	Cliente (String nome, int codigo, int senha){
	this.nome = nome;
	this.codigo = codigo;
	this.senha = senha;
	}
	
	void cria() {
		System.out.println("Deseja criar conta");
		System.out.println("1- Simples");
		System.out.println("2- Especial");
		System.out.println("3- Poupança");
		int aux = scanner.nextInt();
		
		if(aux==1) {
			
			contas.add(new ContaSimples(this.nome));
		} else if(aux==2) {
			contas.add(new ContaEspecial(this.nome));
		} else {
			contas.add(new ContaPoupança(this.nome));
		}
	}
	 
	
	void verSaldo () {
		 int lenght=contas.size();
		 System.out.println("Escolha a conta para ver o saldo");
		 System.out.println("\n");
		 this.imprime();
		 System.out.println("\n");
		 System.out.println("Digite o numero da conta");
		 int aux = scanner.nextInt();
		 
		 for(int i=0;i<lenght;i++) {
			 
			 if(contas.get(i).codigo == aux) {
				 System.out.println(contas.get(i).saldo); 
			 }
		 }
	}
	
	void verExtrato() {
		int lenght=contas.size();
		 System.out.println("Escolha a conta para ver o seu extrato");
		 this.imprime();
		 System.out.println("\n");
		 System.out.println("Digite o numero da conta");
		 int aux = scanner.nextInt();
		 
		 for(int i=0;i<lenght;i++) {
			 
			 if(contas.get(i).codigo == aux) {
				 contas.get(i).extrato();
			 }}}
	
	
	 void imprime() {
		for (Conta model : contas) {
			System.out.print(model.getTipo() + "  " + "conta: " );
            System.out.println(model.getCodigo());
		}}
	 
	 void imprimecompleto() {
		 for (Conta model : contas) {
			 	System.out.println(model.getNome());
				System.out.print(model.getTipo() + "  " + "conta: " );
	            System.out.println(model.getCodigo());
	            model.extrato();
	 }}
	 
	 void deposito() {
		 int lenght=contas.size();
		 System.out.println("Escolha a conta para efetuar o deposito");
		 System.out.println("\n");
		 this.imprime();
		 System.out.println("\n");
		 System.out.println("Digite o numero da conta");
		 int aux = scanner.nextInt();
		 System.out.print("Digite o valor do deposito: ");
		 double aux1 = scanner.nextDouble();
		 
		 for(int i=0;i<lenght;i++) {
			 
			 if(contas.get(i).codigo == aux) {
				 contas.get(i).deposito(aux1);
			 }
		 }
	 }
	 
	 void setTransferencia(double valor, boolean controle) {
		 if(controle) {
			 int lenght=contas.size();
			 System.out.println("Escolha a conta remetente");
			 this.imprime();
			 int aux = scanner.nextInt();
			 for(int i=0;i<lenght;i++) {
				 
				 if(contas.get(i).codigo == aux) {
					 contas.get(i).sacar(valor);
				 }}
		 }else {
			 int lenght=contas.size();
			 System.out.println("Escolha a conta beneficiada");
			 this.imprime();
			 int aux = scanner.nextInt();
			 for(int i=0;i<lenght;i++) {
				 
				 if(contas.get(i).codigo == aux) {
					 contas.get(i).deposito(valor);
				 }}
		 }
	 }
	 
	 
	 void sacarGerente () {

		 int lenght=contas.size();
		 System.out.println("Escolha a conta para efetuar o saque");
		 System.out.println("\n");
		 this.imprime();
		 System.out.println("\n");
		 System.out.println("Digite o numero da conta");
		 int aux = scanner.nextInt();
		 System.out.print("Digite o valor do saque: ");
		 double aux1 = scanner.nextDouble();
		 for(int i=0;i<lenght;i++) {
			 
			 if(contas.get(i).codigo == aux) {
				 contas.get(i).sacarGerente(aux1);
			 }}
	 }
	 
	 void limite(int aux) {
		 if(aux==1) {
			 int lenght=contas.size();
			 for (Conta model : contas) {
				 if(model.tipo=="Especial") {
					System.out.print(model.getTipo() + "  " + "conta: " );
		            System.out.println(model.getCodigo());
				 }
			}
			 System.out.println("Escolha a conta para mudar seu limite");
			 int aux1 = scanner.nextInt();
			 System.out.print("Digite o valor do limite: ");
			 double aux2 = scanner.nextDouble();
			 for(int i=0;i<lenght;i++) {
				 
				 if(contas.get(i).codigo == aux1) {
					 contas.get(i).setLimite(aux2);
				 }}
			 
		 } else {
			 int lenght=contas.size();
			 for (Conta model : contas) {
				 if(model.tipo=="Poupança") {
					System.out.print(model.getTipo() + "  " + "conta: " );
		            System.out.println(model.getCodigo());
				 }
			}
			 System.out.println("Escolha a conta para mudar sua taxa de juros");
			 int aux1 = scanner.nextInt();
			 System.out.print("Digite o valor do juros: ");
			 double aux2 = scanner.nextDouble();
			 for(int i=0;i<lenght;i++) {
				 
				 if(contas.get(i).codigo == aux1) {
					 contas.get(i).setJuros(aux2);
				 }}
		 }
	 }
	 
	 void sacar () {

		 int lenght=contas.size();
		 System.out.println("Escolha a conta para efetuar o saque");
		 System.out.println("\n");
		 this.imprime();
		 System.out.println("\n");
		 System.out.println("Digite o numero da conta");
		 int aux = scanner.nextInt();
		 System.out.print("Digite o valor do saque: ");
		 double aux1 = scanner.nextDouble();
		 for(int i=0;i<lenght;i++) {
			 
			 if(contas.get(i).codigo == aux) {
				 contas.get(i).sacar(aux1);
			 }}
	 }
	
	  String getName() {
		    return nome;
		  }
	 String setName(String nome) {
		    this.nome = nome;
		    return nome;
		  }
	  int getCodigo() {
		    return codigo;
		  }
}
