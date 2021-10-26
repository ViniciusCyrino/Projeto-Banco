
public class ContaPoupança extends Conta {
	static int base=70000;
	ContaPoupança (String name){
		this.name = name;
		this.tipo = "Poupança";
		this.codigo = base + 1; 
		base+=1;
	}}
