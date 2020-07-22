package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.SolicitudCertificado;
import net.consorcio.interfaces.SolicitudDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlSolicitudDAO implements SolicitudDAO {

	@Override
	public Requerimiento find(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudCertificado> listAll() {
		
		List<SolicitudCertificado> lista=new ArrayList<SolicitudCertificado>();
		SolicitudCertificado bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select s.cod_sol_cert, s.obj_sol_cert, s.monto_sol_cert, s.area_sol_cert, s.fec_sol_cert, e.nom_est from tb_sol_certificado s inner join tb_estado e on s.cod_sol_cert=e.cod_est";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new SolicitudCertificado();
				bean.setCodigo(rs.getInt(1));
				bean.setObjetivo(rs.getString(2));
				bean.setMonto(rs.getDouble(3));
				bean.setArea(rs.getString(4));
				bean.setFecha(rs.getTimestamp(5));
				bean.setNombreEstado(rs.getString(6));
				
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
	public int save(SolicitudCertificado bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_sol_certificado values(null,?,?,?,null,1,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getObjetivo());
			pstm.setDouble(2, bean.getMonto());
			pstm.setString(3, bean.getArea());
			pstm.setInt(4, bean.getCodigoUsuario());
			pstm.setInt(5, bean.getCodigoCotizacion());
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
	public int update(SolicitudCertificado bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int cod) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="delete from tb_sol_certificado where cod_sol_cert=?";
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
