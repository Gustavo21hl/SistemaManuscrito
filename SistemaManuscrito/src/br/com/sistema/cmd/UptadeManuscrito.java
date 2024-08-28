package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class UptadeManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			//vamos salvar nas variaveis os dados que serão inseridos no banco 
			Manuscrito manuscrito = new Manuscrito();

			//Envia o dado para a classe Manuscrito()
			manuscrito.setTitulo(JOptionPane.showInputDialog("Entre com o Titulo do Manuscrito"));
			
			manuscrito.setAutor(JOptionPane.showInputDialog("Entre com o nome do Autor do Manuscrito"));
			
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o ID a ser alterado"));
			
			String sql = "uptade manuscrito set titulo = ?, autor = ?, where id = ?;";
			
			//System.out.print(sql);
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, manuscrito.getTitulo());
			cmd.setString(2, manuscrito.getAutor());
			cmd.setString(3, manuscrito.getId());
			
			cmd.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Dado atualizado com sucesso!");
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
