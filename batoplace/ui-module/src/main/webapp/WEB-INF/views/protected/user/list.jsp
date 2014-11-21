<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<form name="userListForm" action="listUsers.htm">
	<br/>
	<table border="0" width="100%">
		<tr>
			<td style="padding-left:25px; padding-right:45px; text-align:right;"><a href="${pageContext.request.contextPath}/protected/initCreateUser.htm"><img src="${pageContext.request.contextPath}/images/add.png" /></a></td>
		</tr>
	</table>
	<table width="100%" bgcolor="white">
		<tr>
			<td style="padding-left: 14px; padding-right: 8px;">
				<div id="results"> 
					<%
						out.println(request.getAttribute("results"));
					%>
				</div>
			    
			    <script type="text/javascript">
			         function onInvokeAction(id, action) {
			             setExportToLimit(id, '');
			             if (action == 'sort') {
			            		var limit = jQuery.jmesa.getTableFacade(id).limit;
			            		var sortSet = limit.getSortSet();
			            		if (sortSet) {
			            			var sort = limit.sortSet[limit.sortSet.length - 1];
			            			removeAllSortsFromLimit(id);
			            			limit.sortSet[0] = sort;
			            		}
			             } 
			             createHiddenInputFieldsForLimitAndSubmit(id);
			         }

			         function onInvokeExportAction(id) {
			        	    var parameterString = createParameterStringForLimit(id);
			        	    location.href = '${pageContext.request.contextPath}/protected/listUsers.htm?' + parameterString;
			         }
			     </script>		
			</td>
		</tr>
	</table>
	<br/><br/>
</form>