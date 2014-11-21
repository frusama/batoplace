<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function resetFocus() {
		document.getElementById("passwordId").focus();
	}
</script>

<form name="userForm" action="${pageContext.request.contextPath}/protected/updateUser.htm" method="post">
<br/><br/>
	<table class="sectionTable">
		<tr>
			<td class="blueHdrBgWhtTxt"><s:message code="label.update.user"/></td>
		</tr>
	</table>
	<br/>
	<table border="0" width="80%" style="padding-left:30px; padding-right:30px;">
		<tr>
			<td>
				<fieldset id="fieldSetStyle">
			   		<legend id="legendStyle"><s:message code="label.user.account"/></legend>
			   		<br/>	
					<table border="0" style="padding-left:25px;"">
						<tr>
							<td></td>
							<td class="entryError">
							</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.user.name"/>: </td>
							<td class="entryInput"><input type="text" name="userName" id="userNameId" value="${user.userName}" maxLength="16" size="25" onfocus="resetFocus()" readonly /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.password"/>: </td>
							<td class="entryInput"><input type="text" name="userPassword" id="passwordId" value="${user.userPassword}" maxLength="16" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.role"/>: </td>
							<td class="entryInput">
								<form:select path="user.role">
									<form:options items="${userRoles}" itemLabel="label" itemValue="value"/>
								</form:select>
							</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.first.name"/>: </td>
							<td class="entryInput"><input type="text" name="firstName" value="${user.firstName}" maxLength="100" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.middle.name"/>: </td>
							<td class="entryInput"><input type="text" name="${user.middleName}" maxLength="100" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.last.name"/>: </td>
							<td class="entryInput"><input type="text" name="lastName" value="${user.lastName}" maxLength="100" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.email.address"/>: </td>
							<td class="entryInput"><input type="text" name="emailAddress" id="email" value="${user.emailAddress}" maxLength="100" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.phone.number"/>: </td>
							<td class="entryInput"><input type="text" name="phoneNumber" value="${user.phoneNumber}" maxLength="20" size="25" /></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.enabled"/> </td>
							<td class="entryInput">
								<form:radiobutton path="user.enabled" value="true"/><s:message code="label.true"/>
								<form:radiobutton path="user.enabled" value="false"/><s:message code="label.false"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.account.non.expired"/> </td>
							<td class="entryInput">
								<form:radiobutton path="user.accountNonExpired" value="true"/><s:message code="label.true"/>
								<form:radiobutton path="user.accountNonExpired" value="false"/><s:message code="label.false"/>
							</td>			
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.account.non.locked"/> </td>
							<td class="entryInput">
								<form:radiobutton path="user.accountNonLocked" value="true"/><s:message code="label.true"/>
								<form:radiobutton path="user.accountNonLocked" value="false"/><s:message code="label.false"/>
							</td>			
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><span class="requiredField">* </span><s:message code="label.credentials.non.expired"/> </td>
							<td class="entryInput">
								<form:radiobutton path="user.credentialsNonExpired" value="true"/><s:message code="label.true"/>
								<form:radiobutton path="user.credentialsNonExpired" value="false"/><s:message code="label.false"/>
							</td>			
						</tr>
					</table>
					<br/>
				</fieldset>
			</td>
		</tr>
	</table>
	<br/>
	<table border="0">
		<tr>
			<td width="180"></td>
			<td align="left">
				<input type="submit" name="updateUser" value="Submit" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="cancelUpdateUser" value="Cancel" />
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>						
	</table>
</form>

<script language="javascript">
	document.getElementById('passwordId').focus();
</script>