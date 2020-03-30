<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <form>
                <input type="hidden" name="categoryid" value="${category.getId()}">
                <div class="form-group">
                    <label for="catname">Nom Categorie</label>
                    <input type="text" class="form-control" id="catname" placeholder="name@example.com">
                </div>
                <div class="form-group">
                    <button type="submit">OK</button>
                </div>
                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleFormControlSelect1">Example select</label>--%>
                <%--                    <select class="form-control" id="exampleFormControlSelect1">--%>
                <%--                        <option>1</option>--%>
                <%--                        <option>2</option>--%>
                <%--                        <option>3</option>--%>
                <%--                        <option>4</option>--%>
                <%--                        <option>5</option>--%>
                <%--                    </select>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label for="exampleFormControlTextarea1">Example textarea</label>--%>
                <%--                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>--%>
                <%--                </div>--%>
            </form>
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->

<%@include file="../templates/footer.jsp"%>