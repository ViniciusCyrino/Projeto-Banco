
public class ContaPoupanša extends Conta {
	static int base=70000;
	ContaPoupanša (String name){
		this.name = name;
		this.tipo = "Poupanša";
		this.codigo = base + 1; 
		base+=1;
	}}
