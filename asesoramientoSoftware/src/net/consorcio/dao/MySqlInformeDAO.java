package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Informe;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlInformeDAO implements InformeDAO {

	@Override
	public Informe find(int cod) {
		Informe bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_informe where cod_inf=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Informe();
				bean.setCodigo(rs.getInt(1));
				bean.setIntroduccion(rs.getString(2));
				bean.setAntecedentes(rs.getString(3));
				bean.setAnalisis(rs.getString(4));
				bean.setConclusiones(rs.getString(5));
				bean.setRecomendaciones(rs.getString(6));
				bean.setEstado(rs.getString(7));
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
	public List<Informe> listAll() {
		List<Informe> lista=new ArrayList<Informe>();
		Informe bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_informe";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Informe();
				bean.setCodigo(rs.getInt(1));
				bean.setIntroduccion(rs.getString(2));
				bean.setAntecedentes(rs.getString(3));
				bean.setAnalisis(rs.getString(4));
				bean.setConclusiones(rs.getString(5));
				bean.setRecomendaciones(rs.getString(6));
				bean.setEstado(rs.getString(7));
				
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
	public int save(Informe bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_informe values(null,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getIntroduccion());
			pstm.setString(2, bean.getAntecedentes());
			pstm.setString(3, bean.getAnalisis());
			pstm.setString(4, bean.getConclusiones());
			pstm.setString(5, bean.getRecomendaciones());
			pstm.setString(6, bean.getEstado());
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
	public int update(Informe bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_informe set introduccion_inf=?,antecedentes_inf=?,analisis_inf=?,conclusiones_inf=?,recomendaciones_inf=?,estado_inf=? where cod_inf=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getIntroduccion());
			pstm.setString(2, bean.getAntecedentes());
			pstm.setString(3, bean.getAnalisis());
			pstm.setString(4, bean.getConclusiones());
			pstm.setString(5, bean.getRecomendaciones());
			pstm.setString(6, bean.getEstado());
			pstm.setInt(7, bean.getCodigo());
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
	public int delete(int cod) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="delete from tb_informe where cod_inf=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
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

}
