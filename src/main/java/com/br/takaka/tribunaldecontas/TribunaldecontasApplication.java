package com.br.takaka.tribunaldecontas;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import com.br.takaka.tribunaldecontas.model.CategoriaModel;
import com.br.takaka.tribunaldecontas.model.ItemModel;
import com.br.takaka.tribunaldecontas.model.MunicipioModel;
import com.br.takaka.tribunaldecontas.repository.CategoriaRepository;
import com.br.takaka.tribunaldecontas.repository.ItemRepository;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TribunaldecontasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TribunaldecontasApplication.class, args);
		

	}
	
	@Autowired
	MunicipioRepository repository;
	
	@Autowired
	CategoriaRepository repositoryCategoria;
	
	@Autowired
	ItemRepository repositoryItem;
	
	@Bean
	public void criaruser2() {
		repository.save(new MunicipioModel(350100, "Altinópolis", "https://www.altinopolis.sp.gov.br/cidadao-consciente-seja-bem-vindo-a-pagina-de-acesso-a-informacao-da-prefeitura-de-altinopolis/"));
		repository.save(new MunicipioModel(350110, "Alto Alegre", "https://www.altoalegre.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350115, "Alumínio", "https://aluminio.sp.gov.br/portal-da-transparencia-municipal/"));
		repository.save(new MunicipioModel(350120, "Álvares Florence", "http://web.alvaresflorence.sp.gov.br:5656/transparencia/"));
		repository.save(new MunicipioModel(350130, "Álvares Machado", "http://www.portaltransparencia.gov.br/localidades/3501301-alvares-machado"));
		repository.save(new MunicipioModel(350140, "Álvaro de Carvalho", "http://186.224.1.38:8079/transparencia/"));
		repository.save(new MunicipioModel(350150, "Alvinlândia", "http://transparencia.alvinlandia.sp.gov.br:5656/transparencia/"));
		repository.save(new MunicipioModel(350160, "Americana", "https://transparencia.americana.sp.gov.br/transparencia_index.php"));
		repository.save(new MunicipioModel(350170, "Américo Brasiliense", "http://sp.portaldatransparencia.com.br/prefeitura/americobrasiliense/?pagina=outro_ato_oficial"));
		repository.save(new MunicipioModel(350180, "Américo de Campos", "http://www.americodecampos.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350190, "Amparo", "http://www.portaltransparencia.gov.br/localidades/3501905-amparo"));
		repository.save(new MunicipioModel(350200, "Analândia", "https://e-gov.betha.com.br/transparencia/01037-107/recursos.faces?mun=-3kZBAXwVlLTp6SPOpUqOcUCjolFktQv"));
		repository.save(new MunicipioModel(350210, "Andradina", "https://www.andradina.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350220, "Angatuba", "http://www.portaltransparencia.gov.br/localidades/3502200-angatuba?ano=2018"));
		repository.save(new MunicipioModel(350230, "Anhembi", "https://www.anhembi.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350240, "Anhumas", "http://www.portaltransparencia.gov.br/localidades/3502408-anhumas"));
		repository.save(new MunicipioModel(350250, "Aparecida", "https://www.aparecida.sp.gov.br"));
		repository.save(new MunicipioModel(350260, "Aparecida d'Oeste", "http://45.180.41.152:5656/Transparencia/"));
		repository.save(new MunicipioModel(350270, "Apiaí", "http://www.portaltransparencia.gov.br/localidades/3502705-apiai"));
		repository.save(new MunicipioModel(350275, "Araçariguama", "http://portal.aracariguama.sp.gov.br/PORTAL_TRANSPARENCIA/Shared/wfDashBoard.aspx"));
		
	}
	
	@Bean
	public void criarcategoria2() {
		repositoryCategoria.save(new CategoriaModel("INSTITUCIONAIS"));
		repositoryCategoria.save(new CategoriaModel("CONTABEIS"));
		repositoryCategoria.save(new CategoriaModel("ORCAMENTARIAS"));
		repositoryCategoria.save(new CategoriaModel("AGENTES_PUBLICOS"));
		repositoryCategoria.save(new CategoriaModel("DIARIAS_CUSTO"));
		repositoryCategoria.save(new CategoriaModel("CONV_ENTES_PUBLICOS"));
		repositoryCategoria.save(new CategoriaModel("CONV_ENTES_PARTICULARES"));
		repositoryCategoria.save(new CategoriaModel("LICITATORIOS"));
		repositoryCategoria.save(new CategoriaModel("FERRAMENTAS_TRANSPARENCIA"));
	}
	
	@Bean
	public void criaritem2() {
		repositoryItem.save(new ItemModel("É divulgado o registro de competências dos órgãos administrativos, secretarias e departamentos?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("É divulgada a estrutura organizacional?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("São divulgados os endereços e telefones das respectivas unidades?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("É divulgado o horário de atendimento ao público?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("São divulgados os repasses ou transferências de recursos financeiros?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgados os atos praticados pelas unidades gestoras no decorrer da execução da despesa, no momento de sua realização, com a disponibilização mínima dos dados referentes ao número do correspondente processo, ao bem fornecido ou ao serviço prestado, à pessoa física ou jurídica beneficiária do pagamento e, quando for o caso, ao procedimento licitatório realizado?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgadas as prestações de contas  entregues anualmente ao Tribunal de Contas?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgados os Pareceres Prévios emitidos pelo Tribunal de Contas sobre as contas anuais?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgados os Relatórios Resumidos da Execução Orçamentária (RREO)?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgados os Relatórios de Gestão Fiscal (RGF)?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("São divulgados os planos (PPA), orçamentos (LOA) e leis de diretrizes orçamentárias (LDO)?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("São divulgados o lançamento e o recebimento da receita das unidades gestoras?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos contendo a identificação dos respectivos entes ou órgãos da Administração Pública e o exercício financeiro correspondente?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos contendo o seu nome completo?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos contendo o seu número de matrícula?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos identificando o cargo/função e a categoria, com indicação da respectiva legislação regulamentadora?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos contendo data da admissão/ingresso e a identificação da espécie de contratação (concurso público ou processo seletivo)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos identificando o vínculo de emprego (emprego público ou estatutário)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos identificando a carga horária?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores efetivos identificando a lotação (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("São divulgados os vencimentos, vantagens fixas ou variáveis, subsídios, proventos de aposentadoria, reformas e pensões, adicionais, gratificações, horas extras, e vantagens pessoais de qualquer natureza pagos aos servidores ativos, bem como os encargos sociais e contribuições recolhidos às entidades previdenciárias?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, é divulgado o nome completo do agente público e o respectivo número de matrícula?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, é informada a justificativa para a realização de cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, são divulgadas as datas de início e término das viagens realizadas?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, é informado o destino de cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, é informado o meio de transporte utilizado em cada viagem, bem como seu respectivo custo?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, são divulgados os valores gastos com passagens rodoviárias ou aéreas, ou com verbas relativas a ressarcimentos de combustível?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo, é informada a quantidade de diárias pagas em relação a cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre diárias e ajudas de custo pagas, é informado o valor unitário das diárias?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos contendo a identificação dos respectivos entes ou órgãos da Administração Pública?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos contendo o seu número de matrícula?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos identificando o cargo em que se deu sua aposentadoria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos contendo data de ingresso no quadro de inativos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores inativos contendo identificação do regime (geral ou próprio) de aposentadoria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgado detalhamento do quadro de pessoal, plano de carreira e remuneração dos cargos e empregos públicos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo a identificação dos respectivos entes ou órgãos da Administração Pública?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo o seu número de matrícula?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo a data de nomeação/admissão e o número do respectivo ato?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo a data de exoneração e o número do respectivo ato?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo a identificação da categoria e a indicação do número da lei respectiva?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão indicando a existência de vínculo efetivo, quando houver?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo em comissão contendo identificação da carga horária?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo comissionado contendo identificação da lotação (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores ocupantes de cargo comissionado contendo detalhamento sobre as atribuições (direção/chefia/assessoramento), bem como identificação da legislação regulamentadora?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgãos públicos, ou destes recebidos em cessão, contendo a identificação do órgão de origem e do órgão de destino?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgãos públicos, ou destes recebidos em cessão, identificando o nome completo de tais servidores?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgãos públicos, ou destes recebidos em cessão, identificando o número de matrícula de tais servidores?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando o cargo e a categoria, com indicação da respectiva legislação regulamentadora?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando o vínculo de emprego?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando a carga horária?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando o número do ato de cessão?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando se o ônus é para a origem ou para o destino?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando o prazo da cessão?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de servidores cedidos para outros órgão públicos, ou destes recebidos em cessão, identificando a lotação (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários contendo a identificação dos respectivos entes ou órgãos da Administração Pública?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários contendo a data de sua admissão?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários contendo a identificação do curso vinculado ao estágio?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários contendo a respectiva lotação (secretaria/departamento/setor?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários identificando a respectiva função?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de estagiários identificando a respectiva carga horária?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de agentes públicos contratados temporariamente?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação de agentes públicos vinculados a contrato de terceirização?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, contendo a identificação dos respectivos números?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, contendo a identificação dos órgãos convenentes?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, contendo a identificação dos respectivos objetos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, identificando os respectivos valores, inclusive de eventuais contrapartidas?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, identificando os valores já liberados?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e termos de cooperação celebrados com outros entes públicos, contendo a publicação de extratos de eventuais termos aditivos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e contratos celebrados com particulares, contendo a identificação dos respectivos números e do exercício financeiro?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e contratos celebrados com particulares, contendo a identificação dos respectivos objetos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação da convênios e contratos celebrados com particulares, contendo a identificação da espécie dos contratos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação de convênios e contratos celebrados com particulares, contendo a identificação da previsão orçamentária e a descrição específica e detalhada do órgão, unidade e rubrica?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação de convênios e contratos celebrados com particulares, com a indicação dos respectivos valores?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação de convênios e contratos celebrados com particulares, com a identificação dos contratados/signatários (pessoa física ou jurídica) e do respectivo número de CPF ou CNPJ?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação de convênios e contratos celebrados com particulares, contendo a publicação de extratos de eventuais termos aditivos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo o número dos respectivos processos e a identificação do exercício financeiro?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação da modalidade adotada?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação do respectivo objeto?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação do respectivo critério de julgamento?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação da sua vigência?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação da previsão orçamentária e a descrição específica e detalhada do órgão, unidade e rubrica?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), contendo a identificação do respectivo valor?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É divulgada relação dos procedimentos licitatórios (inclusive dos casos de dispensa e inexigibilidade de licitação), com a identificação dos contratados/signatários (pessoa física ou jurídica) e do respectivo número de CPF ou CNPJ?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("É disponibilizada cópia integral e digitalizada dos procedimentos licitatórios?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("São divulgados dados gerais para acompanhamento de programas, ações, projetos e obras de seus respectivos órgãos e entidades?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("É disponibilizada ferramenta de pesquisa avançada de conteúdo?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("É disponibilizado mecanismo que permita a gravação de relatórios em diversos formatos eletrônicos, tais como planilhas e textos?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("É disponibilizada alternativa de encaminhamento de pedido de acesso à informação por parte dos cidadãos?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("São adotadas medidas que objetivam garantir a acessibilidade de conteúdo para pessoas com deficiência?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("São disponibilizadas respostas às perguntas mais frequentes da sociedade?", repositoryCategoria.getById((long) 9)));
	}
	//endereço para chama o swagger - http://localhost:8080/fiap/swagger-ui/#/
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.br.takaka.tribunaldecontas.controller"))
	            .paths(PathSelectors.any())
	            .build();
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
			}
		};
	}

}
