package net.asesoramiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.asesoramiento.entidad.Requerimiento;
import net.asesoramiento.interfaces.RequerimientoDAO;
import net.asesoramiento.utils.MySqlBDConexion;

public class MySqlRequerimientoDAO implements RequerimientoDAO {

	@Override
	public int insertRequerimiento(Requerimiento bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_requerimiento values(null,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getDescripcion());
			pstm.setString(2, bean.getOrigen());
			pstm.setString(3, bean.getArea());
			pstm.setString(4, bean.getCriticidad());
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
	public int updateRequerimiento(Requerimiento bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRequerimiento(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Requerimiento findRequerimiento(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Requerimiento> listRequerimiento() {
		List<Requerimiento> lista=new ArrayList<Requerimiento>();
		Requerimiento bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_requerimiento";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Requerimiento();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setOrigen(rs.getString(3));
				bean.setArea(rs.getString(4));
				bean.setCriticidad(rs.getString(5));
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
	public List<Requerimiento> listRequerimiento(String ori) {
		// TODO Auto-generated method stub
		return null;
	}

}
