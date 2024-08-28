package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//abri conexao com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//criar variavel para buscar o registro no banco
			String id;
			
			//ID irá receber o valor digitado pelo usuário
			id = JOptionPane.showInputDialog("Digite o ID do manuscrito: ");
			
			//criar o sql para extrair os dados 
			String sql;
			
			sql = "select * from manuscrito where id = "+ id +";";
			
			//linha abaixo para fazer o teste no banco de dados 
			//System.out.println(sql);
			
			//preparar para receber os dados 
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//executar o comando 
			ResultSet resultado = cmd.executeQuery();
			
			//criar uma variavel para receber os dois
			String manuscritos;
			manuscritos = "<< Manuscritos encontrados >>";
			while(resultado.next());{
				manuscritos += "ID: " + resultado.getInt("id")
				+ "- Título: " + resultado.getString("titulo")
				+ "- Autor: " + resultado.getString("autor")
				+ "\n";
			}
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
			
		} catch (Exception e) {
			
		}
	}

}
