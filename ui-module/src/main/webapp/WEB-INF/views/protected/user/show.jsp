<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<form name="userForm" action="${pageContext.request.contextPath}/protected/listUsers.htm" method="post">
<br/><br/>
	<table class="sectionTable">
		<tr>
			<td class="blueHdrBgWhtTxt"><s:message code="label.create.user"/></td>
		</tr>
	</table>
	<br/>
	<table border="0" width="80%" style="padding-left:30px; padding-right:30px;">
		<tr>
			<td>
				<fieldset id="fieldSetStyle">
			   		<legend id="legendStyle"><s:message code="label.user.details"/></legend>
			   		<br/>	
					<table border="0" style="padding-left:25px;"">
						<tr>
							<td></td>
							<td class="entryError">
							</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.user.name"/>: </td>
							<td class="entryInput">${user.userName}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.password"/>: </td>
							<td class="entryInput">${user.userPassword}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.role"/>: </td>
							<td class="entryInput"><s:message code="${user.role}"/></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.first.name"/>: </td>
							<td class="entryInput">${user.firstName}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.last.name"/>: </td>
							<td class="entryInput">${user.middleName}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.last.name"/>: </td>
							<td class="entryInput">${user.lastName}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.email.address"/>: </td>
							<td class="entryInput">${user.emailAddress}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.phone.number"/>: </td>
							<td class="entryInput">${user.phoneNumber}</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.enabled"/> </td>
							<td class="entryInput">
								${user.enabled}
							</td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.account.non.expired"/> </td>
							<td class="entryInput">
								${user.accountNonExpired}
							</td>			
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.account.non.locked"/> </td>
							<td class="entryInput">
								${user.accountNonLocked}
							</td>			
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td class="textLabelRight"><s:message code="label.credentials.non.expired"/> </td>
							<td class="entryInput">
								${user.credentialsNonExpired}
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
			<td width="380">&nbsp;</td>
			<td align="left">
				<input type="submit" name="createUser" value="     OK    " />
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>						
	</table>
</form>