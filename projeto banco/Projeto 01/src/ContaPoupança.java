
public class ContaPoupan�a extends Conta {
	static int base=70000;
	ContaPoupan�a (String name){
		this.name = name;
		this.tipo = "Poupan�a";
		this.codigo = base + 1; 
		base+=1;
	}}
