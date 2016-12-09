<div class="wcm-widget-class super-widget fluig-style-guide" id="consultaDesconto_${instanceId}" data-params="ConsultaPropostaTdi.instance({instanceId: '${instanceId!''}'})" >

	<div id="consultaDesconto" class="bootstrap">
		<div class="container">
			<div class="row">
				<div class="col-md-10" role="main">
					<form class="form-horizontal" role="form">
			  			<div class="form-group">
					  		<label for="propostaId" class="col-md-4 control-label">Proposta:</label>
			    			<div class="col-md-6 form-inline">
						  		<input type="text" class="form-control" id="propostaId" placeholder="Código proposta" style="width: 133px">
						  		<button type="button" data-btn-consulta-proposta class="btn btn-success">
				  					<span class="fluigicon fluigicon-verified"></span>
								</button>
							</div>
					  	</div>
			  			<div class="form-group">
					  		<label for="propostaId" class="col-md-4 control-label">Cliente:</label>
			    			<div class="col-md-6 form-inline">
						  		<input type="text" class="form-control" id="clienteCode" placeholder="Código ou nome do cliente" style="width: 233px">
						  		<button type="button" data-btn-consulta-cliente class="btn btn-success">
				  					<span class="fluigicon fluigicon-verified"></span>
								</button>
							</div>
					  	</div>
					</form>
					<table id="tableResultConsulta" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Status</th>
								<th>Proposta</th>
								<th>Cliente</th>
								<th>N&uacute;mero Fluig</th>
								<th>Respons&aacute;vel</th>
								<th>Hist&oacute;rico</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>		
				</div>
			</div>
		</div>
    </div>
	
	<div class="modal fade" id="modalProposta" tabindex="-1" role="dialog" aria-labelledby="modalPropostaLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        			<h4 class="modal-title" id="modalPropostaLabel">Erro</h4>
      			</div>
      		<div class="modal-body">
				<p style="color: #d9534f">
					<i class="fa fa-exclamation-triangle fa-lg"></i>
                  	<span id="labelMessage">Informe o c&oacute;digo da proposta</span>
                </p>
      		</div>
      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      		</div>
   		</div>
  	</div>
</div>
