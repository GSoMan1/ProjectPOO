<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>
<%@ page pageEncoding="UTF-8" %>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <form method="post" accept-charset="UTF-8">
                <input type="hidden" name="dishid" value="${dish.getId()}">
                <div class="form-group">
                    <label for="dishtitle">Titre plat</label>
                    <input type="text" class="form-control" id="dishtitle" name="dishtitle" value="${dish.getTitle()}">
                </div>
                <div class="form-group">
                    <label for="dishdescription">Description plat</label>
                    <textarea class="form-control" id="dishdescription" name="dishdescription" rows="3">${dish.getDescription()}</textarea>
                </div>
                <div class="form-group">
                    <label for="dishtitle">Prix plat</label>
                    <input type="text" class="form-control" id="dishprice" name="dishprice" value="${dish.getPrice()}">
                </div>
                <div class="form-group">
                    <label for="dishcatid">Categorie</label>
                    <select class="form-control" id="dishcatid" name="dishcatid">
                        <c:forEach items="${categories}" var="category">
                            <c:choose>
                                <c:when test="${catid == category.getId()}">
                                    <option value="${category.getId()}" selected>${category.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.getId()}">${category.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit">OK</button>
                </div>
            </form>
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->

<%@include file="../templates/footer.jsp"%>