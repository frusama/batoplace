<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<!--link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" /-->
		
		<title>User List</title>

		<script type="text/javascript" charset="utf-8">
			var	oTable;

			$(document).ready(function() {

			oTable = $('#userTable').dataTable({
					"bJQueryUI": true,
					"sPaginationType": "full_numbers",
					"iDisplayLength" : 25,
					"aaSorting" : [[1, 'asc']],
					"bProcessing": true,
					"sAjaxSource": "listUsers.json",
					"oSearch": {"sSearch": ""},
					"sDefaultContent": "",
					"aoColumns": [
						{
							"mData":"firstName",
							"sTitle": '<s:message code="label.first.name"/>',
							"sWidth": "20%"
						},

						{
							"mData": "middleName",
							"sTitle": '<s:message code="label.middle.name"/>',
							"sWidth": "20%"
						},

						{
							"mData": "lastName",
							"sTitle": '<s:message code="label.last.name"/>',
							"sWidth": "20%"
						},

						{
							"mData": "emailAddress",
							"sTitle": '<s:message code="label.email.address"/>',
							"sWidth": "10%"
						},

						{
							"mData":"phoneNumber",
							"sTitle": '<s:message code="label.phone.number"/>',
							"sWidth": "10%"
						},

						{
							"mData":"lastModified",
							"sTitle": '<s:message code="label.last.modified"/>',
							"sWidth": "15%"
						},

						{
							"mData":"userName",
							"sTitle": "",
							"sWidth": "5%",
							"mRender": function ( userName, type, full )  {
										return  '<a class="edit" href=""><center><img src="${pageContext.request.contextPath}/images/datatable/editIcon.png" title="Edit" height="20px" width="20px" style="cursor: pointer;margin-left:10px;margin-right:10px;"></center></a>';
							}
						}
					]
				});
			});

			$('#userTable_filter input').focus(); 

			function sendAjaxRequest(requestUri) {
				$uriResource = requestUri;

		        var results = $.ajax({
		            type: "POST",
		            url: $uriResource,
		            data: {},
		            dataType: "json",
		            async: false}).responseText;

		        return results;
			}
		</script>
	</head>
	<body>
		<br/><br/>
		<center>
		<div class="demo_jui" style="margin-right:15px; margin-left:15px; font-family:Verdana; font-size:12px;">
			<table width="100%" cellpadding="0" cellspacing="0" border="0" class="display" id="userTable">
				<thead>
					<tr>
						<th style="font-weight:bold; text-align:left;">1</th>
						<th style="font-weight:bold; text-align:left;">2</th>
						<th style="font-weight:bold; text-align:left;">3</th>
						<th style="font-weight:bold; text-align:left;">4</th>
						<th style="font-weight:bold; text-align:left;">5</th>
						<th style="font-weight:bold; text-align:left;">6</th>
						<th>7</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<br/><br/><br/>
		</center>
		
	</body>
</html>

<br/><br/><br/><br/>