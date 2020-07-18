package net.consorcio.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.InformeInstalacion;
import net.consorcio.interfaces.InformeInstalacionDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlInformeInstalacionDAO implements InformeInstalacionDAO {

	@Override
	public InformeInstalacion find(int cod) {
		InformeInstalacion bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_informe_instalacion where cod_info_insta=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new InformeInstalacion();
				bean.setCodigo(rs.getInt(1));
				bean.setLugar(rs.getString(2));
				bean.setNombreArea(rs.getString(3));
				bean.setFechaInstalacion(rs.getDate(4));
				bean.setHoraInstalacion(rs.getTime(5));
				bean.setEstado(rs.getInt(6));
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
	public List<InformeInstalacion> listAll() {
		List<InformeInstalacion> lista=new ArrayList<InformeInstalacion>();
		InformeInstalacion bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_informe_instalacion";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new InformeInstalacion();
				bean.setCodigo(rs.getInt(1));
				bean.setLugar(rs.getString(2));
				bean.setNombreArea(rs.getString(3));
				bean.setFechaInstalacion(rs.getDate(4));
				bean.setHoraInstalacion(rs.getTime(5));
				bean.setEstado(rs.getInt(6));
				bean.setDocumento((InputStream) rs.getBlob(7));
				
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
	public int save(InformeInstalacion bean) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_informe_instalacion values(null,?,?,?,?,null,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getLugar());
			pstm.setString(2, bean.getNombreArea());
			pstm.setDate(3, bean.getFechaInstalacion());
			pstm.setTime(4, bean.getHoraInstalacion());
			pstm.setInt(5, bean.getEstado());
			pstm.setBlob(6, bean.getDocumento());
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
	public int update(InformeInstalacion bean) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_informe_instalacion set lug_insta=?,area_lab=?,fec_insta=?,hora_insta=?,est_info_insta=?,file_info_insta=? where cod_info_insta=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getLugar());
			pstm.setString(2, bean.getNombreArea());
			pstm.setDate(3, bean.getFechaInstalacion());
			pstm.setTime(4, bean.getHoraInstalacion());
			pstm.setInt(5, bean.getEstado());
			pstm.setBlob(5, bean.getDocumento());
			pstm.setInt(6, bean.getCodigo());
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
			String sql="delete from tb_informe_instalacion where cod_info_insta=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1,cod);
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
