package controle;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ServletSalvarveiculo
 */
@WebServlet("/salvarVeiculo")
public class ServletSalvarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarVeiculo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendError(403, "Acesso negado. Use o formul�rio para enviar os dados");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <String> falhas = new ArrayList<String>();
		
		// pegando os parâmetros do request
		String idSistema = request.getParameter("id");
		String placa = request.getParameter("placa");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		String situacaoSistema = request.getParameter("situacao");
		 
		
		//converter os tipos n�mericos
		
		Integer id;
		try {
			id = Integer.parseInt(idSistema);
		} catch (NumberFormatException e) {
			id = null;
		}
		
		Integer idSituacao;
		Situacao situacao;
		try {
			idSituacao = Integer.parseInt(situacaoSistema);
			
			SituacaoDAO situacaoDao = new SituacaoDAO();
			
			// carregar a situacao do veiculo escolhida do banco
			situacao = situacaoDao.obter(idSituacao);

		} catch (NumberFormatException e) {
			idSituacao = null;
			situacao = null;
		}
		
		
		// Verificando possiveis falhas no formulario
		
		if (!placa.matches("[0-9]*") && placa.matches("[!@#$%¨&*()-_+§=/°?;:.>,<\\|[{]}ºª¹²³£¢¬]*") && placa.trim().length() == 0)
			falhas.add("Os dados digitados no campo placa estao invalidos.");
		
		
		if (marca.matches("[!@#$%¨&*()-_+§=/°?;:.>,<\\|[{]}ºª¹²³£¢¬]*") && marca.trim().length() == 0)
			falhas.add("Digite um modelo valido.");
		
		if (modelo.matches("[!@#$%¨&*()-_+§=/°?;:.>,<\\|[{]}ºª¹²³£¢¬]*") && modelo.trim().length() == 0)
			falhas.add("Digite apenas o nome do modelo.");
		
		if (situacao == null)
			falhas.add("Selecine alguma op��o.");
	
        
		// Criar instancia do DAO para persitencia 
		
		VeiculoDAO dao = new VeiculoDAO();
		
		// Passar os dados para o objeto do Modelo
		Veiculo veiculo = null;
		
		if (id == null)
			veiculo = new Veiculo(); // cria um registro novo
		else
			veiculo = dao.obter(id); // ler o veiculo existente
		
		//preencher campos do veiculo
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		
		//relacionar a situacao com o veiculo selecionado
		veiculo.setSituacao(situacao);
		
		
		// testar se os dados enviados estao corretos
		if (falhas.size() == 0)
		{
			
			//salvar o objeto no banco de dados
			dao.salvar(veiculo);

			// criar um objeto para despachar a requisi��o
			response.sendRedirect("listarVeiculos");
		}
		else
		{
			// guardando o veiculo no request para ser lido pela pagina
			request.setAttribute("veiculo", veiculo);
			request.setAttribute("falhas", falhas);
			
			// criando novo objeto de situa��o
			SituacaoDAO daoSituacao = new SituacaoDAO();
			
			// carregar lista do banco
			List <Situacao> listaSituacao = daoSituacao.listar();
			
			//guardar lista no request
			request.setAttribute("listaSituacao", listaSituacao);
			
			// criando um objeto para despachar a requisi��o
			RequestDispatcher encaminhar = request.getRequestDispatcher("veiculoEditar.jsp");
			
			// encaminhando para o servlet ou pagina selecionada
			encaminhar.forward(request, response);
		}
	}

}
