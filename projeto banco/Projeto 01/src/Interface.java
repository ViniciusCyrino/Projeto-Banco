import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

public class Interface extends JFrame {
Usuario usu = new Usuario();
int cliente[]= {0};
int gerente[]= {0};
	

void criaBanco() {
	usu.criarGerente();
}
	void fazertexto(int x, int y, int x2, int y2, String texto,JFrame frame)
	{
		JLabel escrever = new JLabel();
		escrever.setBounds(x, y, x2, y2);
		escrever.setForeground(Color.white);
		escrever.setText(texto);
		frame.add(escrever);
		
	}
	void fazerJanela(String title)
	{
		this.setTitle(title);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0x123456));
		this.setSize(500,500);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void aviso(String texto)
	{
		JOptionPane.showMessageDialog(null,texto);
	}
	String caixadetexto(int x, int y, int x1, int y2)
	{
			JTextField textfield = new JTextField();
			textfield.setPreferredSize(new Dimension(250,40));
			textfield.setBounds(x, y, x1, y2);
			this.add(textfield);
			return textfield.getText();
	}

	void inserirlogin(int qual)
	{
		int[] controle= {0};
		JFrame frame = new JFrame();
		frame.setTitle("Inserir Login - BANCO PARADIGMAS");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fazertexto(80,250,150,30,"USUARIO: ",frame);
		fazertexto(80,300,150,30,"SENHA: ",frame);
		JTextField textfield = new JTextField();
		textfield.setBounds(150, 250, 150, 30);
		frame.add(textfield);
		JTextField textfield2 = new JTextField();
		textfield2.setBounds(150, 300, 150, 30);
		frame.add(textfield2);
		JButton button = new JButton("entrar");
		button.setBounds(180, 340, 90, 20);
		button.setFocusable(false);
		
		if(qual==1)
		{
			fazertexto(160,150,150,30,"Logar como Cliente",frame);
			button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	frame.setVisible(false);
	            	int codigo = Integer.parseInt(textfield.getText());
	            	int senha = Integer.parseInt(textfield2.getText());
	                usu.login(1,controle,codigo,senha,cliente);
	                if(controle[0]==0) {
		                inserirlogin(1);
		                }
	                else {
		                menu_cliente();
		                }
	            }
	        });
		}
		else
		{
			
			fazertexto(160,150,150,30,"Logar como Gerente",frame);
			button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	frame.setVisible(false);
	            	int codigo = Integer.parseInt(textfield.getText());
	            	int senha = Integer.parseInt(textfield2.getText());
	                usu.login(2,controle,codigo,senha,gerente);
	                if(controle[0]==0) {
	                inserirlogin(2);
	                }
	                else {
	                menu_gerente();
	                }
	            }
	        });
		}
		frame.add(button);
	}
	void menu_cliente()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Banco Paradigmas");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel escrever = new JLabel("Bem vindo, selecione a opção desejada: ");
		escrever.setBounds(10, 10, 300, 50);
		escrever.setForeground(Color.white);
		JButton button1 = new JButton("Criar Conta");
		button1.setBounds(150, 100, 200, 25);
		button1.setFocusable(false);
		button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
                criar_conta();
            }
        });
		frame.add(button1);
		JButton button2 = new JButton("Depositar");
		button2.setBounds(150, 150, 200, 25);
		button2.setFocusable(false);
		button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	selecionar_conta(1);
            }
        });
		frame.add(button2);
		JButton button3 = new JButton("Sacar");
		button3.setBounds(150, 200, 200, 25);
		button3.setFocusable(false);
		button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	selecionar_conta(2);
            }
        });
		frame.add(button3);
		JButton button4 = new JButton("Verificar saldo");
		button4.setBounds(150, 250, 200, 25);
		button4.setFocusable(false);
		button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	selecionar_conta(3);
            }
        });
		frame.add(button4);
		JButton button5 = new JButton("Verificar extrato");
		button5.setBounds(150, 300, 200, 25);
		button5.setFocusable(false);
		button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	selecionar_conta(4);
            }
        });
		frame.add(button5);
		JButton button6 = new JButton("Alterar senha");
		button6.setBounds(150, 350, 200, 25);
		button6.setFocusable(false);
		button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	alterar_senha();
            }
        });
		frame.add(button6);
		JButton buttonS = new JButton("sair");
		buttonS.setBounds(420, 430, 55, 20);
		buttonS.setFocusable(false);
		buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frame.setVisible(false);
            	tela_de_entrada();
            }
        });
		frame.add(buttonS);
		frame.add(escrever);
		
	}
	
	
	void selecionar_conta_gerente(int aux)
    {
	
    
         JFrame frame = new JFrame();
            frame.setTitle("Selecionar Conta - BANCO PARADIGMAS");
            frame.setLayout(null);
            frame.getContentPane().setBackground(new Color(0x123456));
            frame.setSize(500,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             JLabel escrever = new JLabel();
                escrever.setBounds(160, 30, 200, 50);
                escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                escrever.setForeground(Color.white);
                escrever.setText("Contas Disponiveis");
                frame.add(escrever);
                JLabel escrever2 = new JLabel();
                escrever2.setBounds(300, 300, 200, 50);
                escrever2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                escrever2.setForeground(Color.white);
                escrever2.setText("Insira o numero da conta");
                frame.add(escrever2);
                JTextField textfield = new JTextField();
                textfield.setBounds(300, 350, 150, 30);
                textfield.setVisible(true);
                frame.add(textfield);
                JButton button = new JButton("confirmar");
                button.setBounds(330, 400, 100, 20);
                button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int aux2 = Integer.parseInt(textfield.getText());
                        int z=usu.getTamanho(cliente);
                        int[] contas=new int[z];
                        contas=usu.getContas(cliente);
                        int u=0;
                        for(int i=0;i<z;i++) {
                        	if(contas[i]==aux2) {
                        		u=i;
                        	}
                        	
                        }
                frame.setVisible(false);
                       if(aux==1) {
                          verificar_info_conta(u);
                       }
                       else if(aux==2) {
                         menu_deposito_gerente(u);
                       }else if(aux==3) {
                    	   menu_saque_gerente(u);
                       }else {
                           verificar_extrato(u);                         
                       }
                    }
                });
                frame.add(button);
                
            JTextArea informacao = new JTextArea();
            informacao.setBackground(new Color(0x123456));
            informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            informacao.setEditable(false);
            JScrollPane scroll = new JScrollPane(informacao);
            
            scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            scroll.setBounds(50, 80, 200, 370);
            frame.add(scroll);

                informacao.setForeground(Color.white);
                int z=usu.getTamanho(cliente);
                int[] contas=new int[z];
                contas=usu.getContas(cliente);
                for(int i=0;i<usu.getTamanho(cliente);i++) {
                    if(contas[i]/10000==1) {
                    informacao.append(String.valueOf("Conta Simples: "+contas[i])+"\n");
                    }
                    else; if(contas[i]/10000==4) {
                        informacao.append(String.valueOf("Conta Especial: "+contas[i])+"\n");
                        }
                    else; if(contas[i]/10000==7) {
                        informacao.append(String.valueOf("Conta Poupança: "+contas[i])+"\n");
                        }
                        
                }
                
                
    }
	
	
	void selecionar_conta(int aux)
    {
	
    
         JFrame frame = new JFrame();
            frame.setTitle("Selecionar Conta - BANCO PARADIGMAS");
            frame.setLayout(null);
            frame.getContentPane().setBackground(new Color(0x123456));
            frame.setSize(500,500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             JLabel escrever = new JLabel();
                escrever.setBounds(160, 30, 200, 50);
                escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                escrever.setForeground(Color.white);
                escrever.setText("Contas Disponiveis");
                frame.add(escrever);
                JLabel escrever2 = new JLabel();
                escrever2.setBounds(300, 300, 200, 50);
                escrever2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                escrever2.setForeground(Color.white);
                escrever2.setText("Insira o numero da conta");
                frame.add(escrever2);
                JTextField textfield = new JTextField();
                textfield.setBounds(300, 350, 150, 30);
                textfield.setVisible(true);
                frame.add(textfield);
                JButton button = new JButton("confirmar");
                button.setBounds(330, 400, 100, 20);
                button.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int aux2 = Integer.parseInt(textfield.getText());
                        int z=usu.getTamanho(cliente);
                        int[] contas=new int[z];
                        contas=usu.getContas(cliente);
                        int u=0;
                        for(int i=0;i<z;i++) {
                        	if(contas[i]==aux2) {
                        		u=i;
                        	}
                        	
                        }
                frame.setVisible(false);
                       if(aux==1) {
                           menu_deposito(u);
                       }
                       else if(aux==2) {
                           menu_saque(u);
                       }else if(aux==3) {
                           verificar_saldo(u);
                       }else {
                           verificar_extrato(u);                         
                       }
                    }
                });
                frame.add(button);
                
            JTextArea informacao = new JTextArea();
            informacao.setBackground(new Color(0x123456));
            informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            informacao.setEditable(false);
            JScrollPane scroll = new JScrollPane(informacao);
            
            scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            scroll.setBounds(50, 80, 200, 370);
            frame.add(scroll);

                informacao.setForeground(Color.white);
                int z=usu.getTamanho(cliente);
                int[] contas=new int[z];
                contas=usu.getContas(cliente);
                for(int i=0;i<usu.getTamanho(cliente);i++) {
                    if(contas[i]/10000==1) {
                    informacao.append(String.valueOf("Conta Simples: "+contas[i])+"\n");
                    }
                    else; if(contas[i]/10000==4) {
                        informacao.append(String.valueOf("Conta Especial: "+contas[i])+"\n");
                        }
                    else; if(contas[i]/10000==7) {
                        informacao.append(String.valueOf("Conta Poupança: "+contas[i])+"\n");
                        }
                        
                }
                
                
    }
	
	
	void criar_conta()
	{
	    JFrame frame = new JFrame();
	    frame.setTitle("Banco Paradigmas");
	    frame.setLayout(null);
	    frame.getContentPane().setBackground(new Color(0x123456));
	    frame.setSize(500,500);
	    frame.setResizable(false);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JLabel escrever = new JLabel("Selecione a conta que deseja criar");
	    escrever.setBounds(10, 10, 300, 50);
	    escrever.setForeground(Color.white);
	    frame.add(escrever);
	    JButton button1 = new JButton("Conta Simples");
	    button1.setBounds(150, 140, 200, 25);
	    button1.setFocusable(false);
	    button1.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            frame.setVisible(false);
	            usu.setContas(cliente, 1);
	             aviso("conta criada com sucesso");
	            menu_cliente();
	           
	           
	        }
	    });
	    frame.add(button1);
	    JButton button2 = new JButton("Conta Especial");
	    button2.setBounds(150, 200, 200, 25);
	    button2.setFocusable(false);
	    button2.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            frame.setVisible(false);
	            usu.setContas(cliente, 2);
	           aviso("conta criada com sucesso");
	            menu_cliente();
	            
	        }
	    });
	    frame.add(button2);
	    JButton button3 = new JButton("Conta Poupança");
	    button3.setBounds(150, 260, 200, 25);
	    button3.setFocusable(false);
	    button3.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            frame.setVisible(false);
	            usu.setContas(cliente, 87);
	          aviso("conta criada com sucesso");
	            menu_cliente(); 
	            
	        }
	    });
	    frame.add(button3);
	    
	    JButton buttonS = new JButton("sair");
	    buttonS.setBounds(420, 430, 55, 20);
	    buttonS.setFocusable(false);
	    buttonS.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            frame.setVisible(false);
	            menu_cliente();
	        }
	    });
	    frame.add(buttonS);
	    
	}
	
	void menu_gerente() {
        JFrame frame = new JFrame();
        frame.setTitle("Menu Gerente - Banco Paradigmas");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel escrever = new JLabel("Bem vindo, selecione a opção desejada: ");
        escrever.setBounds(10, 10, 300, 50);
        escrever.setForeground(Color.white);
        JButton button1 = new JButton("Verificar Clientes");
        button1.setBounds(100, 70, 200, 25);
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                verificar_clientes();
            }
        });
        frame.add(button1);

        JButton button2 = new JButton("Verificar Conta");
        button2.setBounds(100, 110, 200, 25);
        button2.setFocusable(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                selecionar_clientes(1);
            }
        });
        frame.add(button2);
        JButton button3 = new JButton("Aplicação");
        button3.setBounds(100, 150, 200, 25);
        button3.setFocusable(false);
        frame.add(button3);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                selecionar_clientes(2);
            }
        });
        JButton button4 = new JButton("Transferência");
        button4.setBounds(100, 190, 200, 25);
        button4.setFocusable(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                transferencia();
            }
        });
        frame.add(button4);
        JButton button5 = new JButton("Retirada");
        button5.setBounds(100, 230, 200, 25);
        button5.setFocusable(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                selecionar_clientes(3);
            }
        });
        frame.add(button5);
        JButton button6 = new JButton("Cadastrar limites/juros");
        button6.setBounds(100, 270, 200, 25);
        button6.setFocusable(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                cadastrar_limites_juros();
            }
        });
        frame.add(button6);
        JButton button7 = new JButton("Cadastrar novo cliente");
        button7.setBounds(100, 310, 200, 25);
        button7.setFocusable(false);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                 menu_cadastro_cliente();
            }
        });
        frame.add(button7);
        JButton button8 = new JButton("Cadastrar novo gerente");
        button8.setBounds(100, 350, 200, 25);
        button8.setFocusable(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                menu_cadastro_gerente();
            }
        });
        frame.add(button8);
        JButton button9 = new JButton("Mudar Senha");
        button9.setBounds(100, 390, 200, 25);
        button9.setFocusable(false);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame.setVisible(false);
                alterar_senha_gerente();
            }
        });
        frame.add(button9);
        JButton buttonS = new JButton("sair");
        buttonS.setBounds(420, 430, 55, 20);
        buttonS.setFocusable(false);
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
               tela_de_entrada();
            }
        });
        frame.add(buttonS);
        frame.add(escrever);

    }
	
	
	
	void selecionar_clientes(int aux)
    {

        JFrame frame = new JFrame();
           frame.setTitle("Selecionar Cliente - BANCO PARADIGMAS");
           frame.setLayout(null);
           frame.getContentPane().setBackground(new Color(0x123456));
           frame.setSize(500,500);
           frame.setResizable(false);
           frame.setVisible(true);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel escrever = new JLabel();
               escrever.setBounds(160, 30, 200, 50);
               escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
               escrever.setForeground(Color.white);
               escrever.setText("Clientes Disponiveis");
               frame.add(escrever);
               JLabel escrever2 = new JLabel();
               escrever2.setBounds(300, 300, 200, 50);
               escrever2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
               escrever2.setForeground(Color.white);
               escrever2.setText("Insira o cpf do cliente");
               frame.add(escrever2);
               JTextField textfield = new JTextField();
               textfield.setBounds(300, 350, 150, 30);
               textfield.setVisible(true);
               frame.add(textfield);
               JButton button = new JButton("confirmar");
               button.setBounds(330, 400, 100, 20);
               button.addActionListener(new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                       int aux2 = Integer.parseInt(textfield.getText());
                       int z=usu.getTamanhogerente(gerente);
                       int[] clientes=new int[z];
                       clientes=usu.getClientes(gerente);
                       for(int i=0;i<z;i++) {
                           if(clientes[i]==aux2) {
                               cliente[0]=i;
                           }
                           
                       }
               frame.setVisible(false);     
                      selecionar_conta_gerente(aux);
                   }
               });
               frame.add(button);
               
           JTextArea informacao = new JTextArea();
           informacao.setBackground(new Color(0x123456));
           informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           informacao.setEditable(false);
           JScrollPane scroll = new JScrollPane(informacao);
           
           scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           scroll.setBounds(50, 80, 200, 370);
           frame.add(scroll);

               informacao.setForeground(Color.white);
               int z=usu.getTamanhogerente(gerente);
               int[] clientes=new int[z];
               String[] nome= new String[z];
               clientes=usu.getClientes(gerente);
               nome=usu.getNomes(gerente);
               for(int i=0;i<usu.getTamanhogerente(gerente);i++) {
            	   informacao.append(String.valueOf(nome[i]+"  "+"CPF "+clientes[i])+"\n");                
               }
               
               
   }
	
	
	
	
	void menu_cadastro_cliente()
    { 
        JFrame frame = new JFrame();
        frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textfield = new JTextField();
        textfield.setBounds(150, 100, 120, 30);
        frame.add(textfield);

        JTextField textfield2 = new JTextField();
        textfield2.setBounds(150, 150, 120, 30);
        frame.add(textfield2);

        JTextField textfield3 = new JTextField();
        textfield3.setBounds(150, 200, 120, 30);
        frame.add(textfield3);

        fazertexto(100,100,150,30,"Nome: ",frame);
        fazertexto(100,150,150,30,"CPF: ",frame);
        fazertexto(100,200,150,30,"Senha: ",frame);
        JButton button1 = new JButton("Cadastrar");
        button1.setBounds(160, 250, 90, 30);
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
              String nome = textfield.getText();
               int cpf = Integer.parseInt(textfield2.getText());
              int senha = Integer.parseInt(textfield3.getText());
              usu.criaCliente(nome, cpf, senha, gerente);
              menu_gerente();
            }
        });
        frame.add(button1);
        JButton buttonS = new JButton("sair");
        buttonS.setBounds(420, 430, 55, 20);
        buttonS.setFocusable(false);
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
               menu_gerente();
            }
        });

        frame.add(buttonS);


    }
	
	void menu_cadastro_gerente()
    { 
        JFrame frame = new JFrame();
        frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textfield = new JTextField();
        textfield.setBounds(150, 100, 120, 30);
        frame.add(textfield);

        JTextField textfield2 = new JTextField();
        textfield2.setBounds(150, 150, 120, 30);
        frame.add(textfield2);

        JTextField textfield3 = new JTextField();
        textfield3.setBounds(150, 200, 120, 30);
        frame.add(textfield3);

        fazertexto(100,100,150,30,"Nome: ",frame);
        fazertexto(100,150,150,30,"CPF: ",frame);
        fazertexto(100,200,150,30,"Senha: ",frame);
        JButton button1 = new JButton("Cadastrar");
        button1.setBounds(160, 250, 90, 30);
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
              String nome = textfield.getText();
              int  cpf = Integer.parseInt(textfield2.getText());
               int senha = Integer.parseInt(textfield3.getText());
        usu.criaGerente(nome, cpf, senha);
        menu_gerente();
            }
        });
        frame.add(button1);
        JButton buttonS = new JButton("sair");
        buttonS.setBounds(420, 430, 55, 20);
        buttonS.setFocusable(false);
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
               menu_gerente();
            }
        });

        frame.add(buttonS);


    }
	
	void menu_deposito(int aux)
	{double saldo = usu.getSaldo(cliente,aux);
		JFrame frame = new JFrame();
		frame.setTitle("Realizar Depósito - BANCO PARADIGMAS");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textfield = new JTextField();
		textfield.setBounds(190, 200, 120, 30);
		frame.add(textfield);
		
		JLabel escrever = new JLabel();
		escrever.setBounds(180, 120, 200, 50);
		escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		escrever.setForeground(Color.white);
		escrever.setText(String.valueOf("R$ " + saldo));
		frame.add(escrever);
		
	
	fazertexto(100,120,100,50,"Saldo Atual:",frame);
	fazertexto(80,190,100,50,"Valor Depósito:",frame);
	
	JButton button1 = new JButton("Confirmar");
	button1.setBounds(205, 250, 90, 20);
	button1.setFocusable(false);
	button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
           double valor = Double.parseDouble(textfield.getText());
           usu.setSaldo(cliente,aux,valor);
           menu_cliente();
        }
    });
	frame.add(button1);
	
	JButton buttonS = new JButton("sair");
	buttonS.setBounds(420, 430, 55, 20);
	buttonS.setFocusable(false);
	frame.add(buttonS);
}
	
	void menu_deposito_gerente(int aux)
	{double saldo = usu.getSaldo(cliente,aux);
		JFrame frame = new JFrame();
		frame.setTitle("Realizar Depósito - BANCO PARADIGMAS");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textfield = new JTextField();
		textfield.setBounds(190, 200, 120, 30);
		frame.add(textfield);
		
		JLabel escrever = new JLabel();
		escrever.setBounds(180, 120, 200, 50);
		escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		escrever.setForeground(Color.white);
		escrever.setText(String.valueOf("R$ " + saldo));
		frame.add(escrever);
		
	
	fazertexto(100,120,100,50,"Saldo Atual:",frame);
	fazertexto(80,190,100,50,"Valor Depósito:",frame);
	
	JButton button1 = new JButton("Confirmar");
	button1.setBounds(205, 250, 90, 20);
	button1.setFocusable(false);
	button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
           double valor = Double.parseDouble(textfield.getText());
           usu.setSaldo(cliente,aux,valor);
           menu_gerente();
        }
    });
	frame.add(button1);
	
	JButton buttonS = new JButton("sair");
	buttonS.setBounds(420, 430, 55, 20);
	buttonS.setFocusable(false);
	buttonS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
          menu_gerente();
        }
    });
	frame.add(buttonS);
}
	
	
	void menu_saque(int aux)
	{
		double saldo = usu.getSaldo(cliente,aux);

        JFrame frame = new JFrame();
        frame.setTitle("Realizar Saque - BANCO PARADIGMAS");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textfield = new JTextField();
        textfield.setBounds(190, 200, 120, 30);
        frame.add(textfield);

        JLabel escrever = new JLabel();
        escrever.setBounds(180, 120, 200, 50);
        escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        escrever.setForeground(Color.white);
        escrever.setText(String.valueOf("R$ " + saldo));
        frame.add(escrever);


    fazertexto(100,120,100,50,"Saldo Atual:",frame);
    fazertexto(80,190,100,50,"Valor do Saque:",frame);

    JButton button1 = new JButton("Confirmar");
    button1.setBounds(205, 250, 90, 20);
    button1.setFocusable(false);
    button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
           double valor = Double.parseDouble(textfield.getText());
           usu.setSaldoSa(cliente,aux,valor);
           menu_cliente();
           
        }
    });

    frame.add(button1);
	}
	
	void menu_saque_gerente(int aux)
	{
		double saldo = usu.getSaldo(cliente,aux);

        JFrame frame = new JFrame();
        frame.setTitle("Realizar Saque - BANCO PARADIGMAS");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x123456));
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textfield = new JTextField();
        textfield.setBounds(190, 200, 120, 30);
        frame.add(textfield);

        JLabel escrever = new JLabel();
        escrever.setBounds(180, 120, 200, 50);
        escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        escrever.setForeground(Color.white);
        escrever.setText(String.valueOf("R$ " + saldo));
        frame.add(escrever);


    fazertexto(100,120,100,50,"Saldo Atual:",frame);
    fazertexto(80,190,100,50,"Valor do Saque:",frame);

    JButton button1 = new JButton("Confirmar");
    button1.setBounds(205, 250, 90, 20);
    button1.setFocusable(false);
    button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
           double valor = Double.parseDouble(textfield.getText());
           usu.setSaldoSa(cliente,aux,valor);
           menu_gerente();
           
        }
    });

    frame.add(button1);
	}
	
	void verificar_saldo(int aux)
    {
		double saldo = usu.getSaldo(cliente,aux);
           JFrame frame = new JFrame();
           frame.setTitle("Verificar Saldo - BANCO PARADIGMAS");
           frame.setLayout(null);
           frame.getContentPane().setBackground(new Color(0x123456));
           frame.setSize(500,500);
           frame.setResizable(false);
           frame.setVisible(true);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           JLabel escrever = new JLabel();
           escrever.setBounds(180, 120, 200, 50);
           escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
           escrever.setForeground(Color.white);
           escrever.setText(String.valueOf("R$ " + saldo));
           frame.add(escrever);


       fazertexto(100,120,100,50,"Saldo Atual:",frame);


       JButton button1 = new JButton("Confirmar");
       button1.setBounds(205, 250, 90, 20);
       button1.setFocusable(false);
       button1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
       frame.setVisible(false);
              menu_cliente();
           }
       });
       frame.add(button1);

       JButton buttonS = new JButton("sair");
       buttonS.setBounds(420, 430, 55, 20);
       buttonS.setFocusable(false);

       buttonS.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
       frame.setVisible(false);
              menu_cliente();
           }
       });
       frame.add(buttonS);
    }
 
 
 void verificar_extrato(int aux)
 {	JFrame frame = new JFrame();
	frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
	frame.setLayout(null);
	frame.getContentPane().setBackground(new Color(0x123456));
	frame.setSize(500,500);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 JLabel escrever = new JLabel();
		escrever.setBounds(160, 30, 200, 50);
		escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		escrever.setForeground(Color.white);
		escrever.setText("Extrato");
		frame.add(escrever);
	JTextArea informacao = new JTextArea();
	informacao.setBackground(new Color(0x123456));
	informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	informacao.setForeground(Color.white);
	informacao.setEditable(false);
	JScrollPane scroll = new JScrollPane(informacao);
	
	scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	scroll.setBounds(100, 80, 200, 370);
	frame.add(scroll);
	int z=usu.tamExtrato(cliente,aux);
    double[] contas=new double[z];
    contas=usu.getExtrato(cliente,aux);
    for(int i=0;i<usu.tamExtrato(cliente,aux);i++) {
        
        informacao.append(String.valueOf(contas[i])+"\n"); 
    }
    
    JButton buttonS = new JButton("sair");
    buttonS.setBounds(420, 430, 55, 20);
    buttonS.setFocusable(false);

    buttonS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
    frame.setVisible(false);
           menu_cliente();
        }
    });
    frame.add(buttonS);
	
 }
 
 
	 void alterar_senha() {
	        JFrame frame = new JFrame();
	        frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
	        frame.setLayout(null);
	        frame.getContentPane().setBackground(new Color(0x123456));
	        frame.setSize(500, 500);
	        frame.setResizable(false);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JTextField textfield = new JTextField();
	        textfield.setBounds(190, 200, 120, 30);
	        frame.add(textfield);

	        fazertexto(100, 30, 300, 50, "ATENÇÃO: A senha deve conter 6 caracteres ", frame);
	        fazertexto(80, 190, 100, 50, "Nova Senha:", frame);

	        JButton button1 = new JButton("Confirmar");
	        button1.setBounds(205, 250, 90, 20);
	        button1.setFocusable(false);
	        button1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	        frame.setVisible(false);	              
	              int nova_senha = Integer. parseInt(textfield.getText());
	              usu.mudarSenhacliente(cliente, nova_senha);
	              menu_cliente();
	            }
	        });

	        frame.add(button1);

	        JButton buttonS = new JButton("sair");
	        buttonS.setBounds(420, 430, 55, 20);
	        buttonS.setFocusable(false);
	        buttonS.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	        frame.setVisible(false);
	               menu_cliente();
	            }
	        });

	        frame.add(buttonS);
	    }
	 
	 void alterar_senha_gerente() {
	        JFrame frame = new JFrame();
	        frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
	        frame.setLayout(null);
	        frame.getContentPane().setBackground(new Color(0x123456));
	        frame.setSize(500, 500);
	        frame.setResizable(false);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JTextField textfield = new JTextField();
	        textfield.setBounds(190, 200, 120, 30);
	        frame.add(textfield);

	        fazertexto(100, 30, 300, 50, "ATENÇÃO: A senha deve conter 6 caracteres ", frame);
	        fazertexto(80, 190, 100, 50, "Nova Senha:", frame);

	        JButton button1 = new JButton("Confirmar");
	        button1.setBounds(205, 250, 90, 20);
	        button1.setFocusable(false);
	        button1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	        frame.setVisible(false);	              
	              int nova_senha = Integer. parseInt(textfield.getText());
	              usu.mudarSenhagerente(gerente, nova_senha);
	              menu_gerente();
	            }
	        });

	        frame.add(button1);

	        JButton buttonS = new JButton("sair");
	        buttonS.setBounds(420, 430, 55, 20);
	        buttonS.setFocusable(false);
	        buttonS.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	        frame.setVisible(false);
	               menu_cliente();
	            }
	        });

	        frame.add(buttonS);
	    }
	 
 void tela_de_entrada()
 {
	 	JFrame cobrir = new JFrame();
	 	cobrir.setTitle("BANCO PARADIGMAS");
	 	cobrir.setLayout(null);
	 	cobrir.getContentPane().setBackground(new Color(0x123456));
	 	cobrir.setSize(500,500);
	 	cobrir.setResizable(false);
	 	cobrir.setVisible(true);
	 	cobrir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 JProgressBar bar = new JProgressBar();
	 JLabel escrever = new JLabel();
		escrever.setBounds(120, 120, 250, 50);
		escrever.setFont(new Font("TimesRoman", Font.PLAIN, 22));
		escrever.setForeground(Color.white);
		escrever.setText("BANCO "+"\n"+"PARADIGMAS");
		cobrir.add(escrever);
		 JLabel escrever2 = new JLabel();
			escrever2.setBounds(100, 100, 300, 50);
			escrever2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			escrever2.setForeground(Color.white);
			escrever2.setText("Bem vindo ao ambiente virtual do");
			cobrir.add(escrever2);
			
			JLabel escrever3 = new JLabel();
			escrever3.setBounds(180, 300, 250, 50);
			escrever3.setFont(new Font("TimesRoman", Font.PLAIN, 13));
			escrever3.setForeground(Color.white);
			escrever3.setVisible(false);
			escrever3.setText("Selecione o tipo de usuário");
			cobrir.add(escrever3);
		 
		 JButton button1 = new JButton("Cliente");
			button1.setBounds(100, 350, 90, 30);
			button1.setFocusable(false);
			button1.setVisible(false);
			button1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	cobrir.setVisible(false);
	                inserirlogin(1);
	            }
	        });
			cobrir.add(button1);
			JButton button2 = new JButton("Gerente");
			button2.setBounds(300, 350, 90, 30);
			button2.setFocusable(false);
			button2.setVisible(false);
			button2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	cobrir.setVisible(false);
	                inserirlogin(2);
	            }
	        });
			cobrir.add(button2);
	 
	 bar.setValue(0);
	 bar.setBounds(50,250,400,12);
	 bar.setStringPainted(true);
	 bar.setForeground(Color.red);
	 cobrir.add(bar);
	 
			int counter =0;
			
			while(counter<=100) {
				
				bar.setValue(counter);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter +=1;
			}
			bar.setString("Completo!");
			escrever3.setVisible(true);
			button1.setVisible(true);
			button2.setVisible(true);
		
 }

 void verificar_clientes()
 {
 
 JFrame frame = new JFrame();
    frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(0x123456));
    frame.setSize(500,500);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JLabel escrever = new JLabel();
        escrever.setBounds(160, 30, 200, 50);
        escrever.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        escrever.setForeground(Color.white);
        escrever.setText("Clientes Cadastrados");
        frame.add(escrever);
    JTextArea informacao = new JTextArea();
    informacao.setBackground(new Color(0x123456));
    informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    informacao.setEditable(false);
    JScrollPane scroll = new JScrollPane(informacao);

    scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    scroll.setBounds(100, 80, 200, 370);
    frame.add(scroll);

        informacao.setForeground(Color.white);
        cliente[0]=0;
        int y=usu.getTamanho(cliente);
        int[] contas=new int[y];
        contas=usu.getContas(cliente);
        int z=usu.getTamanhogerente(gerente);
        int[] clientes=new int[z];
        String[] nome= new String[z];
        clientes=usu.getClientes(gerente);
        nome=usu.getNomes(gerente);
       int i=0;
        while(i<usu.getTamanhogerente(gerente)) {
        	informacao.append(String.valueOf(nome[i]+"  "+"CPF "+clientes[i])+"\n"); 
        	i++;
     	  for(int j=0;j<usu.getTamanho(cliente);j++) {
              if(contas[j]/10000==1) {
              informacao.append(String.valueOf("Conta Simples: "+contas[j])+"\n");
              }
              else if(contas[j]/10000==4) {
                  informacao.append(String.valueOf("Conta Especial: "+contas[j])+"\n");
                  }
              else if(contas[j]/10000==7) {
                  informacao.append(String.valueOf("Conta Poupança: "+contas[j])+"\n");
                  }
          }
     	  if(i!=usu.getTamanhogerente(gerente)) {
     		 cliente[0]=i;
        	 y=usu.getTamanho(cliente);
            contas=usu.getContas(cliente);  
     	  }
     	 
        }
        JButton buttonS = new JButton("sair");
        buttonS.setBounds(420, 430, 55, 20);
        buttonS.setFocusable(false);
        buttonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        frame.setVisible(false);
              menu_gerente();
            }
        });
        frame.add(buttonS);

}
 
 
 void cadastrar_limites_juros()
 {
     JFrame frame = new JFrame();
     frame.setTitle("Cadastro Clientes - BANCO PARADIGMAS");
     frame.setLayout(null);
     frame.getContentPane().setBackground(new Color(0x123456));
     frame.setSize(500,500);
     frame.setResizable(false);
     frame.setVisible(true);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             JTextField textfield = new JTextField();
             textfield.setBounds(180, 100, 120, 30);
             frame.add(textfield);
             JTextField textfield2 = new JTextField();
             textfield2.setBounds(180, 280, 120, 30);
             frame.add(textfield2);
             
             
         
         fazertexto(180,50,300,50," Alteração de Limite",frame);
         fazertexto(180,230,300,50," Alteração de Juros",frame);
         fazertexto(80,90,100,50,"Novo Limite:",frame);
         fazertexto(80,270,100,50,"Novo Limite:",frame);
         
         JButton button1 = new JButton("Alterar limite");
         button1.setBounds(180, 140, 120, 20);
         button1.setFocusable(false);
         button1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
         frame.setVisible(false);
         double limite = Double.parseDouble(textfield.getText());
        usu.limite(gerente, 2,limite);
               menu_gerente();
             }
         });
         frame.add(button1);
         JButton button2 = new JButton("Alterar juros");
         button2.setBounds(180, 320, 120, 20);
         button2.setFocusable(false);
         button2.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
         frame.setVisible(false);
         double juros = Double.parseDouble(textfield2.getText());
         usu.limite(gerente, 1,juros);
               menu_gerente();
             }
         });
         frame.add(button2);
         
         JButton buttonS = new JButton("sair");
         buttonS.setBounds(420, 430, 55, 20);
         buttonS.setFocusable(false);
         buttonS.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
         frame.setVisible(false);
               menu_gerente();
             }
         });
         frame.add(buttonS);
 }

void transferencia()
{
    JFrame frame = new JFrame();
    frame.setTitle("Aplicação - BANCO PARADIGMAS");
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(0x123456));
    frame.setSize(500,500);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fazertexto(300,80,100,50,"Retirar da conta: ",frame);
    fazertexto(300,150,100,50,"Conta Destino: ",frame);
    fazertexto(300,230,100,50,"Valor: ",frame);
    JTextField textfield = new JTextField();
    textfield.setBounds(300, 130, 120, 30);
    frame.add(textfield);
    JTextField textfield2 = new JTextField();
    textfield2.setBounds(300, 200, 120, 30);
    frame.add(textfield2);
    JTextField textfield3 = new JTextField();
    textfield3.setBounds(300, 270, 120, 30);
    frame.add(textfield3);
    JTextArea informacao = new JTextArea();
    informacao.setBackground(new Color(0x123456));
    informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    informacao.setEditable(false);
    JScrollPane scroll = new JScrollPane(informacao);
    
    scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    scroll.setBounds(50, 80, 200, 370);
    frame.add(scroll);

        informacao.setForeground(Color.white);
        cliente[0]=0;
        int y=usu.getTamanho(cliente);
        int[] contas=new int[y];
        contas=usu.getContas(cliente);
        int z=usu.getTamanhogerente(gerente);
        int[] clientes=new int[z];
        String[] nome= new String[z];
        clientes=usu.getClientes(gerente);
        nome=usu.getNomes(gerente);
        for(int i=0;i<usu.getTamanhogerente(gerente);i++) {
     	   informacao.append(String.valueOf(nome[i]+"  "+"CPF "+clientes[i])+"\n"); 
     	  for(int j=0;j<usu.getTamanho(cliente);j++) {
              if(contas[j]/10000==1) {
              informacao.append(String.valueOf("Conta Simples: "+contas[j])+"\n");
              }
              else if(contas[j]/10000==4) {
                  informacao.append(String.valueOf("Conta Especial: "+contas[j])+"\n");
                  }
              else if(contas[j]/10000==7) {
                  informacao.append(String.valueOf("Conta Poupança: "+contas[j])+"\n");
                  }
          }
     	 cliente[0]=i;
    	  y=usu.getTamanho(cliente);
        contas=usu.getContas(cliente);
        }
    
    JButton button1 = new JButton("confirmar");
    button1.setBounds(310, 320, 100, 20);
    button1.setFocusable(false);
    button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            frame.setVisible(false);
            int conta_retirada = Integer.parseInt(textfield.getText());
             int conta_alvo = Integer.parseInt(textfield2.getText());
             double valor = Double.parseDouble(textfield3.getText());
             usu.setTransSa(conta_retirada,valor);
             usu.setTrans(conta_alvo,valor);
            menu_gerente();    
        }
    });
    frame.add(button1);
    JButton buttonS = new JButton("sair");
    buttonS.setBounds(420, 430, 55, 20);
    buttonS.setFocusable(false);
    buttonS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            frame.setVisible(false);
            menu_gerente();
             
        }
    });
    frame.add(buttonS);
}
void verificar_info_conta(int aux)
{
    String nome = usu.getNome(cliente);
    int numero_conta = usu.getCodigo(cliente,aux);
    int tipo_da_conta = numero_conta/10000;
    
    
    JFrame frame = new JFrame();

    frame.setTitle("Informações Clientes - BANCO PARADIGMAS");
    frame.setLayout(null);
    frame.getContentPane().setBackground(new Color(0x123456));
    frame.setSize(500,500);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     JLabel escrever = new JLabel();
        escrever.setBounds(320, 30, 200, 50);
        escrever.setFont(new Font("TimesRoman", Font.PLAIN, 22));
        escrever.setForeground(Color.white);
        escrever.setText("Extrato");
        frame.add(escrever);
         JLabel escrever2 = new JLabel();
            escrever2.setBounds(20, 40, 200, 80);
            escrever2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            escrever2.setForeground(Color.white);
            escrever2.setText("Cliente: "+"\n" + nome);
            frame.add(escrever2);
             JLabel escrever3 = new JLabel();
                escrever3.setBounds(20, 80, 200, 80);
                escrever3.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                escrever3.setForeground(Color.white);
                escrever3.setText("Conta: " + "\n" + numero_conta);
                frame.add(escrever3);
                 JLabel escrever4 = new JLabel();
                    escrever4.setBounds(20, 120, 200, 80);
                    escrever4.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                    escrever4.setForeground(Color.white);
                    if(tipo_da_conta==1)
                    {
                        escrever4.setText("Conta Simples");
                    }else if(tipo_da_conta==4)
                    {
                        escrever4.setText("Conta Especial");
                    }
                    else
                    {
                    escrever4.setText("Conta Poupança");
                    }
                    frame.add(escrever4);
    JTextArea informacao = new JTextArea();
    informacao.setBackground(new Color(0x123456));
    informacao.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    informacao.setForeground(Color.white);
    informacao.setEditable(false);
    informacao.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    JScrollPane scroll = new JScrollPane(informacao);
    
    scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    scroll.setBounds(300, 80, 170, 370);
    frame.add(scroll);
    
    JButton buttonS = new JButton("sair");
    buttonS.setBounds(420, 430, 55, 20);
    buttonS.setFocusable(false);
    buttonS.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            frame.setVisible(false);
            menu_gerente();
        }
    });
    frame.add(buttonS);
    JButton button1 = new JButton("Confirmar");
    button1.setBounds(20, 200, 100, 20);
    button1.setFocusable(false);
    button1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            frame.setVisible(false);
            menu_gerente();
        }
    });
    frame.add(button1);
   
   int z=usu.tamExtrato(cliente,aux);
   double[] contas=new double[z];
   contas=usu.getExtrato(cliente,aux);
   for(int i=0;i<usu.tamExtrato(cliente,aux);i++) {
       
    informacao.append(String.valueOf(contas[i])+"\n"); 
   }
}}