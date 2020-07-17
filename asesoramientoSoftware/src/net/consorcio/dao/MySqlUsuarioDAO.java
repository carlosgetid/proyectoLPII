package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Menu;
import net.consorcio.entidad.Usuario;
import net.consorcio.interfaces.UsuarioDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario iniciarSesion(String login, String clave) {
		Usuario bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select cod_usu,ape_usu,nom_usu from tb_usuario where log_usu=? and pas_usu=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			rs=pstm.executeQuery();
//			if porque devolvera una sola fila
			if(rs.next()) {
				bean=new Usuario();
//				el orden del select influye en este orden
				bean.setCodigo(rs.getInt(1));
				bean.setApellidos(rs.getString(2));
				bean.setNombres(rs.getString(3));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public List<Menu> traerMenuPorUsuario(int codUsu) {
		List<Menu> lista=new ArrayList<Menu>();
		Menu bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select a.cod_men,m.des_men,m.url_men from tb_acceso a "+
			"join tb_menu m on a.cod_men=m.cod_men where a.cod_usu=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codUsu);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Menu();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setUrl(rs.getString(3));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
