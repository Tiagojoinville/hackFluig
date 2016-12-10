$( document ).ready(function() { 
    console.log( "ready!" );
    
    var engine = new Bloodhound({
    	  local: [{value: 'apache-log4j'}, {value: 'apache-slide'}, {value: 'apache-xerces'}, {value: 'ar'}, {value: 'args4j'}, {value: 'asm'}, {value: 'aspectj'}, {value: 'aspectwerkz'}, {value: 'atlassian-bandana'}, {value: 'atlassian-logging'}, {value: 'avalon-framework'}, {value: 'axion'}, {value: 'axis'}, {value: 'axis2'}, {value: 'backport-util-concurrent'}, {value: 'batik'}, {value: 'bcel'}, {value: 'be'}, {value: 'birt-runtime'}, {value: 'biz'}, {value: 'bouncycastle'}, {value: 'br'}, {value: 'bsf'}, {value: 'bsh'}, {value: 'byyou'}, {value: 'c3p0'}, {value: 'ca'}, {value: 'carol'}, {value: 'cglib'}, {value: 'ch'}, {value: 'checkstyle'}, {value: 'classworlds'}, {value: 'co'}, {value: 'cobertura'}, {value: 'colt'}, {value: 'com'}, {value: 'commons-attributes'}, {value: 'commons-beanutils'}, {value: 'commons-betwixt'}, {value: 'commons-chain'}, {value: 'commons-cli'}, {value: 'commons-codec'}, {value: 'commons-collections'}, {value: 'commons-configuration'}, {value: 'commons-daemon'}, {value: 'commons-dbcp'}, {value: 'commons-digester'}, {value: 'commons-discovery'}, {value: 'commons-el'}, {value: 'commons-email'}, {value: 'commons-fileupload'}, {value: 'commons-httpclient'}, {value: 'commons-io'}, {value: 'commons-jelly'}, {value: 'commons-jexl'}, {value: 'commons-jrcs'}, {value: 'commons-jxpath'}, {value: 'commons-lang'}, {value: 'commons-logging'}, {value: 'commons-math'}, {value: 'commons-net'}, {value: 'commons-pool'}, {value: 'commons-primitives'}, {value: 'commons-ssl'}, {value: 'commons-validator'}, {value: 'commons-vfs'}, {value: 'concurrent'}, {value: 'cors-filter'}, {value: 'cssparser'}, {value: 'csv'}, {value: 'cz'}, {value: 'datafile'}, {value: 'db4o'}, {value: 'de'}, {value: 'displaytag'}, {value: 'dnsjava'}, {value: 'dom4j'}, {value: 'doxia'}, {value: 'dumbster'}, {value: 'easymock'}, {value: 'eclipse'}, {value: 'edu'}, {value: 'ehcache'}, {value: 'emma'}, {value: 'enginz-facebook'}, {value: 'enginz-linkedin'}, {value: 'eu'}, {value: 'excalibur-datasource'}, {value: 'excalibur-instrument'}, {value: 'excalibur-logger'}, {value: 'excalibur-pool'}, {value: 'exml'}, {value: 'external'}, {value: 'fakepath'}, {value: 'fang'}, {value: 'fast-md5'}, {value: 'fck-faces'}, {value: 'findbugs'}, {value: 'flex'}, {value: 'flexformatter'}, {value: 'flexlib'}, {value: 'fr'}, {value: 'freemarker'}, {value: 'geronimo-spec'}, {value: 'glue'}, {value: 'gnu-getopt'}, {value: 'gnu'}, {value: 'gr'}, {value: 'greenhopper'}, {value: 'groovy'}, {value: 'group-a'}, {value: 'gsbase'}, {value: 'halogenware'}, {value: 'heyesh'}, {value: 'hibernate'}, {value: 'hsqldb'}, {value: 'htmlunit'}, {value: 'httpunit'}, {value: 'i18nlog'}, {value: 'ibm'}, {value: 'info'}, {value: 'io'}, {value: 'isorelax'}, {value: 'it'}, {value: 'itext'}, {value: 'jacorb'}, {value: 'jakarta-regexp'}, {value: 'jalopy'}, {value: 'janino'}, {value: 'jargs'}, {value: 'jasperreports'}, {value: 'java'}, {value: 'java3d'}, {value: 'javacc'}, {value: 'javacvs'}, {value: 'javaee'}, {value: 'javapns'}, {value: 'javassist'}, {value: 'javatar'}, {value: 'javax'}, {value: 'javolution'}, {value: 'jaxen'}, {value: 'jaxme'}, {value: 'jboss'}, {value: 'jcharts'}, {value: 'jcifs'}, {value: 'jdbc'}, {value: 'jdic'}, {value: 'jdom'}, {value: 'jetty'}, {value: 'jexcelapi'}, {value: 'jfree'}, {value: 'jgoodies'}, {value: 'jgoogleanalytics'}, {value: 'jgrapht'}, {value: 'jgroups'}, {value: 'jivesoftware'}, {value: 'jline'}, {value: 'jmagick'}, {value: 'jmimemagic'}, {value: 'jmock'}, {value: 'joda-time'}, {value: 'josso'}, {value: 'jotm'}, {value: 'js'}, {value: 'jsch'}, {value: 'jstl'}, {value: 'jta'}, {value: 'jtidy'}, {value: 'junit-addons'}, {value: 'junit'}, {value: 'junitperf'}, {value: 'jython'}, {value: 'jzlib'}, {value: 'kxml2'}, {value: 'ldapsdk'}, {value: 'log4j'}, {value: 'logkit'}, {value: 'ma'}, {value: 'maven-plugins'}, {value: 'me'}, {value: 'mockobjects'}, {value: 'morena'}, {value: 'msv'}, {value: 'mx4j'}, {value: 'mysql'}, {value: 'nekohtml'}, {value: 'net'}, {value: 'nu'}, {value: 'nz'}, {value: 'oauth'}, {value: 'ognl'}, {value: 'ojdbc'}, {value: 'opensaml'}, {value: 'opensymphony'}, {value: 'oracle'}, {value: 'org'}, {value: 'oro'}, {value: 'oscache'}, {value: 'osuser'}, {value: 'oswego-concurrent'}, {value: 'osworkflow'}, {value: 'ots-jts'}, {value: 'oy-lm'}, {value: 'p6spy'}, {value: 'picocontainer'}, {value: 'pl'}, {value: 'plexus'}, {value: 'pmd'}, {value: 'poi'}, {value: 'postgresql'}, {value: 'progress'}, {value: 'pull-parser'}, {value: 'qdox'}, {value: 'quartz'}, {value: 'radeox'}, {value: 'redis'}, {value: 'regexp'}, {value: 'relaxngDatatype'}, {value: 'rhino'}, {value: 'ro'}, {value: 'rome'}, {value: 'ru'}, {value: 'rubygems'}, {value: 'saxon'}, {value: 'saxpath'}, {value: 'servletapi'}, {value: 'sh'}, {value: 'slide'}, {value: 'soap'}, {value: 'software'}, {value: 'springscim'}, {value: 'spy'}, {value: 'sslext'}, {value: 'statcvs'}, {value: 'stax-utils'}, {value: 'stax'}, {value: 'struts-menu'}, {value: 'sun-jaxb'}, {value: 'sun'}, {value: 'swt'}, {value: 'taglibs'}, {value: 'tanukisoft'}, {value: 'tk'}, {value: 'tomcat'}, {value: 'totvs-ajaxserver'}, {value: 'totvs-connect'}, {value: 'totvs-crmutils'}, {value: 'totvs-ecm-Dtsul11Adapter'}, {value: 'totvs-ecm-emshradapter'}, {value: 'totvs-ecm-ws-client'}, {value: 'totvs-ecm3ejb'}, {value: 'totvs-license-manager-datasul'}, {value: 'totvs-licensecontroller'}, {value: 'trove'}, {value: 'truezip'}, {value: 'tv'}, {value: 'tw'}, {value: 'tycho'}, {value: 'uk'}, {value: 'urbanophile'}, {value: 'us'}, {value: 'velocity-tools'}, {value: 'velocity'}, {value: 'webwork'}, {value: 'werken-xpath'}, {value: 'woodstox'}, {value: 'ws-commons'}, {value: 'wsdl4j'}, {value: 'wsrf'}, {value: 'wss-ejb'}, {value: 'wss4j'}, {value: 'wutka-dtdparser'}, {value: 'xalan'}, {value: 'xapool'}, {value: 'xbean'}, {value: 'xerces'}, {value: 'xfire'}, {value: 'xml-apis'}, {value: 'xml-resolver'}, {value: 'xml-security'}, {value: 'xmlbeans'}, {value: 'xmlenc'}, {value: 'xmlpull'}, {value: 'xmlrpc'}, {value: 'xmlunit'}, {value: 'xom'}, {value: 'xpp3'}, {value: 'xsddoc'}, {value: 'xstream'}],
    	  datumTokenizer: function(d) {
    	    return Bloodhound.tokenizers.whitespace(d.value);
    	  },
    	  queryTokenizer: Bloodhound.tokenizers.whitespace
    	});

    	engine.initialize();

    	$('#tokenfield-typeahead').tokenfield({
    	  typeahead: [null, { source: engine.ttAdapter() }]
    	});
    	
});

$(document).ready(function(){
    $('#forrrrrrrm').on('submit', function(e){
        e.preventDefault();
        ConsultaPropostaTdi.getWidgets();
    });
});


var ConsultaPropostaTdi = SuperWidget.extend({
	instanceId: null,
	
	bindings: {
		local: {
		},
		global: {
			'btn-consulta-proposta': ['click_consultaProposta'],
			'btn-consulta-cliente': ['click_consultaCliente'],
			'btn-generator': ['click_getWidgets'],
		}
	},

	init: function() {
		console.log("init totvs_consulta_propostaObj ");
		
    },
    
    consultaProposta: function() {
		console.log("click btn-consulta-proposta:" + $("#propostaId").val() + ":");
		
		if ($("#propostaId").val() == "") {
			$("#labelMessage").html("Informe o c&oacute;digo da proposta");
			$('#modalProposta').modal('show');
			return;
		}
		
		var loading = "<tr><td colspan='6'><i class='fa fa-refresh fa-spin'></i>&nbsp;Buscando historico da proposta ...</td></tr>";
		$("#tableResultConsulta > tbody").html("");		
		$("#tableResultConsulta tbody").append(loading);
		
		this.getPropostas($("#propostaId").val());
		
    },
    
    consultaCliente: function() {
		console.log("click btn-consulta-cliente:" + $("#clienteCode").val() + ":");
		
		if ($("#clienteCode").val() == "") {
			$("#labelMessage").html("Informe o cliente");
			$('#modalProposta').modal('show');
			return;
		}
		
		var loading = "<tr><td colspan='6'><i class='fa fa-refresh fa-spin'></i>&nbsp;Buscando historico do cliente ...</td></tr>";
		$("#tableResultConsulta > tbody").html("");		
		$("#tableResultConsulta tbody").append(loading);
		
		this.getCliente($("#clienteCode").val());
		
    },
    
	getWidgets: function() {
		
		
		console.log(url);
		var datakeys = $('#tokenfield-typeahead').val();
		var packageName = $('#groupId').val();
		var nameApp = $('#artifactId').val();
		var versionFluig = $('#selectVersion').val();
		
		var url = "/totvs_tdi_secure_credentials/api/rest/generate/widget/?dependencies=" + datakeys + "&nameApp=" + nameApp + "&packageName=" + packageName + "&versionFluig=" + versionFluig; 
		
		$.ajax({
			type: "POST",
			dataType: "json",
			url: url,
			contentType: "application/json",
			success: function (data, status, xhr) {
				console.log("SUCESSO");
				$("#myElem").show();
	               setTimeout(function() { $("#myElem").hide(); }, 5000)	
			}
		});
		
		var url2 = "/totvs_tdi_secure_credentials/api/rest/generate/get/
		
		$.ajax({
			type: "GET",
			dataType: "json",
			url: url2,
			success: function (data, status, xhr) {
				console.log("SUCESSO");
				$("#myElem").show();
	               setTimeout(function() { $("#myElem").hide(); }, 5000);
          
            	  // console.log(data.value);
						//document.href = data.content;
			
			}
		});
		
		
	},
		
	getCliente: function(cliente) {
		
		var params = { "proposta": cliente, "userCode": WCMAPI.userCode };
		
		$.ajax({
			type: "POST",
			dataType: "json",
			url: "/totvs_tdi_consulta_desconto/api/rest/fluig/list/propose-customer",
			contentType: "application/json",
			data: JSON.stringify(params),
			success: function (data, status, xhr) {
				var dataArray1 = $.parseJSON(data.content);
				
				console.log("dataArray1", dataArray1);

				$("#tableResultConsulta > tbody").html("");		
				jQuery.each(dataArray1, function(i, val) {
					console.log("dataArray1", i, val);
					
					var icon = "<button type='button' class='btn btn-warning' title='Aguardando resposta'><span class='glyphicon glyphicon-question-sign'></span></button>";
					if (val.STATUS == "Aprovado") { icon = "<button type='button' class='btn btn-success' title='Aprovado'><span class='glyphicon glyphicon-ok-sign'></span></button>"; }
					else if (val.STATUS == "Reprovado") { icon = "<button type='button' class='btn btn-danger' title='Reprovado'><span class='glyphicon glyphicon-remove-sign'></span></button>"; }
					
					var tipo = '';
					if (val.TIPO == "Finalizado") { tipo = 'class="info"'; }
					
					var html = "<tr>" +
							"<td style='text-align: center'>" + icon + "</td>" + 
							"<td>" +  val.PROPOSTA + "</td>" +
							"<td>" + val.CLIENTE + "</td>" +
							"<td>" + i + "</td>" +
							"<td>" + val.RESPONSAVEL + "</td>" + 
							"<td>" + val.HISTORICO + "</td>" +
							"</tr>"; 
					$("#tableResultConsulta tbody").append(html);
					
				});
					
			}
		});
		
	}
	
    
});
