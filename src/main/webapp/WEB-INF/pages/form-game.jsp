<%@ page import="static com.br.gamestore.config.Constants.GAME_NAME" %>
<%@ page import="static com.br.gamestore.config.Constants.GAME_LEVELS" %>
<%@ page import="com.br.gamestore.model.Game" %>
<%@ page import="static com.br.gamestore.config.Constants.*" %>
<%@ page import="com.br.gamestore.model.GameLevel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD GAME</title>
</head>
<body>
<%
    String messageForm = (String) session.getAttribute(MESSAGE_FORM);
    if (messageForm != null) {
%>
<div><%=messageForm%>
</div>
<%
        session.setAttribute(MESSAGE_FORM, null);
    }
%>

<form method="get" action="../games/find">
    <label for="<%=FIND_GAME_NAME%>">Game Name</label>
    <input type="text" name="<%=FIND_GAME_NAME%>">
    <input type="submit" value="submit">
</form>

<%
    List<Game> search_list = (List<Game>) session.getAttribute(LIST_SEARCH_GAME);
    if (search_list != null) {
%>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>Description</td>
    </tr>
    </thead>
    <tbody>
    <% for (Game game : search_list) {%>
    <tr>
        <td><%=game.getId()%>
        </td>
        <td><%=game.getNome()%>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
<%}%>

<form method="post" action="../game/form">
    <label for="<%=GAME_NAME%>">Name</label>
    <input type="text" name="<%=GAME_NAME%>">
    <label>Difficult</label>
    <select name="<%=GAME_LEVEL_ID%>">
        <%
            List<GameLevel> gameLevels = (List<GameLevel>) session.getAttribute(GAME_LEVELS);
            for (GameLevel gl : gameLevels) {
        %>
        <option value="<%=gl.getId()%>"><%=gl.getDescription()%>
        </option>
        <%
            }
        %>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>
