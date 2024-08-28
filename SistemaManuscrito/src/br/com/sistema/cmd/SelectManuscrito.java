package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = "select * from manuscrito";
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet resultado = cmd.executeQuery();
			
			String manuscrito;
			manuscrito = "<< Manuscrito encontrados! >>\n";
			while(resultado.next()) {
				manuscrito += "ID: " + resultado.getInt("id") + "- Titulo: " + resultado.getString("titulo") + "- Autor: " + resultado.getString("autor") + "\n";
			
			}
			JOptionPane.showMessageDialog(null, manuscrito);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
