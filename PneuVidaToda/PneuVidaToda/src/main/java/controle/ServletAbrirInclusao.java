package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.SituacaoDAO;
import modelo.dominio.Situacao;
import modelo.dominio.Veiculo;



/**
 * Servlet implementation class ServletAbrirInclusao
 */
@WebServlet("/abrirInclusao")
public class ServletAbrirInclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirInclusao() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// criando um novo objeto da Classe Veiculo
			Veiculo veiculo = new Veiculo();
		
		//  enviando o novo veiculo para a pagina
			request.setAttribute("veiculo", veiculo);
			
			
			SituacaoDAO daoSituacao = new SituacaoDAO();
			
			// carregar a lista do banco
			List<Situacao> listaSituacao = daoSituacao.listar();
			
			// guardar a lista no request
			request.setAttribute("listaSituacao", listaSituacao);
			
		// enviando o processamento para a pagina
			RequestDispatcher encaminhar = request.getRequestDispatcher("veiculoEditar.jsp");
			encaminhar.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
