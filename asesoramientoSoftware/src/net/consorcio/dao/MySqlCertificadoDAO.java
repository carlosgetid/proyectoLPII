package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Certificado;
import net.consorcio.interfaces.CertificadoDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlCertificadoDAO implements CertificadoDAO {

	@Override
	public Certificado find(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certificado> listAll() {
		List<Certificado> lista=new ArrayList<Certificado>();
		Certificado bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_certificado";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Certificado();
				bean.setCodigo(rs.getInt(1));
				bean.setFechaHora(rs.getDate(2));
				bean.setUrl(rs.getString(3));
				bean.setNombreArchivo(rs.getString(4));
				
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

	@Override
	public int save(Certificado bean) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_certificado values (null, ?, ?, ?, ?)";
			pstm=cn.prepareStatement(sql);
			pstm.setDate(1, bean.getFechaHora());
			pstm.setString(2, bean.getUrl());
			pstm.setString(3, bean.getNombreArchivo());
			pstm.setBlob(4, bean.getDocumento());
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;


	}

	@Override
	public int update(Certificado bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

}
