package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import net.consorcio.entidad.Cotizacion;
import net.consorcio.entidad.Detalle;
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
			
			String sql1="insert into tb_cotizacion values(?,?,?,curdate(),?,null)";
			pstm1=cn.prepareStatement(sql1);
			pstm1.setInt(1, bean.getCodigo());
			pstm1.setInt(2, bean.getRucPro());
			pstm1.setInt(3, bean.getCodUsu());
			pstm1.setDouble(4, bean.getMonto());
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

}
