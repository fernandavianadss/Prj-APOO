package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.VeiculoDAO;
import modelo.dominio.Veiculo;



/**
 * Servlet implementation class ServletAlunoListar
 */
@WebServlet("/listarVeiculos")
public class ServletListarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarVeiculo() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//criar instância do DAO para persistencia
		VeiculoDAO dao = new VeiculoDAO();
		
		// carregar a lista de alunos do banco de dados...
		List<Veiculo> lista = dao.listar();
		
		// enviando a lista de veiculos para a pagina...
		request.setAttribute("lista", lista);
		
		// enviando o processamento para a pagina
		RequestDispatcher encaminhar = request.getRequestDispatcher("veiculoListar.jsp");
		encaminhar.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
