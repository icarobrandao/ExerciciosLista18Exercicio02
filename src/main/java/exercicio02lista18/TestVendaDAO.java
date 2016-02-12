package exercicio02lista18;

import java.sql.Date;
import java.util.List;

public class TestVendaDAO {

	public static void main(String[] args) {
		//cadastrarTest();
		BucasTodasVendasTest();
		
	}

	public static void cadastrarTest(){
		Venda venda = new Venda();
		venda.setValor(800.00);
		venda.setData(new Date(0));
		
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.cadastrar(venda);
	}
	
	public static void BucasTodasVendasTest(){
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> lista = vendaDAO.buscarTodasVendas();
		for(Venda v : lista){
			System.out.println(v);
		}
	}
	
}
