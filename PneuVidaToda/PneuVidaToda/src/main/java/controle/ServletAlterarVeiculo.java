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
import modelo.dao.VeiculoDAO;
import modelo.dominio.Situacao;
import modelo.dominio.Veiculo;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/editar")
public class ServletAlterarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarVeiculo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSistema = request.getParameter("id");
		Integer id = Integer.parseInt(idSistema);
		
		//criar instancia do DAO para persistencia
		VeiculoDAO dao = new VeiculoDAO();
		
		//carregar o veiculo escolhido do banco
		Veiculo veiculo = dao.obter(id);		
		
		//guardar o veiculo no request para ser lido pela página
		request.setAttribute("veiculo", veiculo);
		
		SituacaoDAO daoSituacao = new SituacaoDAO();
		
		//carregar a lista do banco
		List<Situacao> listaSituacao = daoSituacao.listar();
		
		request.setAttribute("listaSituacao", listaSituacao);
		
		//criar um objeto para despachar a requisiçao
		RequestDispatcher encaminhar = request.getRequestDispatcher("veiculoEditar.jsp");
		
		//encaminhar para o servlet ou pagina selecionada
		encaminhar.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
