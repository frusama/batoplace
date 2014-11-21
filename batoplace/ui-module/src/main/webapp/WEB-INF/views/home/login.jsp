<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<center>
	<br /><br /><br /><br />
<div id="site_content">	
	<div id="content">
		<div class="content_item">
			<div class="content_container" style="width:800px; height:200px;">
				<br/><br/><br/>
				<form name="logonForm" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="color:red" colspan="2"></td>
						</tr>
						<tr>
							<td class="entryText"><s:message code="label.user.name"/> : &nbsp;&nbsp;</td>
							<td class="entryInput"><input type="text" name="j_username" id="j_username" size="30" /></td>
						</tr>
						<tr>
							<td class="entryText"><s:message code="label.password"/> : &nbsp;&nbsp;</td>
							<td class="entryInput" style="padding-top:4px;"><input type="password" name="j_password" id="j_password" size="30" /></td>
						</tr>
				    </table>
				    <br/>
					<table border="0">
						<tr>
							<td><pre>             </pre></td>
							<td align="left"><input type="submit" name="submit" value="submit"  /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>							
						<tr>
							<td class="comment" colspan="2"></td>
						</tr>							
					</table>
				</form>
			</div>
		</div><!--close content_item-->
	</div><!--close content-->
</div><!--close site_content-->
	<script type="text/javascript">
		document.getElementById("j_username").focus();
	</script>
	<br /><br /><br /><br />
</center>