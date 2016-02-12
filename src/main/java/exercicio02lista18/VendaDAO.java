package exercicio02lista18;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
	Connection con = ConnectionFactory.getConnection();
	
	public void cadastrar(Venda venda){
		String sql = "insert into venda (valor, data) values (?,?)";
		
		try (PreparedStatement stm = con.prepareStatement(sql)){
			
			stm.setDouble(1,venda.getValor());
			stm.setDate(2,(Date) venda.getData());
			
			stm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public  List<Venda> buscarTodasVendas() {

		String sql = "select * from venda";
		List<Venda> lista = new ArrayList<Venda>();
		try (PreparedStatement stm = con.prepareStatement(sql)) {

			ResultSet resultSet = stm.executeQuery();

			while (resultSet.next()) {

				Venda venda = new Venda();
				venda.setId(resultSet.getInt("id"));
				venda.setValor(resultSet.getDouble("valor"));
				venda.setData(resultSet.getDate("data"));

				lista.add(venda);
			}

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return lista;

	}

	@SuppressWarnings("unused")
	private  List<Venda> buscarVendas(Date data){
		
		String sql = "Select * from venda where data=?";
		try (PreparedStatement stm = con.prepareStatement(sql)){
			
			stm.setDate(1,(java.sql.Date) data);
			
			ResultSet resultado = stm.executeQuery();
			
			List<Venda> lista = new ArrayList<Venda>();
			
			while(resultado.next()){
			
				Venda venda = new Venda();
				venda.setId(resultado.getInt("id"));
				venda.setValor(resultado.getDouble("valor"));
				venda.setData(resultado.getDate("data"));
				
				lista.add(venda);
				
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}

	private  List<Venda> buscarVendasPeriodo(Date dataInicial, Date dataFinal) {
	
		String sql = "Select * from venda where data=?";
		try (PreparedStatement stm = con.prepareStatement(sql)){
			
			stm.setDate(1,(java.sql.Date) data);
			
			ResultSet resultado = stm.executeQuery();
			
			List<Venda> lista = new ArrayList<Venda>();
			
			while(resultado.next()){
			
				Venda venda = new Venda();
				venda.setId(resultado.getInt("id"));
				venda.setValor(resultado.getDouble("valor"));
				venda.setData(resultado.getDate("data"));
				
				lista.add(venda);
				
			}
			
			return lista;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
}
