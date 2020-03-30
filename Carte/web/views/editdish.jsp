<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <form>
                <input type="hidden" name="dishid" value="${dish.getId()}">
                <div class="form-group">
                    <label for="dishtitle">Titre plat</label>
                    <input type="text" class="form-control" id="dishtitle" value="${dish.getTitle()}">
                </div>
                <div class="form-group">
                    <label for="dishdescription">Description plat</label>
                    <textarea class="form-control" id="dishdescription" rows="3">${dish.getDescription()}</textarea>
                </div>
                <div class="form-group">
                    <label for="dishtitle">Prix plat</label>
                    <input type="text" class="form-control" id="dishprice" value="${dish.getPrice()}">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Categorie</label>
                    <select class="form-control" id="exampleFormControlSelect1">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.getId()}">${category.getName()}</option>
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