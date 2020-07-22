package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.InformeTecnico;
import net.consorcio.interfaces.InformeDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlInformeDAO implements InformeDAO {

	@Override
	public InformeTecnico find(int cod) {
		InformeTecnico bean=null;
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
				bean=new InformeTecnico();
				bean.setCodigo(rs.getInt(1));
				bean.setIntroduccion(rs.getString(2));
				bean.setAntecedentes(rs.getString(3));
				bean.setAnalisis(rs.getString(4));
				bean.setConclusiones(rs.getString(5));
				bean.setRecomendaciones(rs.getString(6));
				bean.setCodigoEstado(rs.getInt(7));
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
	public List<InformeTecnico> listAll() {
		List<InformeTecnico> lista=new ArrayList<InformeTecnico>();
		InformeTecnico bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select t.cod_inf, t.introduccion_inf, t.fec_info_tec, e.nom_est from tb_informe t inner join tb_estado e on t.cod_est=e.cod_est";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new InformeTecnico();
				bean.setCodigo(rs.getInt(1));
				bean.setIntroduccion(rs.getString(2));
				bean.setFecha(rs.getTimestamp(3));
				bean.setNombreEstado(rs.getString(4));
				
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
	public int save(InformeTecnico bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_informe values(null,?,?,?,?,?,1,null,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getIntroduccion());
			pstm.setString(2, bean.getAntecedentes());
			pstm.setString(3, bean.getAnalisis());
			pstm.setString(4, bean.getConclusiones());
			pstm.setString(5, bean.getRecomendaciones());
			pstm.setInt(6, bean.getCodigoUsuario());
			pstm.setLong(7, bean.getCodigoRequerimiento());
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
	public int update(InformeTecnico bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_informe set introduccion_inf=?,antecedentes_inf=?,analisis_inf=?,conclusiones_inf=?,recomendaciones_inf=?,cod_est=? where cod_inf=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getIntroduccion());
			pstm.setString(2, bean.getAntecedentes());
			pstm.setString(3, bean.getAnalisis());
			pstm.setString(4, bean.getConclusiones());
			pstm.setString(5, bean.getRecomendaciones());
			pstm.setInt(6, bean.getCodigoEstado());
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
