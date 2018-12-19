package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.GoodsEntity;

public class GoodsDao  extends BaseDao{

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rst=null;
	
	
	public boolean add(GoodsEntity goods){
		
		
		
		return false;
	}
	
	public boolean del(int id){
		try {
			con=super.getcon();
			String sql="delete from goods where number=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<GoodsEntity> quely(){
		try {
			con=super.getcon();
			String sql="select * from goods";
			ps=con.prepareStatement(sql);
			rst=ps.executeQuery();
			List<GoodsEntity> list=new ArrayList<GoodsEntity>();
			while(rst.next()){
			int number=rst.getInt("number");
			String name=rst.getString("name");
			String dates=rst.getString("datess");
			String address=rst.getString("address");
			String types=rst.getString("types");
			String prices=rst.getString("prices");
			list.add(new GoodsEntity(number, name, dates, address, types, prices));
			}return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	}

