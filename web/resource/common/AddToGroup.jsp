<%@ page language="java" %>
<%@ page errorPage="/common/Error.jsp" %>
<%@ taglib uri="struts-html-el" prefix="html" %>
<%@ taglib uri="struts-tiles" prefix="tiles" %>
<%@ taglib uri="jstl-fmt" prefix="fmt" %>
<%@ taglib uri="jstl-c" prefix="c" %>
<%--
  NOTE: This copyright does *not* cover user programs that use HQ
  program services by normal system calls through the application
  program interfaces provided as part of the Hyperic Plug-in Development
  Kit or the Hyperic Client Development Kit - this is merely considered
  normal use of the program, and does *not* fall under the heading of
  "derived work".
  
  Copyright (C) [2004-2008], Hyperic, Inc.
  This file is part of HQ.
  
  HQ is free software; you can redistribute it and/or modify
  it under the terms version 2 of the GNU General Public License as
  published by the Free Software Foundation. This program is distributed
  in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
  even the implied warranty of MERCHANTABILITY or FITNESS FOR A
  PARTICULAR PURPOSE. See the GNU General Public License for more
  details.
  
  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
  USA.
 --%>


<tiles:importAttribute name="resource" ignore="true" />

<div id ="add_to_group_dialog" style="display:none;">
    <form name="AddToGroupForm" action="" onsubmit="return false;">
	<input type="hidden" name="eid" value="<c:if test="${not empty resource.entityId}"><c:out value="${resource.entityId}"/></c:if>" />
	<div id="AddToGroupDataDiv" style="width:250px; height: 100px;">
		<fieldset>
			<legend><fmt:message key="resource.group.AddToGroup.Title"/></legend>
			<div style="padding:2px"><input type="radio" id="AddToNewGroupRadioAction" value="addNewGroup" name="radioAction" /><label style="white-space: nowrap"><fmt:message key="resource.group.AddToGroup.NewGroup"/></label></div>
			<div style="padding:2px"><input type="radio" id="AddToGroupRadionAction" value="addToGroup" name="radioAction" /><label style="white-space: nowrap"><fmt:message key="resource.group.AddToGroup.ExistingGroup"/></label></div>
		</fieldset>	
	</div>
    <div id="AddToGroupButtonDiv">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td class="buttonLeft"></td>
				<td class="buttonRight " valign="middle" nowrap="true">
  					<span id="button"><a href="javascript:MyGroupManager.processAction(document.AddToGroupForm);"><fmt:message key="resource.group.AddToGroup.Continue"/></a></span>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>

<script type="text/javascript">
    dojo11.require("dijit.dijit");
    dojo11.require("dijit.Dialog");

    var MyGroupManager = null;
    dojo11.addOnLoad(function(){
    	MyGroupManager = new hyperic.group_manager();
    });

    var AddToGroupMenuLink = dojo11.byId("AddToGroupMenuLink");
    if (AddToGroupMenuLink) {
    	AddToGroupMenuLink.onclick = function() { 
			dojo11.byId("AddToNewGroupRadioAction").checked = "checked";
        	MyGroupManager.dialogs.AddToGroup.show(); 
        	return false; 
        };
    }
</script>