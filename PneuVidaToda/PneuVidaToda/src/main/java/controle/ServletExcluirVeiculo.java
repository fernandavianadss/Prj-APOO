package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.VeiculoDAO;
import modelo.dominio.Veiculo;


/**
 * Servlet implementation class ServletAlunoExcluir
 */
@WebServlet("/excluir")
public class ServletExcluirVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirVeiculo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSistema = request.getParameter("id");
		Integer id = Integer.parseInt(idSistema);

		// criar instância do DAO para persistência
		VeiculoDAO dao = new VeiculoDAO();

		// carregar o veiculo escolhido do banco
		Veiculo veiculo = dao.obter(id);

		// excluir o veiculo do banco de dados
		dao.excluir(veiculo);

		// fazer redirect para listar os veiculos, a fim de evitar
		// varios envios repetidos
		response.sendRedirect("listarVeiculos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
