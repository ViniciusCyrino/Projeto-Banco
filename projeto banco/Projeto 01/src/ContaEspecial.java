public class ContaEspecial extends Conta {
	static int base=40000;
	ContaEspecial (String name){
		this.name = name;
		this.tipo = "Especial";
		this.codigo = base + 1;
		base+=1;
	}}