$( document ).ready(function() {
    console.log( "ready!" );
    $('#tokenfield').tokenfield({
    	  autocomplete: {
    	    source: ['red','blue','green','yellow','violet','brown','purple','black','white'],
    	    delay: 100
    	  },
    	  showAutocompleteOnFocus: true
    	});
    
    $('.tokenfield.form-control').addClass( "formtokenfield" );
});

var ConsultaPropostaTdi = SuperWidget.extend({
	instanceId: null,
	
	bindings: {
		local: {
		},
		global: {
			'btn-consulta-proposta': ['click_consultaProposta'],
			'btn-consulta-cliente': ['click_consultaCliente'],
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
    
	getPropostas: function(proposta) {
		
		var url = "/totvs_tdi_consulta_desconto/api/rest/fluig123/list/propose-summary/" + proposta + "/" + WCMAPI.userCode; 
		console.log(url);
		
		
		$.ajax({
			type: "POST",
			dataType: "json",
			url: url,
			contentType: "application/json",
			data: {},
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
							"<td><a href='/portal/p/10097/pagecentraltask?app_ecm_centraltask_detailsProcessInstanceID=" + i + "' target='_black'>" + i + "</a></td>" +
							"<td>" + val.RESPONSAVEL + "</td>" + 
							"<td>" + val.HISTORICO + "</td>" +
							"</tr>"; 
					$("#tableResultConsulta tbody").append(html);
					
				});
					
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
