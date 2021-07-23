<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="symbols" required="true" rtexprvalue="true"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<table class="pure-table">
    <thead>
        <tr>
            <th>#</th>
            <th>Symbol</th>
            <th>Name</th>
            <th>Price</th>
            <th>Change</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach varStatus="status" var="symbol" items="${fn:split(symbols, ',')}" >
            <%-- jsp:useBean 就是new MyStock()的意思 --%>
            <jsp:useBean class="com.web.tag.utils.MyStock" id="myStock" />
            <%-- jsp:setProperty 就是設定 name就是物件 property是他的屬性 param代?號參數  --%>
            <jsp:setProperty name="myStock" property="symbol" value="${symbol}" />
            <tr ${status.index % 2==0 ? "class = 'pure-table-odd' ":""}>
                <td>${status.index}</td>
                <td>${symbol}</td>
                <td>${myStock.name}</td>
                <td style="color:${myStock.color}">${myStock.price}</td>
                <td style="color:${myStock.color}">${myStock.change}</td>
            </tr>
        </c:forEach >
    </tbody>
</table>