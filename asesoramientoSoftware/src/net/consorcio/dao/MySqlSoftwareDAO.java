package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Software;
import net.consorcio.interfaces.SoftwareDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlSoftwareDAO implements SoftwareDAO {

	@Override
	public Software find(int cod) {
		Software bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select *from tb_software where cod_soft=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Software();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPrecio(rs.getDouble(3));

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

	public List<Software> listSoftwareXNombre(String nom) {
		 List<Software> lista=new ArrayList<Software>();
	        Software bean=null;
	        Connection cn=null;
	        PreparedStatement pstm=null;
	        ResultSet rs=null;
	        try {
	            cn=MySqlBDConexion.getConexion();
	            String sql="select *from tb_software where nom_soft like ?";
	            pstm=cn.prepareStatement(sql);
	            pstm.setString(1, nom+"%");
	            rs=pstm.executeQuery();
	            while(rs.next()) {
	                bean=new Software();
	                bean.setCodigo(rs.getInt(1));
	                bean.setNombre(rs.getString(2));
	                bean.setPrecio(rs.getDouble(3));


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
	public int save(Software bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="insert into tb_software values(null,?,?,curdate())";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setDouble(2, bean.getPrecio());
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
	public int update(Software bean) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="update tb_software set nom_soft=?,ver_soft=? where cod_soft=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setDouble(2, bean.getPrecio());
			pstm.setInt(3, bean.getCodigo());
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
			String sql="delete from tb_software where cod_soft=?";
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
