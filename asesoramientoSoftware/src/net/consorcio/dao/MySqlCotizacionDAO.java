package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;
import net.consorcio.entidad.Requerimiento;
import net.consorcio.entidad.Cotizacion;
import net.consorcio.interfaces.CotizacionDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlCotizacionDAO implements CotizacionDAO {

	@Override
	public int registrarCotizacion(Cotizacion bean, List<Detalle> lista) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm1=null,pstm2=null;
		try {
			cn=MySqlBDConexion.getConexion();
			//bloquear el commit del metodo executeUpdate
			cn.setAutoCommit(false);
			
			String sql1="insert into tb_cotizacion values(?,?,?,?,1,null,?)";
			pstm1=cn.prepareStatement(sql1);
			pstm1.setInt(1, bean.getCodigo());
			pstm1.setLong(2, bean.getRucPro());
			pstm1.setInt(3, bean.getCodUsu());
			pstm1.setDouble(4, bean.getMonto());
			pstm1.setInt(5, bean.getCodigoInforme());
			estado=pstm1.executeUpdate();
			
			//detalle
			
			String sql2="insert into tb_detalle_coti values(?,?,?,null)";
			//bucle para realizar recorrido sobre lista
			for(Detalle det:lista) {
				//
				pstm2=cn.prepareStatement(sql2);
				pstm2.setInt(1, bean.getCodigo());
				pstm2.setInt(2,det.getCodigo());
				pstm2.setInt(3,det.getCantidad());
				estado=pstm2.executeUpdate();
				
			}
			
			//confirmar los commits 
			cn.commit();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm2!=null) pstm2.close();
				if(pstm1!=null) pstm1.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<Cotizacion> listAll() {
		List<Cotizacion> lista=new ArrayList<Cotizacion>();
		Cotizacion bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select c.cod_coti, c.ruc_prov, c.monto, c.fec_coti, e.nom_est from tb_cotizacion c inner join tb_estado e on c.cod_est=e.cod_est";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Cotizacion();
				bean.setCodigo(rs.getInt(1));
				bean.setRucPro(rs.getLong(2));
				bean.setMonto(rs.getDouble(3));		
				bean.setFecha(rs.getDate(4));
				bean.setNombreEstado(rs.getString(5));
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
	public Cotizacion find(int cod) {
		Cotizacion bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_cotizacion where cod_coti=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Cotizacion();
				bean.setCodigo(rs.getInt(1));
				bean.setRucPro(rs.getLong(2));
				bean.setCodUsu(rs.getInt(3));
				bean.setMonto(rs.getDouble(4));;
				bean.setCod_est(rs.getInt(5));
				bean.setFecha(rs.getDate(6));
				bean.setCodigoInforme(rs.getInt(7));
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
	public int update(Cotizacion bean) {
		
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_cotizacion set monto=?,cod_est=? where cod_cot=?";
			pstm=cn.prepareStatement(sql);
			pstm.setDouble(1, bean.getMonto());
			pstm.setDouble(2, bean.getCod_est());
			pstm.setLong(3, bean.getCodigo());
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
		// TODO Auto-generated method stub
		return 0;
	}

}
