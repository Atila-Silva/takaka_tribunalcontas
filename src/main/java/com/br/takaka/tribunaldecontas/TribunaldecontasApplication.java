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
		repository.save(new MunicipioModel(350100, "Altin�polis", "https://www.altinopolis.sp.gov.br/cidadao-consciente-seja-bem-vindo-a-pagina-de-acesso-a-informacao-da-prefeitura-de-altinopolis/"));
		repository.save(new MunicipioModel(350110, "Alto Alegre", "https://www.altoalegre.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350115, "Alum�nio", "https://aluminio.sp.gov.br/portal-da-transparencia-municipal/"));
		repository.save(new MunicipioModel(350120, "�lvares Florence", "http://web.alvaresflorence.sp.gov.br:5656/transparencia/"));
		repository.save(new MunicipioModel(350130, "�lvares Machado", "http://www.portaltransparencia.gov.br/localidades/3501301-alvares-machado"));
		repository.save(new MunicipioModel(350140, "�lvaro de Carvalho", "http://186.224.1.38:8079/transparencia/"));
		repository.save(new MunicipioModel(350150, "Alvinl�ndia", "http://transparencia.alvinlandia.sp.gov.br:5656/transparencia/"));
		repository.save(new MunicipioModel(350160, "Americana", "https://transparencia.americana.sp.gov.br/transparencia_index.php"));
		repository.save(new MunicipioModel(350170, "Am�rico Brasiliense", "http://sp.portaldatransparencia.com.br/prefeitura/americobrasiliense/?pagina=outro_ato_oficial"));
		repository.save(new MunicipioModel(350180, "Am�rico de Campos", "http://www.americodecampos.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350190, "Amparo", "http://www.portaltransparencia.gov.br/localidades/3501905-amparo"));
		repository.save(new MunicipioModel(350200, "Anal�ndia", "https://e-gov.betha.com.br/transparencia/01037-107/recursos.faces?mun=-3kZBAXwVlLTp6SPOpUqOcUCjolFktQv"));
		repository.save(new MunicipioModel(350210, "Andradina", "https://www.andradina.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350220, "Angatuba", "http://www.portaltransparencia.gov.br/localidades/3502200-angatuba?ano=2018"));
		repository.save(new MunicipioModel(350230, "Anhembi", "https://www.anhembi.sp.gov.br/portal/transparencia"));
		repository.save(new MunicipioModel(350240, "Anhumas", "http://www.portaltransparencia.gov.br/localidades/3502408-anhumas"));
		repository.save(new MunicipioModel(350250, "Aparecida", "https://www.aparecida.sp.gov.br"));
		repository.save(new MunicipioModel(350260, "Aparecida d'Oeste", "http://45.180.41.152:5656/Transparencia/"));
		repository.save(new MunicipioModel(350270, "Apia�", "http://www.portaltransparencia.gov.br/localidades/3502705-apiai"));
		repository.save(new MunicipioModel(350275, "Ara�ariguama", "http://portal.aracariguama.sp.gov.br/PORTAL_TRANSPARENCIA/Shared/wfDashBoard.aspx"));
		
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
		repositoryItem.save(new ItemModel("� divulgado o registro de compet�ncias dos �rg�os administrativos, secretarias e departamentos?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("� divulgada a estrutura organizacional?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("S�o divulgados os endere�os e telefones das respectivas unidades?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("� divulgado o hor�rio de atendimento ao p�blico?", repositoryCategoria.getById((long) 1)));
		repositoryItem.save(new ItemModel("S�o divulgados os repasses ou transfer�ncias de recursos financeiros?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgados os atos praticados pelas unidades gestoras no decorrer da execu��o da despesa, no momento de sua realiza��o, com a disponibiliza��o m�nima dos dados referentes ao n�mero do correspondente processo, ao bem fornecido ou ao servi�o prestado, � pessoa f�sica ou jur�dica benefici�ria do pagamento e, quando for o caso, ao procedimento licitat�rio realizado?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgadas as presta��es de contas  entregues anualmente ao Tribunal de Contas?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgados os Pareceres Pr�vios emitidos pelo Tribunal de Contas sobre as contas anuais?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgados os Relat�rios Resumidos da Execu��o Or�ament�ria (RREO)?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgados os Relat�rios de Gest�o Fiscal (RGF)?", repositoryCategoria.getById((long) 2)));
		repositoryItem.save(new ItemModel("S�o divulgados os planos (PPA), or�amentos (LOA) e leis de diretrizes or�ament�rias (LDO)?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("S�o divulgados o lan�amento e o recebimento da receita das unidades gestoras?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos contendo a identifica��o dos respectivos entes ou �rg�os da Administra��o P�blica e o exerc�cio financeiro correspondente?", repositoryCategoria.getById((long) 3)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos contendo o seu nome completo?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos contendo o seu n�mero de matr�cula?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos identificando o cargo/fun��o e a categoria, com indica��o da respectiva legisla��o regulamentadora?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos contendo data da admiss�o/ingresso e a identifica��o da esp�cie de contrata��o (concurso p�blico ou processo seletivo)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos identificando o v�nculo de emprego (emprego p�blico ou estatut�rio)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos identificando a carga hor�ria?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores efetivos identificando a lota��o (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("S�o divulgados os vencimentos, vantagens fixas ou vari�veis, subs�dios, proventos de aposentadoria, reformas e pens�es, adicionais, gratifica��es, horas extras, e vantagens pessoais de qualquer natureza pagos aos servidores ativos, bem como os encargos sociais e contribui��es recolhidos �s entidades previdenci�rias?", repositoryCategoria.getById((long) 4)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, � divulgado o nome completo do agente p�blico e o respectivo n�mero de matr�cula?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, � informada a justificativa para a realiza��o de cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, s�o divulgadas as datas de in�cio e t�rmino das viagens realizadas?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, � informado o destino de cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, � informado o meio de transporte utilizado em cada viagem, bem como seu respectivo custo?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, s�o divulgados os valores gastos com passagens rodovi�rias ou a�reas, ou com verbas relativas a ressarcimentos de combust�vel?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo, � informada a quantidade de di�rias pagas em rela��o a cada viagem?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("Sobre di�rias e ajudas de custo pagas, � informado o valor unit�rio das di�rias?", repositoryCategoria.getById((long) 5)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos contendo a identifica��o dos respectivos entes ou �rg�os da Administra��o P�blica?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos contendo o seu n�mero de matr�cula?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos identificando o cargo em que se deu sua aposentadoria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos contendo data de ingresso no quadro de inativos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores inativos contendo identifica��o do regime (geral ou pr�prio) de aposentadoria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgado detalhamento do quadro de pessoal, plano de carreira e remunera��o dos cargos e empregos p�blicos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo a identifica��o dos respectivos entes ou �rg�os da Administra��o P�blica?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo o seu n�mero de matr�cula?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo a data de nomea��o/admiss�o e o n�mero do respectivo ato?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo a data de exonera��o e o n�mero do respectivo ato?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo a identifica��o da categoria e a indica��o do n�mero da lei respectiva?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o indicando a exist�ncia de v�nculo efetivo, quando houver?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo em comiss�o contendo identifica��o da carga hor�ria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo comissionado contendo identifica��o da lota��o (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores ocupantes de cargo comissionado contendo detalhamento sobre as atribui��es (dire��o/chefia/assessoramento), bem como identifica��o da legisla��o regulamentadora?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�os p�blicos, ou destes recebidos em cess�o, contendo a identifica��o do �rg�o de origem e do �rg�o de destino?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�os p�blicos, ou destes recebidos em cess�o, identificando o nome completo de tais servidores?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�os p�blicos, ou destes recebidos em cess�o, identificando o n�mero de matr�cula de tais servidores?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando o cargo e a categoria, com indica��o da respectiva legisla��o regulamentadora?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando o v�nculo de emprego?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando a carga hor�ria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando o n�mero do ato de cess�o?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando se o �nus � para a origem ou para o destino?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando o prazo da cess�o?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de servidores cedidos para outros �rg�o p�blicos, ou destes recebidos em cess�o, identificando a lota��o (secretaria/departamento/setor)?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios contendo a identifica��o dos respectivos entes ou �rg�os da Administra��o P�blica?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios contendo o seu nome completo?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios contendo a data de sua admiss�o?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios contendo a identifica��o do curso vinculado ao est�gio?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios contendo a respectiva lota��o (secretaria/departamento/setor?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios identificando a respectiva fun��o?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de estagi�rios identificando a respectiva carga hor�ria?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de agentes p�blicos contratados temporariamente?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de agentes p�blicos vinculados a contrato de terceiriza��o?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, contendo a identifica��o dos respectivos n�meros?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, contendo a identifica��o dos �rg�os convenentes?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, contendo a identifica��o dos respectivos objetos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, identificando os respectivos valores, inclusive de eventuais contrapartidas?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, identificando os valores j� liberados?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e termos de coopera��o celebrados com outros entes p�blicos, contendo a publica��o de extratos de eventuais termos aditivos?", repositoryCategoria.getById((long) 6)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e contratos celebrados com particulares, contendo a identifica��o dos respectivos n�meros e do exerc�cio financeiro?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e contratos celebrados com particulares, contendo a identifica��o dos respectivos objetos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o da conv�nios e contratos celebrados com particulares, contendo a identifica��o da esp�cie dos contratos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de conv�nios e contratos celebrados com particulares, contendo a identifica��o da previs�o or�ament�ria e a descri��o espec�fica e detalhada do �rg�o, unidade e rubrica?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de conv�nios e contratos celebrados com particulares, com a indica��o dos respectivos valores?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de conv�nios e contratos celebrados com particulares, com a identifica��o dos contratados/signat�rios (pessoa f�sica ou jur�dica) e do respectivo n�mero de CPF ou CNPJ?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o de conv�nios e contratos celebrados com particulares, contendo a publica��o de extratos de eventuais termos aditivos?", repositoryCategoria.getById((long) 7)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo o n�mero dos respectivos processos e a identifica��o do exerc�cio financeiro?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o da modalidade adotada?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o do respectivo objeto?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o do respectivo crit�rio de julgamento?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o da sua vig�ncia?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o da previs�o or�ament�ria e a descri��o espec�fica e detalhada do �rg�o, unidade e rubrica?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), contendo a identifica��o do respectivo valor?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� divulgada rela��o dos procedimentos licitat�rios (inclusive dos casos de dispensa e inexigibilidade de licita��o), com a identifica��o dos contratados/signat�rios (pessoa f�sica ou jur�dica) e do respectivo n�mero de CPF ou CNPJ?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("� disponibilizada c�pia integral e digitalizada dos procedimentos licitat�rios?", repositoryCategoria.getById((long) 8)));
		repositoryItem.save(new ItemModel("S�o divulgados dados gerais para acompanhamento de programas, a��es, projetos e obras de seus respectivos �rg�os e entidades?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("� disponibilizada ferramenta de pesquisa avan�ada de conte�do?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("� disponibilizado mecanismo que permita a grava��o de relat�rios em diversos formatos eletr�nicos, tais como planilhas e textos?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("� disponibilizada alternativa de encaminhamento de pedido de acesso � informa��o por parte dos cidad�os?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("S�o adotadas medidas que objetivam garantir a acessibilidade de conte�do para pessoas com defici�ncia?", repositoryCategoria.getById((long) 9)));
		repositoryItem.save(new ItemModel("S�o disponibilizadas respostas �s perguntas mais frequentes da sociedade?", repositoryCategoria.getById((long) 9)));
	}
	//endere�o para chama o swagger - http://localhost:8080/fiap/swagger-ui/#/
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
