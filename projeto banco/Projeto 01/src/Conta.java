import java.util.ArrayList;

public class Conta {
String name;
double saldo;
int codigo;
String tipo;
private double limite=0;
private double juros=0;

ArrayList<extrato> extratos = new ArrayList<>();


	double Getextrato(int i) {
		
			return extratos.get(i).info;
		 
	}
	
	int getTamanho() {
		return extratos.size();
	}

	void deposito (double deposito) {
		saldo = saldo + deposito;
		extratos.add(new extrato(deposito));
	}
	
	void sacar (double saque){
			extratos.add(new extrato(-saque));
			saldo = saldo - saque;		
	}
	
	void setLimite(double limite) {
		this.limite=limite;
	}
	
	void setJuros(double juros) {
		this.juros=juros;
	}
	
	double getSaldo() {
		return saldo;
			}
		
		String getNome() {
			return name;
		}
		
		String getTipo() {
			return tipo;
		}
		
		int getCodigo () {
			return codigo;
		}
	
	}