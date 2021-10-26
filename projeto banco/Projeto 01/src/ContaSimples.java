public class ContaSimples extends Conta {
		static int base=10000;
		ContaSimples (String name){
			this.name = name;
			this.tipo = "Simples";
			this.codigo = base + 1; 
			base++;
		}}