<%-- 
    Document   : table
    Created on : 12.04.2012, 15:29:50
    Author     : rainer
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Field"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<jsp:useBean id="gameInfo" class="model.GameInformation" scope="session"/> 
<jsp:setProperty name="gameInfo" property="*"/>
<jsp:useBean id="wuerfel" class="model.Cube" scope="session"/>
<jsp:setProperty name="wuerfel" property="*"/>
<jsp:useBean id="fieldMap" class="model.FieldMap" scope="session"/>
<jsp:setProperty name="fieldMap" property="*"/>
<html xmlns="http://www.w3.org/1999/xhtml"  xml:lang="de" lang="de">
	<head>
		<title>EWA Mensch &auml;rgere Dich nicht :: Spiel 1</title>
		<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=iso-8859-1"/>
		<meta name="description" content="Das EWA Mensch &auml;rgere Dich nicht, ein Spa&szlig; der niemals endet."/>
		<meta name="keywords" content="Spiel EWA Mensch &auml;rgere Dich nicht"/>
		<meta name="language" content="de-AT"/>
		<link rel="stylesheet" type="text/css" href="styles/screen.css"/>
        <script language="javascript">

<!-- JavaScript Code fuer Browser, die kein Scripting unterstuetzen ausblenden


// JavaScript Funktion zum Anzeigen des Textes
function callServlet()
{
  document.location.href = "GameServlet?action=wuerfeln"; 
}

// Ende der JavaScript Sektion -->
</script>                            
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div id="teaser"></div>
				<div id="logo"></div>
				<h1>EWA Mensch &auml;rgere Dich nicht</h1>
			</div>
			<ul class="accessibility">
				<li><a href="#navigation" accesskey="2">Navigation</a></li>
				<li><a href="#board" accesskey="0">Spielbrett</a></li>
				<li><a href="#dicearea" accesskey="1">W&uuml;rfel</a></li>
				<li><a href="#info_area" accesskey="3">Spielstand</a></li>
			</ul>
			<div id="body">
				<div id="navigation">
					<h2 class="accessibility">Navigation</h2>
					<ul>
						<li><a href="#">Userdaten &auml;ndern</a></li>
						<li><a href="#">Zur&uuml;ck zur Lounge</a></li>
						<li><a href="#">Ausloggen</a></li>
					</ul>
				</div>
				<hr class="accessibility" />				
				<div id="info_area">
                                    <% if (gameInfo.getFinished()) {%> 
                                        <form action="GameServlet" method="POST">
                                        <input type="submit" value="Restart Game" accesskey="r"/>
                                        </form>
                                    <% } %>
                                        <h2>Spielinformationen</h2>
					<table class="game_info" summary="Diese Tabelle zeigt Informationen zum aktuellen Spiel">
						<tbody>
							<tr class="accessibility">
								<th>Information</th>
								<th>Wert</th>
							</tr>
							<tr>
								<th>Anzahl Spieler</th>
								<td><%= gameInfo.getNumberOfPlayers() %></td>
							</tr>
							<tr>
								<th>F&uuml;hrender</th>
								<td>mehrere</td>
							</tr>
							<tr>
								<th>Aktuelle Runde</th>
								<td><%= gameInfo.getRound() %></td>
							</tr>
							<tr>
								<th>Zeit</th>
								<td><%= gameInfo.getTime() %></td><!--0 min, 0 sec</td>-->
							</tr>
						</tbody>
					</table>
					<h2>Spieler</h2>
					<table class="game_info" summary="Diese Tabelle listet die Namen der Spieler auf">
						<tbody>
							<tr class="accessibility">
								<th>Spielernummer</th>
								<th>Spielername</th>
							</tr>
							<tr>
								<th>Spieler 1</th>
								<td><%= gameInfo.getPlayerById("Spieler 1").getName() %></td>
							</tr>
							<tr>
								<th>Spieler 2</th>
								<td><%= gameInfo.getPlayerById("Spieler 2").getName() %></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="dicearea">
					<hr class="accessibility" />
					<h2 class="accessibility">W&uuml;rfel</h2>
					<span title='aktueller Spieler'>Super Mario</span>
                                        <img name="wuerfel" title="<%= wuerfel.getTitle() %>" src="<%= wuerfel.getSrc() %>" alt="<%= wuerfel.getAlt() %>" onclick="callServlet()"/>
				</div>
				<div id="play_area">
					<hr class="accessibility" />
					<div id="board">
						<h2 class="accessibility">Spielbrett</h2>
						<div class="fields">
							<h3 class="accessibility">Spielfelder</h3>
							<ol title="Spielfelder">
                                                            <%
                                                                List<Field> bla = fieldMap.getFieldList();
                                                                for (Field i: bla) {%>
                                                            
                                                                    <li><img id="<%=i.getId() %>" src="<%=i.getSrc() %>" alt="<%=i.getAlt() %>" title="<%=i.getTitle() %>" /></li>
                                                                
                                                                <%}
                                                            %>
							</ol>
							<h3 class="accessibility">Starth&auml;user</h3>
							<ol title="Starthaus Spieler 1">
                                                            <%
                                                                List<Field> homep1 = gameInfo.getPlayerById("Spieler 1").getHomeMap().getFieldList();
                                                                for (Field i: homep1) {%>
                                                            
                                                                    <li><img id="<%=i.getId() %>" src="<%=i.getSrc() %>" alt="<%=i.getAlt() %>" title="<%=i.getTitle() %>" /></li>
                                                                
                                                                <%}
                                                            %>
								<!--<li><img id='field41' src='img/field1.png' alt='Feld 41: Startfeld Spieler 1' title='Feld 41: Startfeld Spieler 1' /></li>
								<li><img id='field42' src='img/field1.png' alt='Feld 42: Startfeld Spieler 1' title='Feld 42: Startfeld Spieler 1' /></li>
								<li><img id='field43' src='img/field1_player1.png' alt='Feld 43: Startfeld Spieler 1: Spieler 1' title='Feld 43: Startfeld Spieler 1: Spieler 1' /></li>
								<li><img id='field44' src='img/field1.png' alt='Feld 44: Startfeld Spieler 1' title='Feld 44: Startfeld Spieler 1' /></li>
                                                                -->
							</ol>
							<ol title="Starthaus Spieler 2">
                                                            <%
                                                                List<Field> homep2 = gameInfo.getPlayerById("Spieler 2").getHomeMap().getFieldList();
                                                                for (Field i: homep2) {%>
                                                            
                                                                    <li><img id="<%=i.getId() %>" src="<%=i.getSrc() %>" alt="<%=i.getAlt() %>" title="<%=i.getTitle() %>" /></li>
                                                                
                                                                <%}
                                                            %>
								<!--<li><img id='field45' src='img/field2_player2.png' alt='Feld 45: Startfeld Spieler 2: Spieler 2' title='Feld 45: Startfeld Spieler 2: Spieler 2' /></li>
								<li><img id='field46' src='img/field2.png' alt='Feld 46: Startfeld Spieler 2' title='Feld 46: Startfeld Spieler 2' /></li>
								<li><img id='field47' src='img/field2.png' alt='Feld 47: Startfeld Spieler 2' title='Feld 47: Startfeld Spieler 2' /></li>
								<li><img id='field48' src='img/field2.png' alt='Feld 48: Startfeld Spieler 2' title='Feld 48: Startfeld Spieler 2' /></li>
                                                                -->
							</ol>
							<ol title="Starthaus Spieler 3">	
								<li><img id='field49' src='img/field3.png' alt='Feld 49: Startfeld Spieler 3' title='Feld 49: Startfeld Spieler 3' /></li>
								<li><img id='field50' src='img/field3.png' alt='Feld 50: Startfeld Spieler 3' title='Feld 50: Startfeld Spieler 3' /></li>
								<li><img id='field51' src='img/field3.png' alt='Feld 51: Startfeld Spieler 3' title='Feld 51: Startfeld Spieler 3' /></li>
								<li><img id='field52' src='img/field3.png' alt='Feld 52: Startfeld Spieler 3' title='Feld 52: Startfeld Spieler 3' /></li>
							</ol>
							<ol title="Starthaus Spieler 4">	
								<li><img id='field53' src='img/field4.png' alt='Feld 53: Startfeld Spieler 4' title='Feld 53: Startfeld Spieler 4' /></li>
								<li><img id='field54' src='img/field4.png' alt='Feld 54: Startfeld Spieler 4' title='Feld 54: Startfeld Spieler 4' /></li>
								<li><img id='field55' src='img/field4.png' alt='Feld 55: Startfeld Spieler 4' title='Feld 55: Startfeld Spieler 4' /></li>
								<li><img id='field56' src='img/field4.png' alt='Feld 56: Startfeld Spieler 4' title='Feld 56: Startfeld Spieler 4' /></li>
							</ol>
							<h3 class="accessibility">Zielh&auml;user</h3>
							<ol title="Zielhaus Spieler 1">
                                                            <%
                                                                List<Field> h = gameInfo.getPlayerById("Spieler 1").getGoalMap().getFieldList();
                                                                for (Field i: h) {%>
                                                            
                                                                    <li><img id="<%=i.getId() %>" src="<%=i.getSrc() %>" alt="<%=i.getAlt() %>" title="<%=i.getTitle() %>" /></li>
                                                                
                                                                <%}
                                                            %>
								<!--<li><img id='field57' src='img/field1.png' alt='Feld 57: Zielfeld Spieler 1' title='Feld 57: Zielfeld Spieler 1' /></li>
								<li><img id='field58' src='img/field1.png' alt='Feld 58: Zielfeld Spieler 1' title='Feld 58: Zielfeld Spieler 1' /></li>
								<li><img id='field59' src='img/field1.png' alt='Feld 59: Zielfeld Spieler 1' title='Feld 59: Zielfeld Spieler 1' /></li>
								<li><img id='field60' src='img/field1.png' alt='Feld 60: Zielfeld Spieler 1' title='Feld 60: Zielfeld Spieler 1' /></li>
                                                                -->
                                                        </ol>
							<ol title="Zielhaus Spieler 2">	
                                                            <%
                                                                List<Field> h2 = gameInfo.getPlayerById("Spieler 2").getGoalMap().getFieldList();
                                                                for (Field i: h2) {%>
                                                            
                                                                    <li><img id="<%=i.getId() %>" src="<%=i.getSrc() %>" alt="<%=i.getAlt() %>" title="<%=i.getTitle() %>" /></li>
                                                                
                                                                <%}
                                                            %>
								<!--<li><img id='field61' src='img/field2.png' alt='Feld 61: Zielfeld Spieler 2' title='Feld 61: Zielfeld Spieler 2' /></li>
								<li><img id='field62' src='img/field2.png' alt='Feld 62: Zielfeld Spieler 2' title='Feld 62: Zielfeld Spieler 2' /></li>
								<li><img id='field63' src='img/field2.png' alt='Feld 63: Zielfeld Spieler 2' title='Feld 63: Zielfeld Spieler 2' /></li>
								<li><img id='field64' src='img/field2.png' alt='Feld 64: Zielfeld Spieler 2' title='Feld 64: Zielfeld Spieler 2' /></li>
                                                                -->
                                                        </ol>
							<ol title="Zielhaus Spieler 3">		
								<li><img id='field65' src='img/field3.png' alt='Feld 65: Zielfeld Spieler 3' title='Feld 65: Zielfeld Spieler 3' /></li>
								<li><img id='field66' src='img/field3.png' alt='Feld 66: Zielfeld Spieler 3' title='Feld 66: Zielfeld Spieler 3' /></li>
								<li><img id='field67' src='img/field3.png' alt='Feld 67: Zielfeld Spieler 3' title='Feld 67: Zielfeld Spieler 3' /></li>
								<li><img id='field68' src='img/field3.png' alt='Feld 68: Zielfeld Spieler 3' title='Feld 68: Zielfeld Spieler 3' /></li>
							</ol>
							<ol title="Zielhaus Spieler 4">		
								<li><img id='field69' src='img/field4.png' alt='Feld 69: Zielfeld Spieler 4' title='Feld 69: Zielfeld Spieler 4' /></li>
								<li><img id='field70' src='img/field4.png' alt='Feld 70: Zielfeld Spieler 4' title='Feld 70: Zielfeld Spieler 4' /></li>
								<li><img id='field71' src='img/field4.png' alt='Feld 71: Zielfeld Spieler 4' title='Feld 71: Zielfeld Spieler 4' /></li>
								<li><img id='field72' src='img/field4.png' alt='Feld 72: Zielfeld Spieler 4' title='Feld 72: Zielfeld Spieler 4' /></li>
							</ol>
						</div>
						<div class="clearer"></div>  
						<div id="infogegner">W&uuml;rfelergebnis Computer: <%= gameInfo.getCubeComputer() %></div>
					</div>
				</div>				
			</div>
			<div id="footer">
				<p>&copy; 2012 EWA Mensch &auml;rgere Dich nicht.</p>
			</div>
        </div>
    </body>
</html>                      
