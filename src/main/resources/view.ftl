<div class="wcm-widget-class super-widget fluig-style-guide" id="consultaDesconto_${instanceId}" data-params="ConsultaPropostaTdi.instance({instanceId: '${instanceId!''}'})" >
<style>
  formtokenfield {
    min-height: 34px!important;
    height: auto!important;
  }
</style>
<form>
<div id="consultaDesconto" class="bootstrap">
<div clas="row">
	
	<div class="col-sm-12 col-md-6">
		<h2>Project Metadata</h2>
		<p>Artifact coordinates</p>
		<div class="form-group groupid-form-group">
			<label for="groupId" class="control-label">Group</label>
			<input tabindex="3" id="groupId" class="form-control" type="text"
				value="com.example" name="groupId">
		</div>
		<div class="form-group artifactid-form-group">
			<label for="artifactId" class="control-label">Artifact</label>
			<input tabindex="4" id="artifactId" class="form-control" type="text"
				value="demo" name="artifactId">
		</div>
		
	</div>

	<div class="col-sm-12 col-md-6">
		<h2>Dependencies</h2>
		<p>Add Spring Boot Starters and dependencies to your application</p>
		<div class="form-group">
			<label for="autocomplete" class="control-label">Search for dependencies</label>
			<span class="twitter-typeahead" style="position: relative; display: inline-block;">
						
					<input type="text" class="form-control1" id="tokenfield" value="red,green,blue" />
						
						<pre aria-hidden="true"
							style="position: absolute; visibility: hidden; white-space: pre; font-family: monospace; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; word-spacing: 0px; letter-spacing: 0px; text-indent: 0px; text-rendering: auto; text-transform: none;">spring</pre>
						<div class="tt-menu tt-empty"
							style="position: absolute; top: 100%; left: 0px; z-index: 100; display: none;">
							<div class="tt-dataset tt-dataset-starters"></div>
						</div>
			</span>
		</div>
	</div>
		
</div>
</div>


</form>
	<!-- <div id="consultaDesconto" class="bootstrap">
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
  	</div> -->
</div>
