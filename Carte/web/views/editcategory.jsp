<%@include file="../templates/header.jsp"%>
<%@include file="../templates/navigation.jsp"%>

<div class="container contenu"><!-- container -->
    <main class="row justify-content-center">
        <div class="col-6"><!-- col-6 -->
            <form method="post">
                <input type="hidden" name="categoryid" value="${category.getId()}">
                <div class="form-group">
                    <label for="catname">Nom Categorie</label>
                    <input type="text" class="form-control" id="catname" name="catname" value="${category.getName()}">
                </div>
                <div class="form-group">
                    <button type="submit">Save</button>
                </div>
            </form>
        </div><!-- fin col-6 -->
    </main>
</div>
<!-- fin container -->

<%@include file="../templates/footer.jsp"%>